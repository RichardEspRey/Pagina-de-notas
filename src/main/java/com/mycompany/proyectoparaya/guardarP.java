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
@WebServlet(name = "guardarP", urlPatterns = {"/guardarP"})
public class guardarP extends HttpServlet {

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession miSesion = request.getSession();
         UsuarioAtributos usuario =(UsuarioAtributos)miSesion.getAttribute("idusuario");
       String nombre = request.getParameter("nombre");
       String apellidos = request.getParameter("apellidos");
       String fecha = request.getParameter("fecha");
       String correo = request.getParameter("correo");
       String user = request.getParameter("user");
       String contra = request.getParameter("contra");
       
        int id = usuario.getId();
     ArrayList<UsuarioAtributos> listausuarios = new ArrayList<UsuarioAtributos>();
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");        
           PreparedStatement stmt = con.prepareStatement("Update Usuarios set Nombre = ?, Apellidos = ?, Fecha_Nacimiento = ?, Correo = ?, NombreUsuario = ?, Contra = ?  where ID = ? ");
             stmt.setString(1, nombre);
             stmt.setString(2, apellidos);
             stmt.setString(3, fecha);
             stmt.setString(4, correo);
             stmt.setString(5, user);
             stmt.setString(6, contra);
             stmt.setInt(7, id);

               stmt.execute();
                                   
          con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
           
         request.getRequestDispatcher("/perfil.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
