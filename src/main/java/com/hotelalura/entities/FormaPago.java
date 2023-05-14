package com.hotelalura.entities;

public class FormaPago {

	private int idFormaPago;
	private String nombre;
	private boolean vigente;
	
	public FormaPago() {
		
	}
	
	public FormaPago(int idFormaPago, String nombre) {
		this.idFormaPago = idFormaPago;
		this.nombre = nombre;
	}
	
	public FormaPago(String nombre) {
		this.nombre = nombre;
	}

	public int getIdFormaPago() {
		return idFormaPago;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVigente() {
		return vigente;
	}

	public void setVigente(boolean vigente) {
		this.vigente = vigente;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
}
