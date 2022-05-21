package utn.cursojava.sistemabancario.dao;

import java.util.ArrayList;
import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cuenta;

public class CuentaDAO implements ICuentaDAO {
	
	//Base de datos temporal
	private List<Cuenta> cuentas;
	
	public CuentaDAO() {
		this.cuentas = new ArrayList<Cuenta>();
	}
	
	public void agregarCuentaDAO(Cuenta cuenta) {
		cuentas.add(cuenta);
	}

	@Override
	public List<Cuenta> listarCuentasDAO() {
		// TODO Auto-generated method stub
		return cuentas;
	}
}
