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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gil_r
 */
public class CreacionNotas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreacionNotas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreacionNotas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String titulo = request.getParameter("titulo");
        String hastag = request.getParameter("hashtag");
        String nota = request.getParameter("nota");
         HttpSession miSesion = request.getSession();
         UsuarioAtributos usuario =(UsuarioAtributos)miSesion.getAttribute("idusuario");
   
        int id = usuario.getId();
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");    
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Notas (ID_User, Titulo,Texto, Fecha_Creacion, hashtag) VALUES (?,?,?,now(),?)");
                stmt.setInt(1, id);
                stmt.setString(2, titulo);
                stmt.setString(3, nota);
                stmt.setString(4, hastag);
              
               
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
        
 
     
     
     
 
        response.sendRedirect(request.getContextPath() + "/NuevaNota.jsp");
      
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
