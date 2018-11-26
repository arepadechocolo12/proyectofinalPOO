package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class LoginAdmin {

	JFrame frame;
	private JTextField textEmail;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin window = new LoginAdmin();
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
	public LoginAdmin() {
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
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(64, 61, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setBounds(173, 58, 205, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrasena\u00F1a");
		lblContrasena.setBounds(64, 136, 81, 14);
		frame.getContentPane().add(lblContrasena);
		
		password = new JPasswordField();
		password.setBounds(173, 133, 205, 20);
		frame.getContentPane().add(password);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//Conexion a la bd
					Class.forName("com.mysql.jdbc.Driver");			
					Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
					Statement stmt = con.createStatement();
					//Selecciona la tabla
					String sql = "Select * from cuenta where email='"+textEmail.getText()+"'and contrasena='"+password.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						Productos window = new Productos();
						window.frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Login erroneo...");
						con.close();
					}
				}catch (Exception e){
					System.out.print(e);
					
				}
			}
		});
		btnIniciar.setBounds(150, 184, 89, 23);
		frame.getContentPane().add(btnIniciar);
		
		JButton btnCrearCuenta = new JButton("Crear cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				CrearAdministrador crear = new CrearAdministrador();
				crear.frame.setVisible(true);
			}
		});
		btnCrearCuenta.setBounds(325, 238, 109, 23);
		frame.getContentPane().add(btnCrearCuenta);
		
		JLabel lblLoginDelAdministrador = new JLabel("Login del administrador");
		lblLoginDelAdministrador.setBounds(162, 22, 129, 14);
		frame.getContentPane().add(lblLoginDelAdministrador);
		
		JButton btnVolver = new JButton("Volver...");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio volver = new Inicio();
				volver.frame.setVisible(true);
			}
		});
		btnVolver.setBounds(0, 238, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		
	}

	protected void dispose() {
		initialize();
		
	}

	public void setVisible(boolean b) {
		initialize();
		
	}
}