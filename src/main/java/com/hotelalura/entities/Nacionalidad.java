package com.hotelalura.entities;

public class Nacionalidad {
	private int idNacionalidad;
	private String descripcion;
	
	public Nacionalidad() {
		
	}
	
	public Nacionalidad(int idNacionalidad, String descripcion) {
		this.idNacionalidad = idNacionalidad;
		this.descripcion = descripcion;
	}
	
	public Nacionalidad(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdNacionalidad() {
		return idNacionalidad;
	}

	public void setIdNacionalidad(int idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return this.descripcion;
	}
}
