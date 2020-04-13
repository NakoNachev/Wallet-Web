/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import model.db.DBManager;

/**
 *
 * @author Asus
 */
public class DBListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //create db connection
        
        ServletContext ctx = sce.getServletContext();
        
        String dbName = ctx.getInitParameter("dbName");
        String dbUser = ctx.getInitParameter("dbUser");
        String dbPassword = ctx.getInitParameter("dbPassword");
        String dbURL = ctx.getInitParameter("dbURL");
        String fullURL = dbURL+dbName;
        
        DBManager manager = null;
        try {
            manager = new DBManager(dbName,dbUser,dbPassword,dbURL);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ctx.setAttribute("dbManager", manager);
        System.out.println("Database connection for Application has been initilized");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
        ServletContext ctx = sce.getServletContext();
        DBManager dbManager = (DBManager)ctx.getAttribute("dbManager");
        dbManager.closeConnection();
        System.out.println("Database connection for Application has been closed");
    }
    
}
