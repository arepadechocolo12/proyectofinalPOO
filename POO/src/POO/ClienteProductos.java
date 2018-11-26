package POO;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class ClienteProductos {

	JFrame frame;
	private JTable table;
	private JLabel lblProductosDelAlamacen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteProductos window = new ClienteProductos();
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
	public ClienteProductos() {
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
		
		JButton btnVolver = new JButton("Volver...");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicio inicio = new Inicio();
				inicio.frame.setVisible(true);
			}
		});
		btnVolver.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		table = new JTable();
		table.setBounds(26, 57, 387, 170);
		frame.getContentPane().add(table);
		
		Conexion con = new Conexion();
		Connection conexion = (Connection) con.conectar();
		
		String sql = "SELECT * FROM productos";
		
		Statement st;
		
		DefaultTableModel model= new DefaultTableModel();
		
		model.addColumn("Id");
		model.addColumn("Nombre");
		model.addColumn("Precio");
		
		table.setModel(model);
		
		lblProductosDelAlamacen = new JLabel("Productos del almacen");
		lblProductosDelAlamacen.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductosDelAlamacen.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblProductosDelAlamacen.setBounds(26, 11, 387, 35);
		frame.getContentPane().add(lblProductosDelAlamacen);
		
		String[] dato = new String[3];
		try {
			st = (Statement) conexion.createStatement();
			
			ResultSet result = st.executeQuery(sql);
			
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
