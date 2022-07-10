package com.practica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.dto.JuegoDto;
import com.practica.model.Juego;
import com.practica.service.JuegoService;

@RestController
@RequestMapping("/juego")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;
	
	@GetMapping("/listaJuegos")
	public ResponseEntity<List<Juego>> listaJuegos() {
		return new ResponseEntity<>(juegoService.listarJuegos(), HttpStatus.OK);
	}
	
	@GetMapping("/encontrarJuego/{id}")
	public ResponseEntity<Juego> encontrarJuego(@PathVariable("id") Integer id) {
		return new ResponseEntity<>(juegoService.encontrarJuegoByid(id), HttpStatus.OK);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Juego> guardarJuego(@RequestBody JuegoDto juegoDto) {
		Juego juego = new Juego(juegoDto.getTitulo(), juegoDto.getDescripcion(), juegoDto.getImagenUrl());
		return new ResponseEntity<>(juegoService.guardarJuego(juego), HttpStatus.OK);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<Juego> editarJuego(@PathVariable("id") Integer id, @RequestBody JuegoDto juegoDto) {
		Juego juegoEncontrado = juegoService.encontrarJuegoByid(id);
		
		try {
			juegoEncontrado.setTitulo(juegoDto.getTitulo());
			juegoEncontrado.setDescripcion(juegoDto.getDescripcion());
			juegoEncontrado.setImagenUrl(juegoDto.getImagenUrl());
			return new ResponseEntity<>(juegoService.guardarJuego(juegoEncontrado), HttpStatus.OK);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/eliminarJuego/{id}")
	public ResponseEntity<Boolean> eliminarJuego(@PathVariable("id") Integer id) {
		boolean juegoEliminado = juegoService.eliminarJuegoById(id);
		if (juegoEliminado) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
}
