package utn.cursojava.sistemabancario.dao;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaDAO {
	
	public void agregarCuentaDAO(Cuenta cuenta);
	
	public List<Cuenta> listarCuentasDAO();
}
