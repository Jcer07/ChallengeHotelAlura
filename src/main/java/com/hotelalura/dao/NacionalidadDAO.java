package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelalura.entities.Nacionalidad;

public class NacionalidadDAO {
	private final Connection con;
	
	public NacionalidadDAO(Connection con) {
		this.con = con;
	}
	
	public List<Nacionalidad> listarNacionalidades() {
		List<Nacionalidad> listado = null;
		try (con){
			String query = "SELECT * FROM nacionalidad";
			final PreparedStatement ps = con.prepareStatement(query );
			
			try (ps) {
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					listado = new ArrayList<>();
					listado.add(new Nacionalidad(0, "-- Seleccione --"));
					while(rs.next()) {
						listado.add(new Nacionalidad(
								rs.getInt(1), 
								rs.getString(2)));
						
					}
				}
			}
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listado;
	}
}
