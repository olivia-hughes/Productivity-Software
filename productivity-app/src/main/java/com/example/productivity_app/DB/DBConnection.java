package com.example.productivity_app.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Simple database connection using a driver.

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/productivitydb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "MyFirstMySQLDB1!";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
