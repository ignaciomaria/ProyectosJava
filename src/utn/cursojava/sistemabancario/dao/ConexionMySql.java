package utn.cursojava.sistemabancario.dao;

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
		}catch(ClassNotFoundException nfe) {
			nfe.printStackTrace();
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	//Traer conexion
	public Connection getConexion() {
		return this.conexion;
	}
	//Verifica si existe conexion
	public void verificarConexion() {
		if(this.getConexion() != null) {
				System.out.println("\nConexion exitosa con la base de datos.");
		}else {
			System.out.println("No se pudo conectar a la base de datos.");
		}
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
