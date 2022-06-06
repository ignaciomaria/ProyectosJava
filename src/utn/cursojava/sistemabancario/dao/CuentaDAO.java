package utn.cursojava.sistemabancario.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public class CuentaDAO implements ICuentaDAO {
	
	public CuentaDAO() {
	}
	
	//Ingresa una nueva cuenta a la base de datos
	public void agregarCuentaDAO(Cuenta cuenta) {
		ConexionMySql conexion = new ConexionMySql();
		try(Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("insert into CUENTAS value("+cuenta.getNroCuenta()+",'"
															+cuenta.getDescripcion()+"',"
															+cuenta.getSaldo()+","
															+cuenta.getCbu()+",'"
															+cuenta.getTipoMoneda()+"',"
															+cuenta.getDniCliente()+");");
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally {
			conexion.cerrarConexion();
		}
	}
	
	//Arma una lista de las cuentas del cliente que ingresa por parametro
	@Override
	public List<Cuenta> listarCuentasDAO(Cliente cliente) {
		// TODO Auto-generated method stub
		List<Cuenta> cuentasAux = new ArrayList<Cuenta>();
		ConexionMySql conexion = new ConexionMySql();
		try(Statement estado = conexion.getConexion().createStatement()){
			ResultSet rs = estado.executeQuery("select* from CUENTAS where DNI_CLIENTE="+cliente.getDni()+";");
			Cuenta cuenta;
			while(rs.next()) {
				cuenta = new Cuenta();
				cuenta.setNroCuenta(rs.getInt(1));
				cuenta.setDescripcion(rs.getString(2));
				cuenta.setSaldo(rs.getDouble(3));
				cuenta.setCbu(rs.getInt(4));
				cuenta.setTipoMoneda(rs.getString(5));
				cuenta.setDniCliente(rs.getInt(6));
				cuentasAux.add(cuenta);
			}
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally {
			conexion.cerrarConexion();
		}
		return cuentasAux;
	}
	
	//Arma una lista de todas las cuentas de la tabla
	@Override
	public List<Cuenta> listarCuentasDAO() {
		// TODO Auto-generated method stub
		List<Cuenta> cuentasAux = new ArrayList<Cuenta>();
		ConexionMySql conexion = new ConexionMySql();
		try(Statement estado = conexion.getConexion().createStatement()){
			ResultSet rs = estado.executeQuery("select* from CUENTAS;");
			Cuenta cuenta;
			while(rs.next()) {
				cuenta = new Cuenta();
				cuenta.setNroCuenta(rs.getInt(1));
				cuenta.setDescripcion(rs.getString(2));
				cuenta.setSaldo(rs.getDouble(3));
				cuenta.setCbu(rs.getInt(4));
				cuenta.setTipoMoneda(rs.getString(5));
				cuenta.setDniCliente(rs.getInt(6));
				cuentasAux.add(cuenta);
			}
		}catch(SQLException sqle) {
			throw new RuntimeException(sqle);
		}finally {
			conexion.cerrarConexion();
		}
		return cuentasAux;
	}
	
	//Elimina la cuenta con el cbu ingresado por parametro
	@Override
	public void eliminarCuenta(Integer cbu) {
		// TODO Auto-generated method stub
		ConexionMySql conexion = new ConexionMySql();
		try (Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("delete from CUENTAS where cbu = "+cbu+";");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
	}
	
	//Elimina todas las cuentas de la tabla
	@Override
	public void eliminarCuentas() {
		// TODO Auto-generated method stub
		ConexionMySql conexion = new ConexionMySql();
		try (Statement estado = conexion.getConexion().createStatement()){
			estado.executeUpdate("delete from CUENTAS;");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			conexion.cerrarConexion();
		}
	}
}
