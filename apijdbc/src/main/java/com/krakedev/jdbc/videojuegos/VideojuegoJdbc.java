package com.krakedev.jdbc.videojuegos;

import com.krakedev.jdbc.Conexion;
import com.krakedev.videojuegos.entidades.Videojuego;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VideojuegoJdbc {
	private static final Logger log = LogManager.getLogger(VideojuegoJdbc.class);

	public static Videojuego insertar(String codigo, String nombre, String plataforma, double precio,
			boolean disponible, String genero) {
		Connection con = null;
		PreparedStatement ps = null;
		Videojuego vJuego = null;

		try {
			con = Conexion.getConnection();
			String sql = """
					INSERT INTO videojuegos(codigo,nombre,plataforma,precio,disponible,genero) VALUES (?,?,?,?,?,?);
					""";

			ps = con.prepareStatement(sql);
			ps.setString(1, codigo);
			ps.setString(2, nombre);
			ps.setString(3, plataforma);
			ps.setDouble(4, precio);
			ps.setBoolean(5, disponible);
			ps.setString(6, genero);

			int filas = ps.executeUpdate();
			vJuego = new Videojuego(codigo, nombre, plataforma, precio, disponible, genero);
			log.info("Filas insertadas: " + filas);

		} catch (SQLException e) {
			log.error("Error al insertar" + e);
			throw new RuntimeException("Error al insertar: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vJuego;
	}

	public static List<Videojuego> listar() {
		List<Videojuego> videoJuegos = new ArrayList();
		Connection con = null;
		try {
			con = Conexion.getConnection();

			String sql = """
					SELECT * FROM Videojuegos;
					""";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Videojuego vj = new Videojuego(rs.getString("codigo"), rs.getString("nombre"),
						rs.getString("plataforma"), rs.getDouble("precio"), rs.getBoolean("disponible"),
						rs.getString("genero"));

				videoJuegos.add(vj);
			}

		} catch (Exception e) {
			log.error("Error al listar", e);
			throw new RuntimeException("Error al listar: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(videoJuegos != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return videoJuegos;
	}

	public static Videojuego buscar(String codigo) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				SELECT * FROM videojuegos WHERE codigo = ?;
				""";
		ResultSet rs = null;
		Videojuego videoJuego = null;

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, codigo);

			rs = ps.executeQuery();

			if (rs.next()) {
				videoJuego = new Videojuego(rs.getString("codigo"), rs.getString("nombre"), rs.getString("plataforma"),
						rs.getDouble("precio"), rs.getBoolean("disponible"), rs.getString("genero"));
			}
			
		} catch (Exception e) {
			log.error("Error al buscar: ", e);
			throw new RuntimeException("Error al buscar: " + e.getMessage());
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					con.close();
				}
				if(rs != null) {
					con.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		return videoJuego;
	}

}
