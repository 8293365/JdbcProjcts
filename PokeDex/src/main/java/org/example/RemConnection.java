package org.example;

import com.sun.jdi.connect.Connector;
import java.net.HttpURLConnection;
import java.sql.*;
public class RemConnection {

    public RemConnection(){
        getConnection("localshot", "5432", "testdb", "postgres", "root");
    }

    public RemConnection(String address, String port, String databaseName, String username, String password){
        getConnection(address, port, databaseName, username, password);
    }// my genius generates gravity, you leave the constructor with just a call and put the actual code elsewhere so no problems with the constructor itself


    public static void getConnection(String address, String port, String databaseName, String username, String password) {
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

    public void GetConnection(String address, String port, String databaseName, String username, String password) {
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


    public String No(){
        return "No";
    }
}
