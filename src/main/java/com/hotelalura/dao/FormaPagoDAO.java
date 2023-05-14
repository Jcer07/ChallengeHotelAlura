package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelalura.entities.FormaPago;

public class FormaPagoDAO {

	private final Connection con;
	
	public FormaPagoDAO(Connection con) {
		this.con = con;
	}
	
	public List<FormaPago> listarFormasPago(){
		List<FormaPago> listado = null;
		try (con){
			String query = "SELECT idFormaPago, nombre FROM FormaPago WHERE vigente = 1 ORDER BY nombre";
			final PreparedStatement ps = con.prepareStatement(query );
			
			try (ps) {
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					listado = new ArrayList<>();
					listado.add(new FormaPago(0, "-- Seleccione --"));
					while(rs.next()) {
						listado.add(new FormaPago(
								rs.getInt("idFormaPago"), 
								rs.getString("nombre")));
						
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
