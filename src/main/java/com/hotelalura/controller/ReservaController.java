package com.hotelalura.controller;

import java.util.List;

import com.hotelalura.connection.Conexion;
import com.hotelalura.dao.ReservaDAO;
import com.hotelalura.entities.Reserva;

public class ReservaController {

	private ReservaDAO reservaDAO;
	
	public ReservaController() {
		reservaDAO = new ReservaDAO(new Conexion().getConexion());
	}

	public void registrarReserva(Reserva reserva) {
		this.reservaDAO.registrarReserva(reserva);
	}
	
	public List<Reserva> listadoReservas(){
		return reservaDAO.listadoReservas();
	}

	public Reserva buscarReservaPorCodigo(int codigoReserva) {
		return reservaDAO.buscarReservaPorCodigo(codigoReserva);
	}
	
	public Reserva buscarReservaParaMostrar(int codigoReserva) {
		return reservaDAO.buscarReservaParaMostrar(codigoReserva);
	}

	public void modificarReserva(Reserva reserva) {
		this.reservaDAO.modificarReserva(reserva);
	}
	
	public void eliminarReserva(int idReserva) {
		this.reservaDAO.eliminarReserva(idReserva);
	}
}
