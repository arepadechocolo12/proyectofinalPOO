package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Window.Type;

public class Inicio {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio window = new Inicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnAdministrador.setBackground(Color.WHITE);
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ingresar como administrador
				LoginAdmin inicio = new LoginAdmin();
				inicio.frame.setVisible(true);
			}
		});
		btnAdministrador.setBounds(71, 121, 143, 52);
		frame.getContentPane().add(btnAdministrador);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		btnCliente.setBackground(Color.WHITE);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ingresar como cliente
				ClienteProductos cliente = new ClienteProductos();
				cliente.frame.setVisible(true);
			}
		});
		btnCliente.setBounds(224, 121, 161, 52);
		frame.getContentPane().add(btnCliente);
		
		JLabel lblanuncio = new JLabel("Software de compras en linea");
		lblanuncio.setHorizontalAlignment(SwingConstants.CENTER);
		lblanuncio.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblanuncio.setBounds(71, 50, 314, 42);
		frame.getContentPane().add(lblanuncio);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(btnSalir);
	}
}
