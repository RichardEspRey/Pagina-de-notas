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
public class editarNota extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String id = request.getParameter("NotaEditar");
    int idNota = Integer.parseInt(id);
     ArrayList<Notas> notaslist = new ArrayList<Notas>();
    try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Progra_web?useSSL=false&allowPublicKeyRetrieval=true","root","1Asusrog");    
            PreparedStatement stmt = con.prepareStatement("Select ID, Titulo, Texto, Fecha_Creacion, hashtag FROM Notas WHERE ID = ?");
                stmt.setInt(1, idNota);
              
                ResultSet rs = stmt.executeQuery();
              while (rs.next()){
              Notas notasindividual = new Notas();
              notasindividual.setId(rs.getInt("ID"));
              notasindividual.setTitulo(rs.getString("Titulo"));
              notasindividual.setTexto(rs.getString("Texto"));
              notasindividual.setFecha(rs.getString("Fecha_Creacion"));
              notasindividual.setHashtag(rs.getString("hashtag"));
        
             
              notaslist.add(notasindividual);
            
                HttpSession miSesion = request.getSession();
        miSesion.setAttribute("idNotaEdit", notasindividual);
            }
      
                con.close();
           
        }
        catch(Exception ex){
            System.out.println(ex);
          response.sendRedirect(request.getContextPath() + "/index.html");
        }
    
       
     
        
        request.setAttribute("notaslist", notaslist);
       request.getRequestDispatcher("/editarNota.jsp").forward(request, response);
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
