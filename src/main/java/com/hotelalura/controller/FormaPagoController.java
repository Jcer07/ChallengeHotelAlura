package com.hotelalura.controller;

import java.util.List;

import com.hotelalura.connection.Conexion;
import com.hotelalura.dao.FormaPagoDAO;
import com.hotelalura.entities.FormaPago;

public class FormaPagoController {

	private FormaPagoDAO formaPagoDAO;
	
	public FormaPagoController() {
		formaPagoDAO = new FormaPagoDAO(new Conexion().getConexion());
	}

	public List<FormaPago> listarFormasPago(){
		return formaPagoDAO.listarFormasPago();
	}
}
