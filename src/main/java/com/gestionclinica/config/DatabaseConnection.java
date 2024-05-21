package com.gestionclinica.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String url = "jdbc:mysql://localhost:3306/clinicas";
    private static String user = "root";
    private static String pass = "123456";

    private static Connection myConn;
    
    public static Connection getInstance() throws SQLException{
        if(myConn == null){
            myConn = DriverManager.getConnection(url, user, pass);
        }
        return myConn;
    }
}
