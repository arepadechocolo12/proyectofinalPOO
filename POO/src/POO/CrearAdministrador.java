package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;


public class CrearAdministrador {

	JFrame frame;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Crea una nueva ventana en blanco y despues la llama
					CrearAdministrador window = new CrearAdministrador();
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
	
	public CrearAdministrador() {
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
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblNombre.setBounds(51, 62, 79, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblEmail.setBounds(51, 101, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
		lblContrasea.setBounds(51, 139, 79, 14);
		frame.getContentPane().add(lblContrasea);
		
		textNombre = new JTextField();
		textNombre.setBounds(165, 59, 216, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(165, 98, 216, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(165, 136, 216, 20);
		frame.getContentPane().add(textContrasena);
		textContrasena.setColumns(10);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.setBackground(Color.WHITE);
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Conexion con = new Conexion();
				Connection conexion = con.conectar();
				try {
					//hace llamado a la ventana de conexion que conecta con la base de datos
					String query = "INSERT INTO cuenta (nombre,email,contrasena) values(?,?,?)";
					java.sql.PreparedStatement statement = conexion.prepareStatement(query);
					
					statement.setString(1, textNombre.getText());
					statement.setString(2, textEmail.getText());
					statement.setString(3, textContrasena.getText());
					
					statement.executeUpdate();
					
					conexion.close();
					//Realiza un evento de modo texto confirmando que la cuenta se agrego
					JOptionPane.showMessageDialog(null, "Cuenta agregada correctamente");
					/*((java.sql.Statement)statement).executeUpdate("Insert into cuenta(nombre) values('"+nombre+"')");				
					((java.sql.Statement)statement).executeUpdate("Insert into cuenta(email) values('"+email+"')");				
					((java.sql.Statement)statement).executeUpdate("Insert into cuenta(contrasena) values('"+contrasena+"')");
					conexion.close();*/
					}
					catch (Exception o) {
						System.out.println("Error al crear la cuenta");
						o.printStackTrace();
					}
			}
		});
		
		btnCrearCuenta.setBounds(154, 196, 118, 23);
		frame.getContentPane().add(btnCrearCuenta);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//agrega una ventana en blanco y luego abre la ventana loginAdmin
				LoginAdmin inicio = new LoginAdmin();
				inicio.frame.setVisible(true);
			}
		});
		btnVolverAtras.setBounds(330, 238, 104, 23);
		frame.getContentPane().add(btnVolverAtras);
		
		JLabel lblCrearCuenta = new JLabel("Crear Cuenta");
		lblCrearCuenta.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblCrearCuenta.setBounds(165, 23, 201, 14);
		frame.getContentPane().add(lblCrearCuenta);
	}	
}
