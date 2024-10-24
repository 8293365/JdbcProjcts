package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        Connector();
        try (Connection conn =  DB.connect()){
            System.out.println("Connected to the PostgreSQL database.");
            assert conn != null;
            if(conn.isValid(3))System.out.println("ready to roll");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}