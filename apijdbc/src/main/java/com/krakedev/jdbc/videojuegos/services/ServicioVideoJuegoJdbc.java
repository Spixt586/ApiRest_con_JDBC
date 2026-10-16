package com.krakedev.jdbc.videojuegos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.jdbc.videojuegos.VideojuegoJdbc;
import com.krakedev.videojuegos.entidades.Videojuego;

@Service
public class ServicioVideoJuegoJdbc {

	public Videojuego crear(Videojuego videoJuego) {
		return VideojuegoJdbc.insertar(videoJuego.getCodigo(), videoJuego.getNombre(), videoJuego.getPlataforma(),
				videoJuego.getPrecio(), videoJuego.getDisponible(), videoJuego.getGenero());
	}
	
	public List<Videojuego> listar(){
		return VideojuegoJdbc.listar();
	}
	
	public Videojuego buscarPorCodigo(String codigo) {
		return VideojuegoJdbc.buscar(codigo);
	}
	
	public Videojuego actualizar(String codigo, Videojuego juegoActualizado) {
		return VideojuegoJdbc.actualizar(codigo, juegoActualizado.getNombre(), juegoActualizado.getPlataforma(), juegoActualizado.getPrecio(), juegoActualizado.getDisponible(), juegoActualizado.getGenero());
	}
	
	public boolean eliminar(String codigo) {
		return VideojuegoJdbc.eliminar(codigo);
	}
}
