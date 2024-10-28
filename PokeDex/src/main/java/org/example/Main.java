//tabella indicatori benefici aziendali,
//costi rischi, profitti
/*
package org.example;


import java.rmi.Remote;
import java.sql.Connection;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        RemConnection conn = new RemConnection("localhost","3306","filmografia","root@localhost","iLikeAvengers17");


    }
}*/
/*
package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Initialize API client and database connection
        PokeApiClient apiClient = new PokeApiClient();
        //RemConnection remConnection = new RemConnection();
        //Connection connection = remConnection.getConnection();

        apiClient.fetchPikachuData();
            try {
            // Fetch Pikachu data from the PokeAPI
            PokemonData pikachu = apiClient.fetchPikachuData();
            System.out.println(pikachu);  // Print the data to verify

            // Insert Pikachu data into the MySQL database
            String insertSQL = "INSERT INTO pokemon (name, height, weight) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
                pstmt.setString(1, pikachu.getName());
                pstmt.setInt(2, pikachu.getHeight());
                pstmt.setInt(3, pikachu.getWeight());

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserted " + rowsAffected + " row(s) into the database.");
            }

        } catch (IOException e) {
            System.err.println("Failed to fetch Pikachu data: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to insert data into the database: " + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
*/

package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Initialize API client and database connection
        PokeApiClient apiClient = new PokeApiClient();
        RemConnection remConnection = new RemConnection();
        Connection connection = remConnection;

        try {
            // Fetch Pikachu data from the PokeAPI
            PokemonData pikachu = apiClient.fetchPikachuData();
            System.out.println(pikachu);  // Print the data to verify

            // Insert Pikachu data into the MySQL database
            String insertSQL = "INSERT INTO pokemon (name, height, weight) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
                pstmt.setString(1, pikachu.getName());
                pstmt.setInt(2, pikachu.getHeight());
                pstmt.setInt(3, pikachu.getWeight());

                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Inserted " + rowsAffected + " row(s) into the database.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to fetch Pikachu data: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Failed to insert data into the database: " + e.getMessage());
        } finally {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Failed to close database connection: " + e.getMessage());
            }
        }
    }
}
