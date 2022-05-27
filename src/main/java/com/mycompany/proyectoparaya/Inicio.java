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
@WebServlet (name = "Inicio", urlPatterns ={"/Inicio"})
public class Inicio extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("Usuario");
        String password = request.getParameter("Password");
       
        ArrayList<UsuarioAtributos> listausuarios = new ArrayList<UsuarioAtributos>();
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");
                //PreparedStatement stmt = con.prepareStatement("SELECT Correo FROM Usuarios where Correo = ? and Contra = ?");
                Statement stmt = con.createStatement();
                ResultSet  rs = stmt.executeQuery("select * From Usuarios");
               // stmt.setString(1, correo);
               // stmt.setString(2, password);
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
              }
               
            
               //stmt.execute();
               
            // ResultSet rs = stmt.executeQuery();aaa
            // nombre = rs.getString("Correo");
             while(rs.next()){
                     HttpSession miSesion = request.getSession();//guarda datos 
        
                  String nombre = rs.getString("Correo");
                  miSesion.setAttribute("nombre", nombre);
             }
                 
          con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/inicio2.jsp");
        }
         
           //HttpSession miSesion = request.getSession();//guarda datos 
        //miSesion.setAttribute("nombre", nombre);
     
        response.sendRedirect(request.getContextPath() + "/Registro.html");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
