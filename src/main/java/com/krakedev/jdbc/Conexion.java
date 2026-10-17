package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
    private static final Logger log = LogManager.getLogger(Conexion.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/apijdbc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            log.info("La conexión a la base de datos fue un éxito");
            return con;
        } catch (SQLException e) {
            log.error("La conexión a la base de datos ha fallado: " + e.getMessage());
            throw new RuntimeException("Error al conectar a la base de datos" + e.getMessage(),e);
        }
    }
}
