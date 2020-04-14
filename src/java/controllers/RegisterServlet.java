
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.db.DBManager;

/**
 *
 * @author Asus
 */
public class RegisterServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        boolean userExists = false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        double accBalance = Double.parseDouble(request.getParameter("accBalance"));
        double accCredit = Double.parseDouble(request.getParameter("accCredit"));
        String accEmail = request.getParameter("accEmail");
        
        String checkExistanceQuery = "select * from wallet_web.users where username = ?";
        PreparedStatement prStatement = null;
        
        try {
            
         DBManager dbManager = (DBManager) getServletContext().getAttribute("dbManager");
         Connection con = dbManager.getConnection();
         prStatement = con.prepareStatement(checkExistanceQuery);
         prStatement.setString(1,username);
         ResultSet rs = prStatement.executeQuery();
         
         while (rs.next()) {
             userExists = true;
         }
            
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (userExists) {
            
            try{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration fail</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User already exists!</h1>");
                out.println("<ul>");
                    out.println("<li>");
                    out.println("Go back to <a href="+"Login.html> login </a>");
                    out.println("</li>");
                    out.println("<li>");
                    out.println("Try to<a href="+"Register.html> register </a> again");
                    out.println("</li>");
                out.println("</ul>");
                
                out.println("</body>");
                out.println("</html>");
            } finally {
                
            }
        }
        
        else {
            
            try {
            String insertNewAccountQuery = "insert into wallet_web.account_info values (?,?,?,?)";
            String insertUserData = "insert into wallet_web.users values (?,?)";
            DBManager dbManager = (DBManager)getServletContext().getAttribute("dbManager");
            Connection con = dbManager.getConnection();
            
            // add user
            
            prStatement = con.prepareStatement(insertUserData);
            prStatement.setString(1, username);
            prStatement.setString(2, password);
            prStatement.executeUpdate();
            prStatement = null;
            
            
            prStatement = con.prepareStatement(insertNewAccountQuery);
            prStatement.setString(1, username);
            prStatement.setDouble(2, accBalance);
            prStatement.setDouble(3, accCredit);
            prStatement.setString(4, accEmail);
            prStatement.executeUpdate();
            } catch (SQLException e){}
        }
        
        try{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registration complete!</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("</body>");
                out.println("</html>");
            } finally {
                out.close();
            }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
       doGet(request,response);
        
        // getServletConfig().getInitParameter("paramName..")
        // use RequestDispatcher when registration complete
        
        
        
        
        
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
