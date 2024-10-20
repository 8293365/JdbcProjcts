package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import /src/DbConnection.java;


public class DB {
    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DbConnection class
            var jdbcUrl = DbConnection.getDbUrl();
            var user = DbConnection.getDbUsername();
            var password = DbConnection.getDbPassword();

            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
