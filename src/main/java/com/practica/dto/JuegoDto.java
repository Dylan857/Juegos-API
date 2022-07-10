package com.practica.dto;

import java.io.Serializable;

public class JuegoDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String titulo;
	
	private String descripcion;
	
	private String imagenUrl;

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
	
	
	
}
