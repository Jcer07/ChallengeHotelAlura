package com.hotelalura.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.hotelalura.controller.HuespedController;
import com.hotelalura.controller.ReservaController;
import com.hotelalura.entities.Huesped;
import com.hotelalura.entities.Reserva;

@SuppressWarnings("serial")
public class PnlFormBusqueda extends JPanel {
	
	private JPanel pnlContainer;
	
	private JTabbedPane tbPaned;
	private JTable tblHuesped;
	private JTable tblReserva;
	
	private DefaultTableModel modeloHuesped;
	private DefaultTableModel modeloReserva;
	private JScrollPane scrollPaneHuesped;
	private JScrollPane scrollPaneReserva;
	
	private JLabel lblTitulo;
	private JLabel lblDni;
	
	private JButton btnCerrar;
	private JButton btnBuscar;
	private JButton btnEditar;
	private JButton btnEliminar;
	
	private JTextField txtDni;
	

	/**
	 * Create the panel.
	 */
	public PnlFormBusqueda() {
		setBorder(null);
		setBounds(new Rectangle(0, 0, 1180, 680));
		setLayout(null);
		
		modeloHuesped  = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		modeloReserva = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		pnlContainer = new JPanel();
		pnlContainer.setBackground(new Color(255, 255, 255));
		pnlContainer.setBounds(0, 0, 1180, 680);
		add(pnlContainer);
		pnlContainer.setLayout(null);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDni.setBounds(785, 122, 255, 30);
		pnlContainer.add(txtDni);
		txtDni.setColumns(10);
		
		lblDni = new JLabel("Ingrese Dni");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDni.setBounds(785, 92, 255, 20);
		pnlContainer.add(lblDni);
		
		tbPaned = new JTabbedPane(JTabbedPane.TOP);
		tbPaned.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tbPanedStatedChanged(e);
			}
		});
		tbPaned.setBorder(null);
		tbPaned.setBackground(new Color(255, 255, 255));
		tbPaned.setBounds(20, 181, 1140, 411);
		pnlContainer.add(tbPaned);
		
		tblHuesped = new JTable();
		tblHuesped.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblHuespedMouseClicked(e);
			}
		});
		tblHuesped.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblHuesped.setFont(new Font("Arial", Font.PLAIN, 15));
		cargarModeloHuesped();
		
		scrollPaneHuesped = new JScrollPane(tblHuesped);
		scrollPaneHuesped.setBackground(new Color(255, 255, 255));
		scrollPaneHuesped.setFont(new Font("Arial", Font.PLAIN, 15));
		tbPaned.addTab("Huésped", null, scrollPaneHuesped, null);
		
		tblReserva = new JTable();
		tblReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tblReservaMouseClicked(e);
			}
		});
		tblReserva.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblReserva.setFont(new Font("Arial", Font.PLAIN, 15));
		cargarModeloReserva();
		
		scrollPaneReserva = new JScrollPane(tblReserva);
		scrollPaneReserva.setBackground(new Color(255, 255, 255));
		scrollPaneReserva.setFont(new Font("Arial", Font.PLAIN, 15));
		tbPaned.addTab("Reserva", null, scrollPaneReserva, null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCerrar.setBackground(new Color(95, 97, 99));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCerrar.setBackground(new Color(118, 121, 123));
			}
		});
		btnCerrar.setBorder(null);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCerrarActionPerformed();
			}
		});
		btnCerrar.setBackground(new Color(118, 121, 123));
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCerrar.setBounds(1050, 622, 110, 30);
		pnlContainer.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEliminar.setBackground(new Color(209, 8, 8));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEliminar.setBackground(new Color(255, 0, 0));
			}
		});
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarActionPerformed();
			}
		});
		btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminar.setBorder(null);
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEliminar.setBounds(930, 622, 110, 30);
		pnlContainer.add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarActionPerformed();
			}
		});
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEditar.setBackground(new Color(10, 119, 207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEditar.setBackground(new Color(12, 138, 240));
			}
		});
		btnEditar.setForeground(new Color(255, 255, 255));
		btnEditar.setBackground(new Color(12, 138, 220));
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBorder(null);
		btnEditar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnEditar.setBounds(803, 622, 110, 30);
		pnlContainer.add(btnEditar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarActionPerformed();
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(10, 119, 207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(12, 138, 240));
			}
		});
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(12, 138, 240));
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnBuscar.setBounds(1050, 122, 110, 30);
		pnlContainer.add(btnBuscar);
		
		lblTitulo = new JLabel("SISTEMA DE BÚSQUEDA");
		lblTitulo.setForeground(new Color(12, 138, 220));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 26));
		lblTitulo.setBounds(425, 37, 330, 30);
		pnlContainer.add(lblTitulo);
	}

	private void tblReservaMouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			modificarDatosReserva();
		}
	}

	private void btnEliminarActionPerformed() {
		if(tbPaned.getSelectedIndex() == tbPaned.indexOfComponent(scrollPaneHuesped)) {
			if(this.tblHuesped.getSelectedRow() > -1) {
				eliminarHuesped();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe elegir una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			if(this.tblReserva.getSelectedRow() > -1) {
				eliminarReserva();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe elegir una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void eliminarHuesped() {
		int op = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar los datos del Huesped?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
		if(op == JOptionPane.OK_OPTION) {
			HuespedController huespedController = new HuespedController();
			String dniHuesped = this.tblHuesped.getValueAt(this.tblHuesped.getSelectedRow(), 0).toString();
			huespedController.eliminarHuesped(dniHuesped);
			cargarListadoHuespedes();
		}
	}

	private void eliminarReserva() {
		int op = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la reserva?", "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
		if(op == JOptionPane.OK_OPTION) {
			ReservaController reservaController = new ReservaController();
			int codigoReserva = this.obtenerCodigoReserva();
			reservaController.eliminarReserva(codigoReserva);
			cargarListadoReservas();
		}
	}

	private void btnBuscarActionPerformed() {
		String dniNumero = this.txtDni.getText().trim();
		boolean esHuesped = tbPaned.getSelectedIndex() == tbPaned.indexOfComponent(scrollPaneHuesped);
		
		if(dniNumero.isEmpty()) {
			if(esHuesped) {
				cargarListadoHuespedes();
			}
			else {
				cargarListadoReservas();
			}
		}
		else {
			if(esHuesped) {
				cargarListadoHuespedesConDNI();
			}
			else {
				cargarListadoReservasPorCodigo();
			}
		}
	}

	private void cargarListadoReservasPorCodigo() {
		int codigoReserva = Integer.parseInt(this.txtDni.getText().trim());
		ReservaController reservaController = new ReservaController();
		Reserva reservaBuscada = reservaController.buscarReservaParaMostrar(codigoReserva);
	
		if (reservaBuscada != null) {
			modeloReserva.setRowCount(0);
			Object [] fila = {
					reservaBuscada.getIdReserva(),
					reservaBuscada.getFechaEntrada(),
					reservaBuscada.getFechaSalida(),
					reservaBuscada.getValorTotal(),
					reservaBuscada.getFormaPago().getNombre()
			};
			modeloReserva.addRow(fila);
			this.txtDni.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null, "Reserva no encontrada", "Información", JOptionPane.INFORMATION_MESSAGE);
			this.txtDni.requestFocus();
		}
	}

	private void cargarListadoHuespedesConDNI() {
		String dni = this.txtDni.getText().trim();
		HuespedController huespedController = new HuespedController();
		Huesped huespedBuscado = huespedController.buscarHuespedParaMostrar(dni);
		
		if(huespedBuscado != null) {
			modeloHuesped.setRowCount(0);
			int edadHuesped = calcularEdad(huespedBuscado.getFechaNacimiento());
			Object [] fila = {
					huespedBuscado.getDniHuesped(),
					huespedBuscado.getNombre(),
					huespedBuscado.getApellido(),
					edadHuesped,
					huespedBuscado.getNacionalidad().getDescripcion(),
					huespedBuscado.getTelefono()
				};
			
			modeloHuesped.addRow(fila);
			this.txtDni.setText("");
		}
		else {
			JOptionPane.showMessageDialog(null, "Huesped no encontrado", "Información", JOptionPane.INFORMATION_MESSAGE);
			this.txtDni.requestFocus();
		}
	}

	private int calcularEdad(Date fechaNacimiento) {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaNacimientoNueva = LocalDate.parse(String.valueOf(fechaNacimiento));
		
		Period periodo = Period.between(fechaNacimientoNueva, fechaActual);
		
		return periodo.getYears();
	}

	private void btnEditarActionPerformed() {
		if(tbPaned.getSelectedIndex() == tbPaned.indexOfComponent(scrollPaneHuesped)) {
			if(this.tblHuesped.getSelectedRow() > -1) {
				modificarDatosHuesped();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe elegir una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			if(this.tblReserva.getSelectedRow() > -1) {
				modificarDatosReserva();
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe elegir una fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

	private void modificarDatosReserva() {
		int codigoReserva = obtenerCodigoReserva();
		
		ReservaController reservaController = new ReservaController();
		Reserva reserva = reservaController.buscarReservaPorCodigo(codigoReserva);
	
		System.out.println(reserva.toString());
		
		PnlFormGuardarReserva guardarReserva = new PnlFormGuardarReserva();
		guardarReserva.modificarReserva(reserva, false);
	}

	private int obtenerCodigoReserva() {
		String codReserva = tblReserva.getValueAt(tblReserva.getSelectedRow(), 0).toString();
		return Integer.parseInt(codReserva);
	}

	private void tblHuespedMouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			modificarDatosHuesped();
		}
	}

	private void modificarDatosHuesped() {
		int fila = this.tblHuesped.getSelectedRow();
		String dni = this.tblHuesped.getValueAt(fila, 0).toString();
		
		FrmGuardarHuesped frm = new FrmGuardarHuesped((Frame) SwingUtilities.getWindowAncestor(this), true);
		frm.mostrarJDialog(dni, "MODIFICAR HUESPED", false);
		
		this.cargarListadoHuespedes();
	}

	private void tbPanedStatedChanged(ChangeEvent e) {
		if(this.tbPaned.getSelectedIndex() == 0) {
			lblDni.setText("Ingrese Dni de Huesped");
		}
		else {
			lblDni.setText("Ingrese Codigo de Reserva");
		}
	}

	private void cargarListadoReservas() {
		modeloReserva.setRowCount(0);
		
		var reservaController = new ReservaController();
		var reservas = reservaController.listadoReservas();
		
		reservas.forEach(reserva -> {
			String [] fila = {
					String.valueOf(reserva.getIdReserva()),
					String.valueOf(reserva.getFechaEntrada()),
					String.valueOf(reserva.getFechaSalida()),
					String.valueOf(reserva.getValorTotal()),
					reserva.getFormaPago().getNombre()
			};
			
			modeloReserva.addRow(fila);
		});
	}

	private void cargarListadoHuespedes() {
		modeloHuesped.setRowCount(0);
		var huespedController = new HuespedController();
		var listado = huespedController.listadoHuespedes();
		
		listado.forEach(huesped -> {
			String [] fila = {
					huesped.getDniHuesped(),
					huesped.getNombre(),
					huesped.getApellido(),
					String.valueOf(calcularEdad(huesped.getFechaNacimiento())),
					huesped.getNacionalidad().getDescripcion(),
					huesped.getTelefono()
				};
			
			modeloHuesped.addRow(fila);
		});
	}
	
	public void presentarPanelBusquedaReserva() {
		FrmPrincipal.mostrarPanel(this);
		this.tbPaned.setSelectedIndex(1);
		this.cargarListadoReservas();
	}

	private void cargarModeloReserva() {
		modeloReserva.addColumn("Número");
		modeloReserva.addColumn("Fecha de Entrada");
		modeloReserva.addColumn("Fecha de Salida");
		modeloReserva.addColumn("Valor");
		modeloReserva.addColumn("Forma de Pago");
		tblReserva.setModel(modeloReserva);
		tblReserva.getTableHeader().setReorderingAllowed(false);
	}

	private void btnCerrarActionPerformed() {
		FrmPrincipal.cargarImgFondoPrincipal();
	}

	private void cargarModeloHuesped() {
		modeloHuesped.addColumn("DNI");
		modeloHuesped.addColumn("Nombres");
		modeloHuesped.addColumn("Apellidos");
		modeloHuesped.addColumn("Edad");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Teléfono");
		tblHuesped.setModel(modeloHuesped);
		tblHuesped.getTableHeader().setReorderingAllowed(false);
	}
}
