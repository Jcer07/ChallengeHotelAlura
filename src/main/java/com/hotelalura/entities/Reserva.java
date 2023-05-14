package com.hotelalura.entities;

import java.util.Date;

public class Reserva {

	private int idReserva;
	private Date fechaEntrada;
	private Date fechaSalida;
	private double valorTotal;
	private FormaPago formaPago;
	private Huesped huesped;
	
	public Reserva() {
		
	}
	
	public Reserva(int idReserva, Date fechaEntrada, Date fechaSalida, double valorTotal, FormaPago formaPago) {
		this.idReserva = idReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
		this.formaPago = formaPago;
	}
	
	public Reserva(int idReserva, Date fechaEntrada, Date fechaSalida, double valorTotal, FormaPago formaPago, Huesped huesped) {
		this.idReserva = idReserva;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
		this.formaPago = formaPago;
		this.huesped = huesped;
	}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, double valorTotal, FormaPago formaPago, Huesped huesped) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorTotal = valorTotal;
		this.formaPago = formaPago;
		this.huesped = huesped;
	}

	public int getIdReserva() {
		return idReserva;
	}
	
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public void setDniHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
				+ ", valorTotal=" + valorTotal + ", idFormaPago=" + formaPago.getIdFormaPago() + ", nombrePago = " + formaPago.getNombre() 
				+ ", dniHuesped=" + huesped.getDniHuesped() + ", nombresHuesped = " + huesped.getNombre() + " " + huesped.getApellido() + " ]";
	}
}
