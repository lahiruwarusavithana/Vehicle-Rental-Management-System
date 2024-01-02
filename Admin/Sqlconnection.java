package Admin;

import java.sql.*;
import javax.swing.JOptionPane;
public class Sqlconnection {
	
	Connection conn = null ;
	
	public static Connection dbConnector() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiclerent","root","");
			return conn;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection fail");
			return null;
		}
	}
	

}
