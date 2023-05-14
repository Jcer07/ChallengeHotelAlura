package com.hotelalura.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;

import com.hotelalura.controller.FormaPagoController;
import com.hotelalura.controller.HuespedController;
import com.hotelalura.controller.ReservaController;
import com.hotelalura.entities.FormaPago;
import com.hotelalura.entities.Huesped;
import com.hotelalura.entities.Reserva;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.Cursor;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class PnlFormGuardarReserva extends JPanel {

	private Huesped huesped = null;
	
	private JButton btnCerrar;
	private JButton btnBuscarHuesped;
	private JButton btnGuardar;
	
	private JTextField txtDniHuesped;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtMontoReserva;
	
	private JPanel pnlRegistroReserva;
	private JPanel pnlDatosHuesped;
	private JPanel pnlDatosReserva;
	private JPanel pnlImgFondo;
	
	private JLabel lblTitulo;
	private JLabel lblDni;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblImgFondo;
	private JLabel lblLogoHotel;
	private JLabel lblFechaDeIngreso;
	private JLabel lblFechaDeSalida;
	private JLabel lblMontoReserva;
	private JLabel lblFormaPago;
	
	private JDateChooser dtFechaIngreso;
	private JDateChooser dtFechaSalida;
	
	private JComboBox<FormaPago> cboFormaPago;
	
	private final int precioHabitacion = 35;

	private Reserva reservaActual = null;
	
	/**
	 * Create the panel.
	 */
	public PnlFormGuardarReserva() {
		setBackground(SystemColor.inactiveCaption);
		setBorder(null);
		setBounds(new Rectangle(0, 0, 1180, 680));
		setLayout(null);
		
		pnlRegistroReserva = new JPanel();
		pnlRegistroReserva.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pnlRegistroReserva.setBackground(new Color(255, 255, 255));
		pnlRegistroReserva.setBounds(0, 0, 600, 680);
		add(pnlRegistroReserva);
		pnlRegistroReserva.setLayout(null);
		
		lblTitulo = new JLabel("REGISTRO DE RESERVAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(128, 128, 128));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitulo.setBounds(140, 30, 320, 25);
		pnlRegistroReserva.add(lblTitulo);
		
		pnlDatosHuesped = new JPanel();
		pnlDatosHuesped.setBackground(new Color(255, 255, 255));
		pnlDatosHuesped.setName("");
		pnlDatosHuesped.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlDatosHuesped.setBorder(new TitledBorder(null, "Datos del Huesped", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatosHuesped.setBounds(20, 65, 560, 170);
		pnlRegistroReserva.add(pnlDatosHuesped);
		pnlDatosHuesped.setLayout(null);
		
		txtDniHuesped = new JTextField();
		txtDniHuesped.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					buscarHuesped();
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				if(txtDniHuesped.getText().length() >= 8) {
					e.consume();
				}
			}
		});
		txtDniHuesped.setBounds(15, 48, 390, 30);
		pnlDatosHuesped.add(txtDniHuesped);
		txtDniHuesped.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDniHuesped.setColumns(10);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(15, 23, 120, 15);
		pnlDatosHuesped.add(lblDni);
		lblDni.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnBuscarHuesped = new JButton("Buscar");
		btnBuscarHuesped.setForeground(new Color(255, 255, 255));
		btnBuscarHuesped.setBackground(new Color(12, 138, 240));
		btnBuscarHuesped.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscarHuesped.setBackground(new Color(10, 119, 207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscarHuesped.setBackground(new Color(12, 138, 240));
			}
		});
		btnBuscarHuesped.setBorder(null);
		btnBuscarHuesped.setBounds(425, 47, 120, 30);
		pnlDatosHuesped.add(btnBuscarHuesped);
		btnBuscarHuesped.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarHuesped.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarHuesped();
			}
		});
		btnBuscarHuesped.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(15, 88, 120, 15);
		pnlDatosHuesped.add(lblNombres);
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(15, 113, 250, 30);
		pnlDatosHuesped.add(txtNombre);
		txtNombre.setEditable(false);
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(295, 88, 120, 15);
		pnlDatosHuesped.add(lblApellidos);
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtApellido = new JTextField();
		txtApellido.setBounds(295, 113, 250, 30);
		pnlDatosHuesped.add(txtApellido);
		txtApellido.setEditable(false);
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 14));
		txtApellido.setColumns(10);
		
		pnlDatosReserva = new JPanel();
		pnlDatosReserva.setFont(new Font("Arial", Font.PLAIN, 15));
		pnlDatosReserva.setBorder(new TitledBorder(null, "Datos de la Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlDatosReserva.setBackground(new Color(255, 255, 255));
		pnlDatosReserva.setBounds(20, 250, 560, 375);
		pnlRegistroReserva.add(pnlDatosReserva);
		pnlDatosReserva.setLayout(null);
		
		lblFechaDeIngreso = new JLabel("Fecha de Ingreso");
		lblFechaDeIngreso.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeIngreso.setBounds(15, 34, 120, 15);
		pnlDatosReserva.add(lblFechaDeIngreso);
		
		dtFechaIngreso = new JDateChooser();
		((JTextField)dtFechaIngreso.getDateEditor()).setEditable(false);
		dtFechaIngreso.setMinSelectableDate(new Date());
		dtFechaIngreso.setDateFormatString("yyyy-MM-dd");
		dtFechaIngreso.setCalendar(new GregorianCalendar());
		dtFechaIngreso.setFont(new Font("Arial", Font.PLAIN, 14));
		dtFechaIngreso.setBounds(15, 59, 390, 30);
		pnlDatosReserva.add(dtFechaIngreso);
		
		lblFechaDeSalida = new JLabel("Fecha de Salida");
		lblFechaDeSalida.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeSalida.setBounds(15, 109, 120, 15);
		pnlDatosReserva.add(lblFechaDeSalida);
		
		txtMontoReserva = new JTextField();
		txtMontoReserva.setFont(new Font("Arial", Font.PLAIN, 14));
		txtMontoReserva.setEditable(false);
		txtMontoReserva.setColumns(10);
		txtMontoReserva.setBounds(15, 214, 390, 30);
		pnlDatosReserva.add(txtMontoReserva);
		
		dtFechaSalida = new JDateChooser();
		((JTextField)dtFechaSalida.getDateEditor()).setEditable(false);
		dtFechaSalida.setMinSelectableDate(new Date());
		dtFechaSalida.setDateFormatString("yyyy-MM-dd");
		dtFechaSalida.setDate(Date.from(((LocalDate.now()).plusDays(1)).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		dtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				calculaMontoTotal();
			}
		});
		dtFechaSalida.setFont(new Font("Arial", Font.PLAIN, 14));
		dtFechaSalida.setBounds(15, 134, 390, 30);
		pnlDatosReserva.add(dtFechaSalida);
		
		lblMontoReserva = new JLabel("Monto de la Reserva");
		lblMontoReserva.setFont(new Font("Arial", Font.PLAIN, 14));
		lblMontoReserva.setBounds(15, 189, 155, 15);
		pnlDatosReserva.add(lblMontoReserva);
		
		lblFormaPago = new JLabel("Forma de Pago");
		lblFormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFormaPago.setBounds(15, 267, 155, 15);
		pnlDatosReserva.add(lblFormaPago);
		
		cboFormaPago = new JComboBox<>();
		cboFormaPago.setFont(new Font("Arial", Font.PLAIN, 14));
		cboFormaPago.setBounds(15, 292, 390, 30);
		this.cargarModeloCombo();
		cboFormaPago.setSelectedIndex(0);
		pnlDatosReserva.add(cboFormaPago);
		
		btnCerrar = new JButton("Cerrar");
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
		btnCerrar.setForeground(new Color(255, 255, 255));
		btnCerrar.setBounds(475, 635, 100, 35);
		pnlRegistroReserva.add(btnCerrar);
		btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarActionPerformed();
			}
		});
		btnCerrar.setBackground(new Color(118, 121, 123));
		btnCerrar.setBorder(null);
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuadarActionPerformed();
			}
		});
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGuardar.setBackground(new Color(10, 119, 207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardar.setBackground(new Color(12, 138, 240));
			}
		});
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setAutoscrolls(true);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(12, 138, 240));
		btnGuardar.setBounds(360, 635, 100, 35);
		pnlRegistroReserva.add(btnGuardar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 600, 2);
		pnlRegistroReserva.add(separator);
		
		pnlImgFondo = new JPanel();
		pnlImgFondo.setBounds(600, 0, 580, 680);
		pnlImgFondo.setBackground(new Color(12, 138, 240));
		add(pnlImgFondo);
		pnlImgFondo.setLayout(null);
		
		lblLogoHotel = new JLabel("");
		lblLogoHotel.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\aH-150px.png"));
		lblLogoHotel.setBounds(215, 57, 150, 150);
		pnlImgFondo.add(lblLogoHotel);
		
		lblImgFondo = new JLabel("");
		lblImgFondo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblImgFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgFondo.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\ImgReservas.png"));
		lblImgFondo.setBounds(0, 0, 580, 680);
		pnlImgFondo.add(lblImgFondo);
	}
	
	private void btnGuadarActionPerformed() {
		if(validaCampos()) {
			Reserva reserva = crearReserva();
			ReservaController reservaController = new ReservaController();
			if(reservaActual  == null) {
				reservaController.registrarReserva(reserva);
				JOptionPane.showMessageDialog(null, "Reserva registrada exitosamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
				this.limpiarCampos();
			}
			else {
				reservaController.modificarReserva(reserva);
				
				JOptionPane.showMessageDialog(null, "Reserva modificada exitosamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
				this.cerrarActionPerformed();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
		}
	}

	private Reserva crearReserva() {
		Reserva reserva = new Reserva(
				this.dtFechaIngreso.getDate(),
				this.dtFechaSalida.getDate(),
				Double.parseDouble(this.txtMontoReserva.getText()),
				((FormaPago)cboFormaPago.getSelectedItem()),
				huesped
			);
		
		if(reservaActual != null) {
			reserva.setIdReserva(reservaActual.getIdReserva());
		}
		
		return reserva;
	}

	private void limpiarCampos() {
		this.huesped = null;
		this.reservaActual = null;
		this.txtDniHuesped.setText("");
		this.txtNombre.setText("");
		this.txtApellido.setText("");
		this.dtFechaIngreso.setCalendar(new GregorianCalendar());;
		this.dtFechaSalida.setDate(Date.from(((LocalDate.now()).plusDays(1)).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		this.txtMontoReserva.setText("");
		this.cboFormaPago.setSelectedIndex(0);
	}

	private boolean validaCampos() {
		if(huesped == null ||
				cboFormaPago.getSelectedIndex() == 0) {
			return false;
		}
		return true;
	}

	private void calculaMontoTotal() {
		LocalDate fechaInicio = this.convertirDateToLocalDate(this.dtFechaIngreso.getDate());
		LocalDate fechaSalida = this.convertirDateToLocalDate(this.dtFechaSalida.getDate());
	
		if(validaFechas(fechaInicio, fechaSalida)) {
			long diferenciaDays = ChronoUnit.DAYS.between(fechaInicio, fechaSalida);
		
			long montoTotal = diferenciaDays * precioHabitacion;
			
			this.txtMontoReserva.setText(montoTotal + "");
		}
		else {
			JOptionPane.showMessageDialog(null, "La fecha de Salida debe ser mayor a la fecha de Inicio");
			dtFechaSalida.setDate(Date.from(((fechaInicio).plusDays(1)).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		}
	}
	
	private boolean validaFechas(LocalDate fechaInicio, LocalDate fechaSalida) {
		return !fechaInicio.isAfter(fechaSalida) && !fechaInicio.isEqual(fechaSalida);
	}

	private LocalDate convertirDateToLocalDate(Date fecha) {
		return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	private void cargarModeloCombo() {
		DefaultComboBoxModel<FormaPago> modeloCombo = new DefaultComboBoxModel<>();
		modeloCombo.addAll(new FormaPagoController().listarFormasPago());
		this.cboFormaPago.setModel(modeloCombo);
	}

	private void buscarHuesped() {
		if(!this.txtDniHuesped.getText().isEmpty() && this.txtDniHuesped.getText().length() == 8) {
			String dni = this.txtDniHuesped.getText().trim();
			
			HuespedController huespedController = new HuespedController();
			huesped = huespedController.buscarHuesped(dni);
			
			if(huesped != null) {
				this.txtNombre.setText(huesped.getNombre());
				this.txtApellido.setText(huesped.getApellido());
			}
			else {
				int op = JOptionPane.showConfirmDialog(null, "Huesped no encontrado \n¿Desea registrarlo?", "Información", JOptionPane.OK_CANCEL_OPTION);
				
				if(op == JOptionPane.OK_OPTION) {
					FrmGuardarHuesped frm = new FrmGuardarHuesped((Frame) SwingUtilities.getWindowAncestor(this), true);
					frm.mostrarJDialog(this.txtDniHuesped.getText(), "REGISTRO DE HUESPED", true);
					mostrarDatosHuesped(dni);
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Debe ingresar un número de dni válido", "Registro de Reservas", JOptionPane.WARNING_MESSAGE);
		}
	}

	private void mostrarDatosHuesped(String dni) {
		var huespedC = new HuespedController().buscarHuesped(dni);
		if(huespedC != null) {
			this.txtNombre.setText(huespedC.getNombre());
			this.txtApellido.setText(huespedC.getApellido());
		}
	}

	private void cerrarActionPerformed() {
		if(reservaActual == null) {
			FrmPrincipal.cargarImgFondoPrincipal();
		}
		else {
			PnlFormBusqueda pnlBusqueda = new PnlFormBusqueda();
			pnlBusqueda.presentarPanelBusquedaReserva();
		}
	}

	public void modificarReserva(Reserva reserva, boolean b) {
		this.lblTitulo.setText("MODIFICAR RESERVA");
		FrmPrincipal.mostrarPanel(this);
		this.presentarDatosReserva(reserva);
	}

	private void presentarDatosReserva(Reserva reserva) {
		this.huesped = reserva.getHuesped();
		this.reservaActual = reserva;
		this.txtDniHuesped.setText(huesped.getDniHuesped());
		this.txtNombre.setText(huesped.getNombre());
		this.txtApellido.setText(huesped.getApellido());
		this.dtFechaIngreso.setDate(reserva.getFechaEntrada());
		this.dtFechaSalida.setDate(reserva.getFechaSalida());
		this.txtMontoReserva.setText(String.valueOf(reserva.getValorTotal()));
		int pos = buscarPosicionFormaPago(reserva.getFormaPago().getIdFormaPago());
		this.cboFormaPago.setSelectedIndex(pos);
	}
	
	private int buscarPosicionFormaPago(int idFormaPago) {
		int pos = -1;
		
		for(int i = 0; i < this.cboFormaPago.getItemCount(); i++) {
			FormaPago formaPago = (FormaPago) this.cboFormaPago.getItemAt(i);
			if(formaPago.getIdFormaPago() == idFormaPago) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}
}
