package com.hotelalura.entities;

import java.util.Date;

public class Huesped {
	private String dniHuesped;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String telefono;
	private Nacionalidad nacionalidad;
	
	public Huesped() {
	}
	
	public Huesped(String dniHuesped, String nombre, String apellido) {
		this.dniHuesped = dniHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Huesped(String dniHuesped, String nombre, String apellido, Date fechaNacimiento, Nacionalidad nacionalidad,
			String telefono) {
		this.dniHuesped = dniHuesped;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public String getDniHuesped() {
		return dniHuesped;
	}
	
	public void setDniHuesped(String dniHuesped) {
		this.dniHuesped = dniHuesped;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}
