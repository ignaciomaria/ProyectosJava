package utn.cursojava.sistemabancario.constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionMySql {
	
	private String mySqlDriver = "com.mysql.cj.jdbc.Driver";
	private String urlDB = "jdbc:mysql://localhost:3306/sistema_bancario";
	private String user = "root";
	private String pass = "Ignacio_1994";
	
	Connection conexion=null;
	//Constructor
	public ConexionMySql() {
		try {
			//Registrar driver
			Class.forName(mySqlDriver);
			//establecer conexion
			conexion = DriverManager.getConnection(urlDB, user, pass);
			if(conexion != null) {
				System.out.println("Conexion exitosa");
			}
		}catch(ClassNotFoundException nfe) {
			nfe.printStackTrace();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	//Verifica si existe conexion
	public Connection getConexion() {
		return this.conexion;
	}
	//Cerrar conexion
	public void cerrarConexion() {
		if(conexion != null) {
			try {
				conexion.close();;
			}catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
	}
	//Getter
	public String getMysqldriver() {
		return mySqlDriver;
	}

	public String getUrldb() {
		return urlDB;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
}
