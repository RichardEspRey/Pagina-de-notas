/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectoparaya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gil_r
 */
@WebServlet(name = "prueba", urlPatterns = {"/prueba"})
public class prueba extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("Usuario");
        String password = request.getParameter("Password");
        Boolean encontro = null;
       // HttpSession miSesion = request.getSession();//guarda datos 
      // miSesion.setAttribute("Error", "1");
       
        ArrayList<UsuarioAtributos> listausuarios = new ArrayList<UsuarioAtributos>();
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");
                //PreparedStatement stmt = con.prepareStatement("SELECT Correo FROM Usuarios where Correo = ? and Contra = ?");
              
     PreparedStatement stmt = con.prepareStatement("select ID, Nombre, Apellidos, Fecha_Nacimiento, Correo, NombreUsuario, Contra, Fecha_Creacion, Eliminado From Usuarios where Correo = ? and Contra = ? ");
                stmt.setString(1, correo);
                stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
              while (rs.next()){
              UsuarioAtributos usuarios = new UsuarioAtributos();
              usuarios.setId(rs.getInt("ID"));
              usuarios.setNombre(rs.getString("Nombre"));
              usuarios.setApellidos(rs.getString("Apellidos"));
              usuarios.setFecha_Nacimiento(rs.getString("Fecha_Nacimiento"));
              usuarios.setCorreo(rs.getString("Correo"));
              usuarios.setNombreUsuario(rs.getString("NombreUsuario"));
              usuarios.setContra(rs.getString("Contra"));
              usuarios.setFecha_Creacion(rs.getString("Fecha_Creacion"));
              usuarios.setEliminado((Boolean) rs.getBoolean("Eliminado"));
              listausuarios.add(usuarios);
              encontro = true;
            
          
        HttpSession miSesion = request.getSession();//guarda datos 
            miSesion.setAttribute("idusuario", usuarios);
                  
                
            }                        
          con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
         
         
     if(encontro != null){
         
                            
         request.setAttribute("listausuarios", listausuarios);
         request.getRequestDispatcher("/inicio.jsp").forward(request, response);
         // response.sendRedirect(request.getContextPath() + "/inicio.jsp");
     }else{
         response.sendRedirect(request.getContextPath() + "/index.html");
     }
       
         
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
