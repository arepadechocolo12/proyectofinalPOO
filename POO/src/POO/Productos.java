package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Window.Type;

public class Productos {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Crea una nueva ventana en blanco y despues la llama
					Productos window = new Productos();
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
	public Productos() {
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
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Crea una nueva ventana en blanco y despues la llama

				AgregarProducto Agregar = new AgregarProducto();
				Agregar.frame.setVisible(true);
			}
		});
		btnAgregarProducto.setBounds(26, 23, 129, 23);
		frame.getContentPane().add(btnAgregarProducto);
		
		JButton btnGenerarFactura = new JButton("Generar Factura");
		btnGenerarFactura.setBounds(180, 23, 123, 23);
		frame.getContentPane().add(btnGenerarFactura);
		
		JButton btnVolver = new JButton("Volver...");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Crea una nueva ventana en blanco y despues la llama
				LoginAdmin inicio = new LoginAdmin();
				inicio.frame.setVisible(true);
			}
		});
		btnVolver.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		table = new JTable();
		table.setBounds(26, 57, 387, 170);
		frame.getContentPane().add(table);
		
		//Conecta a la base de datos
		Conexion con = new Conexion();
		Connection conexion = (Connection) con.conectar();
		
		//Selecciona todos los productos de la tabla productos de la base de datos
		String sql = "SELECT * FROM productos";
		
		Statement st;
		
		DefaultTableModel model= new DefaultTableModel();
		
		//muestra los campos id nombre y precio de la tabla productos
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Precio");
		
		table.setModel(model);
		
		String[] dato = new String[3];
		try {
			st = (Statement) conexion.createStatement();
			
			ResultSet result = st.executeQuery(sql);
			
			//Actualiza y realiza la accion dentro de un  cilo(actualiza automaticamente)
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				model.addRow(dato);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
			
	}
}
