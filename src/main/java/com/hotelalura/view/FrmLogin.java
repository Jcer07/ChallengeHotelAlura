package com.hotelalura.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hotelalura.controller.UsuarioController;
import com.hotelalura.entities.Usuario;
import com.hotelalura.miscomponentes.MyPasswordField;
import com.hotelalura.miscomponentes.MyTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FrmLogin extends JFrame {

	private JPanel contentPane;
	
	private int xMouse, yMouse;
	
	private JPanel pnlHeader;
	private JPanel pnlCerrar;
	private JLabel lblCerrar;
	private JPanel pnlImgLogin;
	private JLabel lblImgLogin;
	private JLabel lblLogoHotel;
	private JPanel pnlLogin;
	private JLabel lblTituloLogin;
	private MyTextField txtUserName;
	private MyPasswordField txtPassword;
	private JButton btnLogin;
	private JLabel lblUserName;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Iniciar Sesión");
		this.inicializarComponentes();
	}

	private void inicializarComponentes() {
		pnlHeader = new JPanel();
		pnlHeader.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				pnlHeaderMouseDragged(e);
			}
		});
		pnlHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				pnlHeaderMousePressed(e);
			}
		});
		
		pnlImgLogin = new JPanel();
		pnlImgLogin.setBounds(0, 0, 400, 600);
		pnlImgLogin.setBackground(new Color(12, 138, 240));
		contentPane.add(pnlImgLogin);
		pnlImgLogin.setLayout(null);
		
		lblLogoHotel = new JLabel("");
		lblLogoHotel.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\aH-150px.png"));
		lblLogoHotel.setBounds(125, 41, 150, 150);
		pnlImgLogin.add(lblLogoHotel);
		
		lblImgLogin = new JLabel("");
		lblImgLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgLogin.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\imgHotelLogin-.png"));
		lblImgLogin.setBounds(0, 0, 400, 600);
		pnlImgLogin.add(lblImgLogin);
		pnlHeader.setBackground(new Color(255, 255, 255));
		pnlHeader.setBounds(0, 0, 900, 35);
		contentPane.add(pnlHeader);
		pnlHeader.setLayout(null);
		
		pnlCerrar = new JPanel();
		pnlCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlCerrar.setBackground(new Color(255, 255, 255));
		pnlCerrar.addMouseListener(new MouseAdapter() {
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
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		pnlCerrar.setBounds(865, 0, 35, 35);
		pnlHeader.add(pnlCerrar);
		pnlCerrar.setLayout(null);
		
		lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Arial", Font.PLAIN, 23));
		lblCerrar.setBounds(0, 0, 35, 35);
		pnlCerrar.add(lblCerrar);
		
		pnlLogin = new JPanel();
		pnlLogin.setBackground(new Color(255, 255, 255));
		pnlLogin.setBounds(400, 35, 500, 565);
		contentPane.add(pnlLogin);
		pnlLogin.setLayout(null);
		
		lblTituloLogin = new JLabel("INICIAR SESIÓN");
		lblTituloLogin.setForeground(new Color(12, 138, 220));
		lblTituloLogin.setFont(new Font("Arial", Font.BOLD, 26));
		lblTituloLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloLogin.setBounds(140, 50, 220, 30);
		pnlLogin.add(lblTituloLogin);
		
		txtUserName = new MyTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUserName.getText().equals("Ingrese su nombre de usuario")) {
					txtUserName.setText("");
					txtUserName.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().isEmpty()) {
					txtUserName.setText("Ingrese su nombre de usuario");
					txtUserName.setForeground(Color.GRAY);
				}
			}
		});
		txtUserName.setForeground(Color.GRAY);
		txtUserName.setText("Ingrese su nombre de usuario");
		txtUserName.setFont(new Font("Arial", Font.PLAIN, 14));
		txtUserName.setPrefixIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\user.png"));
		txtUserName.setBounds(50, 169, 400, 30);
		pnlLogin.add(txtUserName);
		
		txtPassword = new MyPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					iniciarSesion();
				}
			}
		});
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtPassword.getPassword()).equals("ºººººººººº")) {
					txtPassword.setText("");
					txtPassword.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(txtPassword.getPassword()).isEmpty()) {
					txtPassword.setText("ºººººººººº");
					txtPassword.setForeground(Color.GRAY);
				}
			}
		});
		txtPassword.setForeground(Color.GRAY);
		txtPassword.setText("ºººººººººº");
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		txtPassword.setPrefixIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\pass.png"));
		txtPassword.setLocation(50, 277);
		txtPassword.setSize(400, 30);
		
		pnlLogin.add(txtPassword);
		
		btnLogin = new JButton("Ingresar");
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					iniciarSesion();
				}
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarSesion();
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(10, 119, 207));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(12, 138, 240));
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBorder(null);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBackground(new Color(12, 138, 240));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.setBounds(162, 405, 150, 35);
		pnlLogin.add(btnLogin);
		
		lblUserName = new JLabel("Nombre de Usuario");
		lblUserName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUserName.setBounds(50, 146, 144, 13);
		lblUserName.setFocusable(true);
		pnlLogin.add(lblUserName);
		
		lblPassword = new JLabel("Contraseña");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPassword.setBounds(50, 254, 144, 13);
		pnlLogin.add(lblPassword);
		
	}

	private void iniciarSesion() {
		if(validaCampos()) {
			var userController = new UsuarioController();
			
			var user = new Usuario(this.txtUserName.getText().trim(),
					String.valueOf(this.txtPassword.getPassword()));
			if(userController.validaLogin(user)) {
				JOptionPane.showMessageDialog(rootPane, "Bienvenido", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
				var frm = new FrmPrincipal();
				this.dispose();
				frm.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(rootPane, "Usuario o Contraseña erróneos", this.getTitle(), JOptionPane.WARNING_MESSAGE);
			}
		}
		else {
			JOptionPane.showMessageDialog(rootPane, "Debe llenar todos los campos", this.getTitle(), JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private boolean validaCampos() {
		String userName = this.txtUserName.getText().trim();
		String password = String.valueOf(txtPassword.getPassword());
		
		if(userName.isEmpty() || userName.equals("Ingrese su nombre de usuario")
				|| password.isEmpty() || password.equals("ºººººººººº")) {
			return false;
		}
		
		return true;
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
