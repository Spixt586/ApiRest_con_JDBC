package com.krakedev.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Conexion {
	private static final Logger log = LogManager.getLogger(Conexion.class);
	private static final String URL = System.getenv("DB_URL");
	private static final String USER = System.getenv("DB_USER");
	private static final String PASSWORD = System.getenv("DB_PASSWORD");
	
	public static Connection getConnection() {
		try {
		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
		log.info("La conexión a la base de datos fue un éxito");
		return con;
		}catch(SQLException e) {
			log.error("La conexión a la base de datos a fallado: " + e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args) {
		log.info("Iniciando prueba de conexión con variables de entorno...");
		Connection conexion = getConnection();
		if(conexion != null) {
			log.info("Conexión exitosa");
		}
	}
}
