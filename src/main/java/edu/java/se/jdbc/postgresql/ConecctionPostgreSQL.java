package edu.java.se.jdbc.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConecctionPostgreSQL {

    public Connection getConnectionPruebas() {
        Connection conexion = null;
        Properties dbSeason = new Properties();
        dbSeason.put("user", "root");
        dbSeason.put("password", "root1234");
        String url = String.format("jdbc:postgresql://127.0.0.1:5432/prueba");

        try {
            System.out.println("Connection Successfull");
            conexion = DriverManager.getConnection(url, dbSeason);

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return conexion;
    }
}
