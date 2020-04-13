/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.db.DBManager;

/**
 *
 * @author Asus
 */
public class LoginServlet extends HttpServlet {



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
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        boolean foundUser = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String prQuery = "select * from wallet_web.users where username = ? and password = ?";
        PreparedStatement prStatement = null;
        
        DBManager manager = (DBManager) getServletContext().getAttribute("dbManager");
        
        try {
            
            Connection con = manager.getConnection();
            prStatement = con.prepareStatement(prQuery);
            prStatement.setString(1, username);
            prStatement.setString(2, password);
            ResultSet rs = prStatement.executeQuery();
            
            while(rs.next()) {
                 
               foundUser = true; 
            }
 
        }   catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
       
    }
       
       if (foundUser) {
           
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/MainPageServlet");
           dispatcher.forward(request, response);
           
           
       }
       else {
           try{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User not found</h1>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
    }
        
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
        
       doGet(request,response);
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
