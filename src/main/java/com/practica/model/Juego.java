package com.practica.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Juego implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_juego")
	private Integer idJuego;
	
	private String titulo;
	
	private String descripcion;
	
	private String imagenUrl;

	public Juego() {
	}
	
	public Juego(String titulo, String descripcion, String imagenUrl) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imagenUrl = imagenUrl;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagenUrl() {
		return imagenUrl;
	}

	public void setImagenUrl(String imagenUrl) {
		this.imagenUrl = imagenUrl;
	}

	public Integer getIdJuego() {
		return idJuego;
	}
	
	
}
