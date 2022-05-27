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
@WebServlet(name = "VerNotas", urlPatterns = {"/VerNotas"})
public class VerNotas extends HttpServlet {

   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession miSesion = request.getSession();
         UsuarioAtributos usuario =(UsuarioAtributos)miSesion.getAttribute("idusuario");
   
        int id = usuario.getId();
        ArrayList<Notas> notaslist = new ArrayList<Notas>();
         try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");        
           PreparedStatement stmt = con.prepareStatement("select ID, Titulo, Texto, Fecha_Creacion, hashtag, Eliminado From Notas where ID_User = ? ");
                stmt.setInt(1, id);

               ResultSet rs = stmt.executeQuery();
              while (rs.next()){
              Notas notasindividual = new Notas();
              notasindividual.setId(rs.getInt("ID"));
              notasindividual.setTitulo(rs.getString("Titulo"));
              notasindividual.setTexto(rs.getString("Texto"));
              notasindividual.setFecha(rs.getString("Fecha_Creacion"));
              notasindividual.setHashtag(rs.getString("hashtag"));
              notasindividual.setEliminado(rs.getBoolean("Eliminado"));
             
              notaslist.add(notasindividual);
            
                
            }                        
          con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
            request.setAttribute("notaslist", notaslist);
         request.getRequestDispatcher("/MisNotas.jsp").forward(request, response);
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
