package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelalura.entities.Huesped;
import com.hotelalura.entities.Nacionalidad;

public class HuespedDAO {
	private final Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public void registrarHuesped(Huesped huesped) {
		try (con) {
			String query = "INSERT INTO huesped(dniHuesped, nombre, apellido, fechaNacimiento, idNacionalidad, telefono) "
					+ "VALUES(?, ?, ?, ?, ?, ?)";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				ps.setString(1, huesped.getDniHuesped());
				ps.setString(2, huesped.getNombre());
				ps.setString(3, huesped.getApellido());
				ps.setDate(4, new Date(huesped.getFechaNacimiento().getTime()));
				ps.setInt(5, huesped.getNacionalidad().getIdNacionalidad());
				ps.setString(6, huesped.getTelefono());
				
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void modificarHuesped(Huesped huesped) {
		try (con) {
			String query = "UPDATE huesped SET nombre = ?, apellido = ?, fechaNacimiento = ?, idNacionalidad = ?, telefono = ? "
					+ "WHERE dniHuesped = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				ps.setString(1, huesped.getNombre());
				ps.setString(2, huesped.getApellido());
				ps.setDate(3, new Date(huesped.getFechaNacimiento().getTime()));
				ps.setInt(4, huesped.getNacionalidad().getIdNacionalidad());
				ps.setString(5, huesped.getTelefono());
				ps.setString(6, huesped.getDniHuesped());
				
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Huesped buscarHuesped(String dniHuesped) {
		Huesped huesped = null;
		try (con) {
			String query = "SELECT nombre, apellido FROM huesped WHERE dniHuesped = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				ps.setString(1, dniHuesped);
				
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						huesped = new Huesped(
									dniHuesped,
									rs.getString("nombre"),
									rs.getString("apellido")
								);
					}
				} 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return huesped;
	}
	
	public Huesped buscarHuespedEdit(String dniHuesped) {
		Huesped huesped = null;
		try (con) {
			String query = "SELECT * FROM huesped WHERE dniHuesped = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				ps.setString(1, dniHuesped);
				
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						huesped = new Huesped(
									dniHuesped,
									rs.getString(2),
									rs.getString(3),
									rs.getDate(4),
									new Nacionalidad(rs.getInt(5), ""),
									rs.getString(6)
								);
					}
				} 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return huesped;
	}
	
	public Huesped buscarHuespedParaMostrar(String dniHuesped) {
		Huesped huesped = null;
		try (con) {
			String query = "SELECT h.dniHuesped, h.nombre, h.apellido, h.fechaNacimiento, "
								+ "n.descripcion, h.telefono "
						 + "FROM huesped AS h "
								+ "INNER JOIN nacionalidad AS n ON h.idNacionalidad = n.idNacionalidad "
						 + "WHERE h.dniHuesped = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				ps.setString(1, dniHuesped);
				
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						huesped = new Huesped(
									dniHuesped,
									rs.getString(2),
									rs.getString(3),
									rs.getDate(4),
									new Nacionalidad(rs.getString(5)),
									rs.getString(6)
								);
					}
				} 
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return huesped;
	}
	
	public List<Huesped> listadoHuespedes(){
		List<Huesped> listado = null;
		try (con) {
			String query = "SELECT h.dniHuesped, h.nombre, h.apellido, h.fechaNacimiento, n.descripcion, h.telefono "
							+ "FROM huesped AS h "
							+ "INNER JOIN nacionalidad AS n ON h.idNacionalidad = n.idNacionalidad";
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				final ResultSet rs = ps.executeQuery();
				
				try (rs){
					listado = new ArrayList<>();
					while(rs.next()) {
						listado.add(new Huesped(
								rs.getString(1),
								rs.getString(2),
								rs.getString(3),
								rs.getDate(4),
								new Nacionalidad(rs.getString(5)),
								rs.getString(6)
							));
					}	
				}
			}
		}
		catch (SQLException e) {
			new RuntimeException(e);
		}
		
		return listado;
	}

	public void eliminarHuesped(String dniHuesped) {
		try (con) {
			String query = "DELETE FROM huesped WHERE dniHuesped = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps){
				ps.setString(1, dniHuesped);
				
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
