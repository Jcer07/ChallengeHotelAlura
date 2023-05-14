package com.hotelalura.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hotelalura.entities.FormaPago;
import com.hotelalura.entities.Huesped;
import com.hotelalura.entities.Reserva;

public class ReservaDAO {
	private final Connection con;
	
	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void registrarReserva(Reserva reserva) {
		try (con) {
			String query = "INSERT INTO reserva(fechaEntrada, fechaSalida, valorTotal, idFormaPago, dniHuesped) VALUES (?, ?, ?, ?, ?)";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps){
				ps.setDate(1, new Date(reserva.getFechaEntrada().getTime()));
				ps.setDate(2, new Date(reserva.getFechaSalida().getTime()));
				ps.setDouble(3, reserva.getValorTotal());
				ps.setInt(4, reserva.getFormaPago().getIdFormaPago());
				ps.setString(5, reserva.getHuesped().getDniHuesped());
				
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> listadoReservas(){
		List<Reserva> listado = null;
		
		try (con) {
			String query = "SELECT r.idReserva, r.fechaEntrada, r.fechaSalida, r.valorTotal, fp.nombre "
						+ "FROM reserva AS r "
						+ "INNER JOIN formapago AS fp ON r.idFormaPago = fp.idFormaPago ";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps) {
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					listado = new ArrayList<>();
					
					while(rs.next()) {
						listado.add(new Reserva(
								rs.getInt(1),
								rs.getDate(2),
								rs.getDate(3),
								rs.getDouble(4),
								new FormaPago(rs.getString(5))
							));
					}
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return listado;
	}

	public Reserva buscarReservaPorCodigo(int codigoReserva) {
		Reserva reserva = null;
		try (con) {
			String query = "SELECT r.fechaEntrada, r.fechaSalida, r.valorTotal, "
								+ "fp.idFormaPago, fp.nombre, h.dniHuesped, "
								+ "h.nombre, h.apellido "
						+ "	FROM Reserva AS r "
						+ "		INNER JOIN formapago AS fp ON r.idFormaPago = fp.idFormaPago "
						+ "		INNER JOIN huesped AS h ON r.dniHuesped = h.dniHuesped"
						+ "	WHERE idReserva = ?";
			final PreparedStatement ps = con.prepareStatement(query);
			try (ps) {
				ps.setInt(1, codigoReserva);
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						reserva = crearEntidad(rs, codigoReserva);
					}
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return reserva;
	}
	
	public Reserva buscarReservaParaMostrar(int codigoReserva) {
		Reserva reserva = null;
		try (con) {
			String query = "SELECT r.idReserva, r.fechaEntrada, r.fechaSalida, r.valorTotal, fp.nombre "
					+ "FROM reserva AS r "
						+ "INNER JOIN formapago AS fp ON r.idFormaPago = fp.idFormaPago "
					+ "WHERE idReserva = ?";
			final PreparedStatement ps = con.prepareStatement(query);
			try (ps) {
				ps.setInt(1, codigoReserva);
				final ResultSet rs = ps.executeQuery();
				
				try (rs) {
					if(rs.next()) {
						reserva = new Reserva(
								codigoReserva,
								rs.getDate(2),
								rs.getDate(3),
								rs.getDouble(4),
								new FormaPago(
									rs.getString(5)
								)
							);
					}
				}
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return reserva;
	}

	private Reserva crearEntidad(final ResultSet rs, int codigoReserva) throws SQLException {
		return new Reserva(
					codigoReserva,
					rs.getDate(1),
					rs.getDate(2),
					rs.getDouble(3),
					new FormaPago(
							rs.getInt(4),
							rs.getString(5)
						),
					new Huesped(
							rs.getString(6),
							rs.getString(7),
							rs.getString(8)
						)
				);
	}

	public void modificarReserva(Reserva reserva) {
		try (con) {
			String query = "UPDATE reserva set fechaEntrada = ?, fechaSalida = ?, valorTotal = ?, "
					+ "idFormaPago = ?, dniHuesped = ? WHERE idReserva = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps){
				ps.setDate(1, new Date(reserva.getFechaEntrada().getTime()));
				ps.setDate(2, new Date(reserva.getFechaSalida().getTime()));
				ps.setDouble(3, reserva.getValorTotal());
				ps.setInt(4, reserva.getFormaPago().getIdFormaPago());
				ps.setString(5, reserva.getHuesped().getDniHuesped());
				ps.setInt(6, reserva.getIdReserva());
				
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void eliminarReserva(int idReserva) {
		try (con) {
			String query = "DELETE FROM reserva WHERE idReserva = ?";
			
			final PreparedStatement ps = con.prepareStatement(query);
			
			try (ps){
				ps.setInt(1, idReserva);
				
				ps.executeUpdate();
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
