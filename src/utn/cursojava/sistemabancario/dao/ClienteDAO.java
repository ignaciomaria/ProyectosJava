package utn.cursojava.sistemabancario.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;

public class ClienteDAO implements IClienteDAO {
	
	public ClienteDAO() {
	}
	
	@Override
	public void agregarClienteDAO(Cliente cliente) {	
		ConexionMySql conexion = new ConexionMySql();
		try (Statement estado = conexion.getConexion().createStatement()){
		estado.executeUpdate("insert into CLIENTES values("+cliente.getNroCliente()+","
														+cliente.getDni()+",'"
														+cliente.getNombreApellido()+"',"
														+cliente.getTelefono()+",'"
														+cliente.getEmail()+"','"
														+cliente.getDomicilio()+"');");
		} catch (SQLException e) {
			//Si existe un registro repetido, esta Exception se atrapa en el main
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
	}
	
	//Trae todos los clientes de la base de datos y los agrega a una lista
	public List<Cliente> listarClientesDAO() {
		List<Cliente> listaAux = new ArrayList<Cliente>();
		ConexionMySql conexion = new ConexionMySql();
		
		try (Statement estado = conexion.getConexion().createStatement()){
			ResultSet reS = estado.executeQuery("select* from CLIENTES;");
			Cliente clienteAux;
			while(reS.next()) {
				clienteAux = new Cliente(reS.getInt(1), reS.getInt(2), reS.getString(3), reS.getInt(4),
										 reS.getString(5), reS.getString(6));
				listaAux.add(clienteAux);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}
		
		return listaAux;
	}
	@Override
	public void eliminarCliente(Integer dni) {
		// TODO Auto-generated method stub
		ConexionMySql conexion = new ConexionMySql();
		
		try (Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("delete from CLIENTES where dni = "+dni+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			conexion.cerrarConexion();
		}
	}
	
	@Override
	public void eliminarTodosClientes() {
		// TODO Auto-generated method stub
		ConexionMySql conexion = new ConexionMySql();
		
		try (Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("delete from CLIENTES;");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
	}
	
}
