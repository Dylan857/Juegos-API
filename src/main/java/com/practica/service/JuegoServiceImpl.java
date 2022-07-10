package com.practica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practica.model.Juego;
import com.practica.repository.JuegoRepo;

@Service
public class JuegoServiceImpl implements JuegoService {

	@Autowired
	private JuegoRepo juegoRepository;
	
	@Override
	@Transactional
	public Juego guardarJuego(Juego juego) {
		return juegoRepository.save(juego);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Juego> listarJuegos() {
		return juegoRepository.findAll();
	}

	@Override
	@Transactional
	public boolean eliminarJuegoById(Integer idJuego) {
		try {
			juegoRepository.deleteById(idJuego);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Juego encontrarJuegoByid(Integer idJuego) {
		Optional<Juego> juegoOptional = juegoRepository.findById(idJuego);
		if (juegoOptional.isPresent()) {
			return juegoOptional.get();
		} else {
			return null;
		}
	}
	
}
