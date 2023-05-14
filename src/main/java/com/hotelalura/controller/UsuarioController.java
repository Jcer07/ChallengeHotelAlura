package com.hotelalura.controller;

import com.hotelalura.connection.Conexion;
import com.hotelalura.dao.UsuarioDAO;
import com.hotelalura.entities.Usuario;

public class UsuarioController {
	
	private UsuarioDAO userDAO;
	
	public UsuarioController() {
		userDAO = new UsuarioDAO(new Conexion().getConexion());
	}
	
	public boolean validaLogin(Usuario user) {
		return userDAO.validaLogin(user);
	}
}
