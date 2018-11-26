package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.DriverManager;
//import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Window.Type;

public class AgregarProducto {

	JFrame frame;
	private JTextField textNombreP;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarProducto window = new AgregarProducto();
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
	public AgregarProducto() {
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
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto");
		lblNombreDelProducto.setBounds(65, 76, 132, 14);
		frame.getContentPane().add(lblNombreDelProducto);
		
		JLabel lblPrecioDelProducto = new JLabel("Precio del producto");
		lblPrecioDelProducto.setBounds(65, 123, 117, 14);
		frame.getContentPane().add(lblPrecioDelProducto);
		
		textNombreP = new JTextField();
		textNombreP.setBounds(207, 73, 169, 20);
		frame.getContentPane().add(textNombreP);
		textNombreP.setColumns(10);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(207, 120, 169, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAgregarProducto = new JLabel("Agregar producto");
		lblAgregarProducto.setFont(new Font("Broadway", Font.PLAIN, 18));
		lblAgregarProducto.setBounds(119, 27, 213, 31);
		frame.getContentPane().add(lblAgregarProducto);
		
		JButton btnAgregarProducto = new JButton("Agregar producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");			
					java.sql.Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/poo", "root", "");
				
					Statement statement = conexion.createStatement();
					
					String nombre = textNombreP.getText();
					String precio = textField.getText();		
					
					String query = "INSERT INTO productos (nombreProducto,precio) values('"+nombre+"','"+precio+"')";
					Statement stmt = conexion.createStatement();
					
					stmt.executeUpdate(query);
					
					JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
					}catch (ClassNotFoundException o) {
						o.printStackTrace();
					}catch (SQLException l) {
						l.printStackTrace();
					}
			}
		});
		btnAgregarProducto.setBounds(150, 173, 135, 23);
		frame.getContentPane().add(btnAgregarProducto);
		
		JButton btnVolver = new JButton("Volver...");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Productos atras = new Productos();
				atras.frame.setVisible(true);
			}
		});
		btnVolver.setBounds(0, 238, 89, 23);
		frame.getContentPane().add(btnVolver);
	}
}
