/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 * Class for establishing connection to the database
 */
public class DBManager {
    
    private String dbName;
    private String dbUser;
    private String dbPassword;
    private String dbURL;
    private Connection con;
    
    
    public DBManager(String dbName, String dbUser, String dbPassword, String dbURL) throws ClassNotFoundException {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbURL = dbURL;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection(this.dbURL+this.dbName,this.dbUser,this.dbPassword);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() throws SQLException {
        return this.con;
    }
    
    public void closeConnection() throws SQLException{
       this.con.close();
    }
    
}