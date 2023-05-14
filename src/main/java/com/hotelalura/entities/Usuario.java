package com.hotelalura.entities;

public class Usuario {
	private int id;
	private String email;
	private String nombreUsuario;
	private String contrasenia;
	
	public Usuario() {
	}

	public Usuario(int id, String email, String nombreUsuario, String contrasenia) {
		this.id = id;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(String nombreUsuario, String contrasenia) {
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}
