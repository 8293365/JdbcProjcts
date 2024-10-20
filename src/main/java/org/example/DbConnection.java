package org.example;
//package net.codejava.jdbc;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;


//we should use a dedicated class for the database connection
public abstract class DbConnection {

    private static final Properties properties = new Properties();//we could maybe do something similar to this, with json stuff, remember.

    static {
        //String resourceName = "~/src/main/resources/db.properties";
        String resourceName2 = "/db.properties";
        //try (InputStream input = DbConnection.class.getClassLoader().getResourceAsStream(resourceName))//.getClassLeader() not actually needed
        try (InputStream input = DbConnection.class.getResourceAsStream(resourceName2)) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                System.exit(1);
            }

            // Load the properties file
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getDbUrl() {

        return properties.getProperty("db.url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db.password");
    }


}












    /*public void test() throws SQLException {
        Connection db;
        {
            try {
                DriverManager.getConnection("jdbc:postgresql://localhost:5432/template1", "postgres", "root");
                System.out.println("hey");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

//pgjdbc.config.cleanup.thread.ttl (milliseconds, default: 30000);
    public DbConnection() throws SQLException {
        throw new SQLException();
    }
*/









    /*
    String url = "jdbc:postgresql://localhost:5432/test";
    Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "secret");
        props.setProperty("ssl", "true");
    Connection conn = DriverManager.getConnection(url, props);

    String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
    Connection conn = DriverManager.getConnection(url);

    public DbConnection() throws SQLException {
    }
    */




