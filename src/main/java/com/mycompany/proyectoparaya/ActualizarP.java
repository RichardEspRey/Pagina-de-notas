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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gil_r
 */
public class ActualizarP extends HttpServlet {

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
            out.println("<title>Servlet ActualizarP</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActualizarP at " + request.getContextPath() + "</h1>");
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
       HttpSession miSesion = request.getSession();
         UsuarioAtributos usuario =(UsuarioAtributos)miSesion.getAttribute("idusuario");
   
        int id = usuario.getId();
     ArrayList<UsuarioAtributos> listausuarios = new ArrayList<UsuarioAtributos>();
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");        
           PreparedStatement stmt = con.prepareStatement("select ID, Nombre, Apellidos, Fecha_Nacimiento, Correo, NombreUsuario, Contra From Usuarios where ID = ? ");
                stmt.setInt(1, id);

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

              listausuarios.add(usuarios);  
            }                        
          con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
            request.setAttribute("listausuarios", listausuarios);
         request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
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
