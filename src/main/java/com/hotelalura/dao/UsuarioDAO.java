package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hotelalura.entities.Usuario;

public class UsuarioDAO {
	final Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}
	
	public boolean validaLogin(Usuario user) {
		boolean respuesta = false;
		String query = "SELECT * FROM usuario WHERE nombreUsuario = ? AND contrasenia = ?";
		
		try (con){
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps){
				ps.setString(1, user.getNombreUsuario());
				ps.setString(2, user.getContrasenia());
				
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						respuesta = true;
					}
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return respuesta;
	}
}
