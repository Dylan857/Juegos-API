package com.practica.service;

import java.util.List;

import com.practica.model.Juego;

public interface JuegoService {

	public Juego guardarJuego(Juego juego);
	
	public List<Juego> listarJuegos();
	
	public boolean eliminarJuegoById(Integer idJuego);
	
	public Juego encontrarJuegoByid(Integer idJuego);
}
