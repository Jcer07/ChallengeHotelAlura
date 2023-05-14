package com.hotelalura.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.Insets;

@SuppressWarnings("serial")
public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	
	private JPanel pnlDashboard;
	private JPanel pnlHeader;
	private JPanel pnlCerrar;
	private JLabel lblCerrar;
	private JLabel lblIconoPrincipal;
	
	private JButton btnRegistrarReserva;
	private JButton btnBuscar;
	
	private int xMouse;
	private int yMouse;
	private JPanel pnlMinimizar;
	private JLabel lblMinimizar;
	private JPanel pnlFooter;
	private JLabel lblHora;
	private JButton btnLogOut;
	private static JPanel pnlContenedor;
	private static JLabel lblImgFondo;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	private void initComponents() {
		pnlDashboard = new JPanel();
		pnlDashboard.setBounds(0, 0, 220, 750);
		pnlDashboard.setBackground(new Color(0, 122, 204));
		
		pnlHeader = new JPanel();
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
		pnlHeader.setBounds(0, 0, 1400, 35);
		pnlHeader.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		contentPane.add(pnlDashboard);
		pnlDashboard.setLayout(null);
		
		lblIconoPrincipal = new JLabel("");
		lblIconoPrincipal.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\aH-150px.png"));
		lblIconoPrincipal.setBounds(34, 45, 150, 155);
		pnlDashboard.add(lblIconoPrincipal);
		
		btnRegistrarReserva = new JButton("Registrar Reserva");
		btnRegistrarReserva.setFocusPainted(false);
		btnRegistrarReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarReservaActionPerformed(e);
			}
		});
		btnRegistrarReserva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverButton(btnRegistrarReserva, true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hoverButton(btnRegistrarReserva, false);
			}
		});
		btnRegistrarReserva.setForeground(new Color(255, 255, 255));
		btnRegistrarReserva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrarReserva.setBackground(new Color(0, 122, 204));
		btnRegistrarReserva.setBorder(null);
		btnRegistrarReserva.setFont(new Font("Arial", Font.PLAIN, 16));
		btnRegistrarReserva.setBounds(0, 242, 220, 50);
		pnlDashboard.add(btnRegistrarReserva);
		
		btnBuscar = new JButton("Búsqueda");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscarActionPerformed();
			}
		});
		btnBuscar.setBorderPainted(false);
		btnBuscar.setFocusPainted(false);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverButton(btnBuscar, true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hoverButton(btnBuscar, false);
			}
		});
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(0, 122, 204));
		btnBuscar.setBounds(0, 292, 220, 50);
		pnlDashboard.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 205, 150, 3);
		pnlDashboard.add(separator);
		
		btnLogOut = new JButton("Cerrar Sesión");
		btnLogOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogOut.setMargin(new Insets(2, 50, 2, 14));
		btnLogOut.setIconTextGap(10);
		btnLogOut.setAlignmentY(Component.TOP_ALIGNMENT);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
			}
		});
		btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogOut.setBorderPainted(false);
		btnLogOut.setFocusPainted(false);
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverButton(btnLogOut, true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hoverButton(btnLogOut, false);
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(new Color(0, 122, 204));
		btnLogOut.setBounds(0, 700, 220, 50);
		pnlDashboard.add(btnLogOut);
		
		pnlHeader.setLayout(null);
		
		pnlCerrar = new JPanel();
		pnlCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
				int op = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que desea cerrar el programa?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
				
				if(op == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		pnlCerrar.setBounds(1365, 0, 35, 35);
		pnlCerrar.setBackground(new Color(255, 255, 255));
		pnlHeader.add(pnlCerrar);
		pnlCerrar.setLayout(null);
		
		lblCerrar = new JLabel("X");
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setBounds(7, 0, 20, 35);
		pnlCerrar.add(lblCerrar);
		lblCerrar.setFont(new Font("Arial", Font.PLAIN, 23));
		lblCerrar.setForeground(new Color(0, 0, 0));
		
		pnlMinimizar = new JPanel();
		pnlMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlMinimizar.setBackground(new Color(199, 199, 199));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlMinimizar.setBackground(new Color(255, 255, 255));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		pnlMinimizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pnlMinimizar.setBackground(new Color(255, 255, 255));
		pnlMinimizar.setBounds(1330, 0, 35, 35);
		pnlHeader.add(pnlMinimizar);
		pnlMinimizar.setLayout(null);
		
		lblMinimizar = new JLabel("_");
		lblMinimizar.setBounds(12, 0, 13, 27);
		lblMinimizar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimizar.setForeground(Color.BLACK);
		lblMinimizar.setFont(new Font("Arial", Font.PLAIN, 23));
		pnlMinimizar.add(lblMinimizar);
		contentPane.add(pnlHeader);
		
		pnlFooter = new JPanel();
		pnlFooter.setBackground(new Color(45, 45, 48));
		pnlFooter.setBounds(220, 715, 1180, 35);
		contentPane.add(pnlFooter);
		pnlFooter.setLayout(null);
		
		lblHora = new JLabel("");
		lblHora.setHorizontalTextPosition(SwingConstants.CENTER);
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(new Color(255, 255, 255));
		lblHora.setFont(new Font("Arial", Font.PLAIN, 20));
		lblHora.setBounds(450, 0, 280, 35);
		pnlFooter.add(lblHora);
		
		pnlContenedor = new JPanel();
		pnlContenedor.setBounds(220, 35, 1180, 680);
		contentPane.add(pnlContenedor);
		pnlContenedor.setLayout(null);
		
		cargarImgFondoPrincipal();
	}
	
	public static void mostrarPanel(JPanel pnl) {
		pnlContenedor.removeAll();
		pnlContenedor.repaint();
		pnlContenedor.add(pnl);
		pnlContenedor.repaint();
	}

	private void btnBuscarActionPerformed() {
		PnlFormBusqueda busqueda = new PnlFormBusqueda();
		mostrarPanel(busqueda);
	}

	private void registrarReservaActionPerformed(ActionEvent e) {
		PnlFormGuardarReserva registrar = new PnlFormGuardarReserva();
		mostrarPanel(registrar);
	}
	
	private void cerrarSesion() {
		int op = JOptionPane.showConfirmDialog(rootPane, "¿Seguro que desea cerrar sesión?", "Confirmación", JOptionPane.OK_CANCEL_OPTION);
		
		if(op == JOptionPane.OK_OPTION) {
			var frm = new FrmLogin();
			frm.setVisible(true);
			this.dispose();
		}
	}

	public static void cargarImgFondoPrincipal() {
		pnlContenedor.removeAll();
		pnlContenedor.repaint();
		FrmPrincipal.lblImgFondo = new JLabel("");
		FrmPrincipal.lblImgFondo.setIcon(new ImageIcon("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\ImgPrincipalRecepcion.png"));
		FrmPrincipal.lblImgFondo.setBounds(0, 0, 1180, 680);
		FrmPrincipal.pnlContenedor.add(lblImgFondo);
	}
	
	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Jcer\\Desktop\\One-Next-Education\\Challenge-Hotel-Alura\\src\\main\\resources\\Imagenes\\HotelAlura_IconoApp.png"));
		this.setUndecorated(true);
		this.setTitle("Hotel Alura");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 1400, 750);
		this.setLocationRelativeTo(null);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.initComponents();
		this.MostrarHora();
	}
	
	private void MostrarHora() {
		Timer time = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                Date fecha = new Date();
                SimpleDateFormat formatoHora = new SimpleDateFormat("dd/MM/yyyy    hh:mm:ss a");
                lblHora.setText(formatoHora.format(fecha));
            }
		});
		time.start();
	}

	private void hoverButton(JButton boton, boolean pintado) {
		if(pintado) {
			boton.setBackground(new Color(45, 45, 48));
		}
		else {
			boton.setBackground(new Color(0, 122, 204));
		}
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
