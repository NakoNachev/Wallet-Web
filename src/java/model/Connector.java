/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Class for establishing connection to the database
 */
public class Connector {
    
    private String dbName;
    private String dbUser;
    private String dbPassword;
    private String dbURL;
    
    
    public Connector(String dbName, String dbUser, String dbPassword, String dbURL) {
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
        this.dbURL = dbURL;
    }
    
    public Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(this.dbURL+this.dbName,this.dbUser,this.dbPassword);
        return con;
    }
    
}
