package org.example;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/


public class DB {

    public static Connection connect() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");

            // Get database credentials from DbConnection class
            String jdbcUrl = DbConnection.getDbUrl();//for some unexplicable reason the variable disappears
            var user = DbConnection.getDbUsername();
            var password = DbConnection.getDbPassword();

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);
            //_____________________REGISTERED POSTGRES DRIVER WHAT IS THAT???__________

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(String position){
        return;
    }
    public static void read(String position){}
    public static void update(String position, String data){}
    public static void delete(String position){}

    public static String select(String el1,String el2,String el3,String el4){
        String result = "";
/*
        try{if ()


        }
*/
        return result;
    }
}
