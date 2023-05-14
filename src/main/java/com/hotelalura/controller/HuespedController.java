package com.hotelalura.controller;

import java.util.List;

import com.hotelalura.connection.Conexion;
import com.hotelalura.dao.HuespedDAO;
import com.hotelalura.entities.Huesped;

public class HuespedController {
	
	private HuespedDAO huespedDAO;
	
	public HuespedController() {
		huespedDAO = new HuespedDAO(new Conexion().getConexion());
	}
	
	public void registrarHuesped(Huesped huesped) {
		huespedDAO.registrarHuesped(huesped);
	}
	
	public Huesped buscarHuesped(String dniHuesped) {
		return huespedDAO.buscarHuesped(dniHuesped);
	}
	
	public Huesped buscarHuespedEdit(String dniHuesped) {
		return huespedDAO.buscarHuespedEdit(dniHuesped);
	}
	
	public Huesped buscarHuespedParaMostrar(String dniHuesped) {
		return huespedDAO.buscarHuespedParaMostrar(dniHuesped);
	}
	
	public List<Huesped> listadoHuespedes(){
		return huespedDAO.listadoHuespedes();
	}

	public void modificarHuesped(Huesped huesped) {
		huespedDAO.modificarHuesped(huesped);
	}

	public void eliminarHuesped(String dniHuesped) {
		huespedDAO.eliminarHuesped(dniHuesped);
	}
}
