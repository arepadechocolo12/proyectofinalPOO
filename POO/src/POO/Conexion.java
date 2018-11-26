package POO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	Connection con;
	
	public Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");			
		 con = DriverManager.getConnection("jdbc:mysql://localhost/poo", "root", "");
			//JOptionPane.showMessageDialog(null, "Conectado a la BD");
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Error al conectar la BD");
		}
		return con;
	}
	
	
}
