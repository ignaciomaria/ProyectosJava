package utn.cursojava.sistemabancario.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.constants.ConexionMySql;
import utn.cursojava.sistemabancario.modelo.Cliente;

public class ClienteDAO implements IClienteDAO {
	
	//base de datos temporal
	//private List<Cliente> clientes;
	
	private ConexionMySql conexion = new ConexionMySql();
	
	public ClienteDAO() {
		//this.clientes = new ArrayList<Cliente>();
	}
	
	
	@Override
	public void agregarClienteDAO(Cliente cliente) {	
		try (Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("insert into CLIENTES values("+cliente.getNroCliente()+","
															+cliente.getDni()+",'"
															+cliente.getNombreApellido()+"',"
															+cliente.getTelefono()+",'"
															+cliente.getEmail()+"','"
															+cliente.getDomicilio()+"');");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
		//clientes.add(cliente);
	}
	
	public List<Cliente> listarClientesDAO() {
		List<Cliente> listaAux = new ArrayList<Cliente>();
		
		try (Statement estado = conexion.getConexion().createStatement()){
			ResultSet reS = estado.executeQuery("select* from CLIENTES;");
			while(reS.next()) {
				Cliente clienteAux = new Cliente(reS.getInt(1), reS.getInt(2), reS.getString(3), reS.getInt(4),
										 reS.getString(5), reS.getString(6));
				listaAux.add(clienteAux);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
		return listaAux;
	}
	/*
	public List<Cliente> listarClientes() {
		String url = "jdbc:mysql://localhost:3306/sistema_bancario";
		String userName = "root";
		String password = "root";

		Connection con;
		try {
			// 1) Register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2) Create the connection object
			con = DriverManager.getConnection(url, userName, password);

			// 3) Create the Statement object
			Statement stmt = con.createStatement();

			// 4) Ejecución de Query
			ResultSet rs = stmt.executeQuery("select NRO_CLIENTE, CUIL, NOMBRE_APELLIDO from CLIENTES");

			Cliente cliente;
			while (rs.next()) {
				cliente = new Cliente();
				Integer nroCliente = rs.getInt(1);
				cliente.setDni(rs.getString(2));// xx-xxxxxxxx-x, TODO: seteear cuil con formato esperado por el objeto
												// cliente
				cliente.setNombreApellido(rs.getString(3));

				clientes.add(cliente);
			}

			
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
		
			// 5) Cerrar la conexión
			con.close();
		}

		return clientes;

	}*/

/*
	@Override
	public void deleteCliente(String dni) {
		// TODO Auto-generated method stub
		for(int i=0; i<clientes.size(); i++) {
			if(clientes.get(i).getDni() == dni) {
				clientes.remove(i);
			}
		}
	}

	

	public List<Cliente> findClientsBySucursal(Integer nroSucursal) { // nroSucursal:1
		List<Cliente> clientePorSucursal = new ArrayList<>();

		// SELECT * FROM CLIENTES where id_sucursal = 1
		for (Cliente cliente : clientes) {
			if (cliente.getSucursalId().equals(nroSucursal)) {
				clientePorSucursal.add(cliente);
			}

		}
		return clientePorSucursal;
	}

	public List<Cuenta> listarCuentas() {
		return this.cuentas;
	}
*/
}
