package com.hotelalura.view;


import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;

import com.hotelalura.controller.HuespedController;
import com.hotelalura.controller.NacionalidadController;
import com.hotelalura.entities.Huesped;
import com.hotelalura.entities.Nacionalidad;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmGuardarHuesped extends JDialog {
	private JLabel lblCerrar;
	private JLabel lblTitulo;
	private JLabel lblDniHuesped;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblFechaDeNacimiento;
	private JLabel lblNacionalidad;
	private JLabel lblTelefono;
	private JLabel lblImgFondo;
	
	private JPanel pnlCerrar;
	private JPanel pnlHeader;
	private JPanel pnlImgFondo;
	private JPanel pnlHuesped;
	
	private JTextField txtDniHuesped;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	
	private JDateChooser dtFechaNacimiento;
	
	private JComboBox<Nacionalidad> cboNacionalidad;
	
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private int xMouse;
	private int yMouse;
	private boolean opcion;

	/**
	 * Create the dialog.
	 */
	public FrmGuardarHuesped(Frame parent, boolean modal) {
		super(parent, modal);
		getContentPane().setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 900, 600);
		setTitle("Registro de Huesped");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		pnlImgFondo = new JPanel();
		pnlImgFondo.setBackground(new Color(12, 138, 199));
		pnlImgFondo.setBounds(0, 0, 500, 600);
		getContentPane().add(pnlImgFondo);
		pnlImgFondo.setLayout(null);
		
		lblImgFondo = new JLabel("");
		lblImgFondo.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\registro.png"));
		lblImgFondo.setBounds(0, 40, 500, 550);
		pnlImgFondo.add(lblImgFondo);
		
		pnlHeader = new JPanel();
		pnlHeader.setBackground(new Color(255, 255, 255));
		pnlHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHeaderMousePressed(e);
			}
		});
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				pnlHeaderMouseDragged(e);
			}
		});
		pnlHeader.setBounds(0, 0, 900, 30);
		getContentPane().add(pnlHeader);
		pnlHeader.setLayout(null);
		
		pnlCerrar = new JPanel();
		pnlCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlCerrar.setBackground(new Color(255, 255, 255));
		pnlCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlCerrar.setBackground(Color.RED);
				lblCerrar.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlCerrar.setBackground(Color.WHITE);
				lblCerrar.setForeground(Color.BLACK);
			}
		});
		pnlCerrar.setBounds(870, 0, 30, 30);
		pnlHeader.add(pnlCerrar);
		pnlCerrar.setLayout(null);
		
		lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCerrar.setBounds(0, 0, 30, 30);
		pnlCerrar.add(lblCerrar);
		
		pnlHuesped = new JPanel();
		pnlHuesped.setBackground(new Color(255, 255, 255));
		pnlHuesped.setBounds(500, 30, 400, 570);
		getContentPane().add(pnlHuesped);
		pnlHuesped.setLayout(null);
		
		lblTitulo = new JLabel("REGISTRO DE HUESPED");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(12, 138, 220));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(60, 10, 280, 30);
		pnlHuesped.add(lblTitulo);
		
		lblDniHuesped = new JLabel("Dni de Huesped");
		lblDniHuesped.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDniHuesped.setBounds(20, 62, 120, 15);
		pnlHuesped.add(lblDniHuesped);
		
		txtDniHuesped = new JTextField();
		txtDniHuesped.addKeyListener(new KeyAdapter() {
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
		txtDniHuesped.setFont(new Font("Arial", Font.PLAIN, 14));
		txtDniHuesped.setColumns(10);
		txtDniHuesped.setBounds(20, 87, 360, 30);
		pnlHuesped.add(txtDniHuesped);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNombres.setBounds(20, 137, 120, 15);
		pnlHuesped.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
					e.consume();
				}
			}
		});
		txtNombres.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(20, 162, 360, 30);
		pnlHuesped.add(txtNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		lblApellidos.setBounds(20, 212, 120, 15);
		pnlHuesped.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
					e.consume();
				}
			}
		});
		txtApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(20, 237, 360, 30);
		pnlHuesped.add(txtApellidos);
		
		lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFechaDeNacimiento.setBounds(20, 287, 153, 15);
		pnlHuesped.add(lblFechaDeNacimiento);
		
		dtFechaNacimiento = new JDateChooser();
		dtFechaNacimiento.setFont(new Font("Arial", Font.PLAIN, 14));
		dtFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dtFechaNacimiento.setBounds(20, 312, 360, 30);
		pnlHuesped.add(dtFechaNacimiento);
		
		lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNacionalidad.setBounds(20, 362, 97, 15);
		pnlHuesped.add(lblNacionalidad);
		
		cboNacionalidad = new JComboBox<Nacionalidad>();
		cboNacionalidad.setFont(new Font("Arial", Font.PLAIN, 14));
		cboNacionalidad.setBounds(20, 387, 360, 30);
		pnlHuesped.add(cboNacionalidad);
		this.cargarModeloCombo();
		cboNacionalidad.setSelectedIndex(0);
		
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefono.setBounds(20, 437, 120, 15);
		pnlHuesped.add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
				
				if(txtTelefono.getText().length() >= 9) {
					e.consume();
				}
			}
		});
		txtTelefono.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(20, 462, 360, 30);
		pnlHuesped.add(txtTelefono);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardarActionPerformed();
			}
		});
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnGuardar.setBorder(null);
		btnGuardar.setBackground(new Color(12, 138, 240));
		btnGuardar.setBounds(130, 520, 120, 30);
		pnlHuesped.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(118, 121, 123));
		btnCancelar.setBounds(260, 520, 120, 30);
		pnlHuesped.add(btnCancelar);
	}

	private void btnGuardarActionPerformed() {
		if(validaCampos()) {
			var huesped = crearHuesped();
			var huespedController = new HuespedController();
			
			if(opcion) {
				huespedController.registrarHuesped(huesped);
				JOptionPane.showMessageDialog(null, "Huesped guardado con exito");
				dispose();
			}
			else {
				huespedController.modificarHuesped(huesped);
				JOptionPane.showMessageDialog(null, "Huesped modificado con exito");
				dispose();
			}
		}
	}

	private Huesped crearHuesped() {
		Huesped huesped = new Huesped(
				this.txtDniHuesped.getText().trim(),
				this.txtNombres.getText().trim(),
				this.txtApellidos.getText().trim(),
				this.dtFechaNacimiento.getDate(),
				(Nacionalidad)this.cboNacionalidad.getSelectedItem(),
				this.txtTelefono.getText().trim()
			);
		
		/*if(huespedActual != null) {
			
		}*/
		
		return huesped;
	}

	private void cargarModeloCombo() {
		DefaultComboBoxModel<Nacionalidad> modeloCombo = new DefaultComboBoxModel<>();
		var nacionalidadController = new NacionalidadController();
		var listadoNacionalidades = nacionalidadController.listarNacionalidades();
		modeloCombo.addAll(listadoNacionalidades);
		cboNacionalidad.setModel(modeloCombo);
	}
	
	private boolean validaCampos() {
		
		if(this.txtDniHuesped.getText().isEmpty() || this.txtDniHuesped.getText().length() < 8) {
			return false;
		}
		
		if(this.txtNombres.getText().isEmpty() ) {
			return false;
		}
		
		if(this.txtApellidos.getText().isEmpty() ) {
			return false;
		}
		
		if(this.dtFechaNacimiento.getDate() == null) {
			return false;
		}
		
		if(this.cboNacionalidad.getSelectedIndex() == 0) {
			return false;
		}
		
		if(this.txtTelefono.getText().isEmpty()) {
			return false;
		}
		
		return true;
	}

	public void mostrarJDialog(String dniHuesped, String titulo, boolean op) {
		this.opcion = op;
		this.lblTitulo.setText(titulo);
		this.txtDniHuesped.setText(dniHuesped);
		if(!opcion) {
			this.txtDniHuesped.setEditable(false);
			this.mostrarDatosHuesped(dniHuesped);
		}
		this.setVisible(true);
	}
	
	private void mostrarDatosHuesped(String dniHuesped) {
		var huespedController = new HuespedController();
		var huesped = huespedController.buscarHuespedEdit(dniHuesped);
		this.txtNombres.setText(huesped.getNombre());
		this.txtApellidos.setText(huesped.getApellido());
		this.dtFechaNacimiento.setDate(huesped.getFechaNacimiento());
		
		int posComboBox = this.buscarPosicionNacionalidad(huesped.getNacionalidad().getIdNacionalidad());
		
		this.cboNacionalidad.setSelectedIndex(posComboBox);
		this.txtTelefono.setText(huesped.getTelefono());
	}

	private int buscarPosicionNacionalidad(int idNacionalidad) {
		int pos = -1;
		Nacionalidad nacionalidad;
		for (int i = 0; i < this.cboNacionalidad.getItemCount(); i++) {
			nacionalidad = (Nacionalidad)this.cboNacionalidad.getItemAt(i);
			
			if(nacionalidad.getIdNacionalidad() == idNacionalidad) {
				pos = i;
				break;
			}
		}
		
		return pos;
	}

	private void pnlHeaderMousePressed(MouseEvent e) {
		xMouse = e.getX();
		yMouse = e.getY();
	}
	
	private void pnlHeaderMouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		this.setLocation(x- xMouse, y - yMouse);
	}
}
