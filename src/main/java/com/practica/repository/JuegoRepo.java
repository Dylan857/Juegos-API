package com.practica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.model.Juego;

@Repository
public interface JuegoRepo extends JpaRepository<Juego, Integer>{
	
}
