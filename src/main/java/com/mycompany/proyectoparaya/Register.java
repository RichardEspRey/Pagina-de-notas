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
@WebServlet (name = "Register", urlPatterns ={"/Register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("Nombre");
        String Apellidos = request.getParameter("Apellidos");
        String fecha = request.getParameter("Fecha");
        String correo = request.getParameter("CorreoElectronico");
        String username = request.getParameter("Username");
        String password = request.getParameter("Confirmar");
        fecha = "1999-10-08";
        String prueba;
        

    
        
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");    
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuarios (Nombre, Apellidos, Fecha_Nacimiento, Correo, NombreUsuario, Contra,Fecha_Creacion) VALUES (?,?,?,?,?,?,now())");
                stmt.setString(1, nombre);
                stmt.setString(2, Apellidos);
                stmt.setString(3, fecha);
                stmt.setString(4, correo);
                stmt.setString(5, username);
                stmt.setString(6, password);
               
             stmt.execute();
                  //ResultSet rs = stmt.executeQuery();
                  
          /*  PreparedStatement stmt = con.prepareStatement("SELECT Nombre FROM Usuarios where Correo = ? and Contra = ?");
                stmt.setString(1, correo1);
                stmt.setString(2, password2);
               
             
                  ResultSet rs = stmt.executeQuery();
                  while(rs.next()){
                  prueba = rs.getString("Nombre");
                  }*/
                  con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
        
 

     
 
        response.sendRedirect(request.getContextPath() + "/index.html");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("Dato recibido " + nombre);
     
            out.println("</body>");
            out.println("</html>");
        }
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
