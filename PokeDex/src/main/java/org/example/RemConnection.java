package org.example;

import com.sun.jdi.connect.Connector;
import java.net.HttpURLConnection;
import java.sql.*;
public class RemConnection {

    public RemConnection(){}

    public  RemConnection(String address, String port, String databaseName, String username, String password) {
        //stringa di connessione -> jdbc:mysql://127.0.0.1:3306/nomeDB
        String dbConnectionString = "jdbc:mysql://" + address + ":" + port + "/" + databaseName;
        //String dbConnectionString = "https://pokeapi.co/api/v2ability";
        try {
            var conn = DriverManager.getConnection(dbConnectionString, username, password);
            if (conn != null)
                System.out.println("connessione avvenuta");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
