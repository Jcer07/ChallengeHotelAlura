package com.hotelalura.controller;

import java.util.List;

import com.hotelalura.connection.Conexion;
import com.hotelalura.dao.NacionalidadDAO;
import com.hotelalura.entities.Nacionalidad;

public class NacionalidadController {
	
	private NacionalidadDAO nacionalidadDAO = null;
	
	public NacionalidadController() {
		nacionalidadDAO = new NacionalidadDAO(new Conexion().getConexion());
	}
	
	public List<Nacionalidad> listarNacionalidades(){
		return nacionalidadDAO.listarNacionalidades();
	}
}
