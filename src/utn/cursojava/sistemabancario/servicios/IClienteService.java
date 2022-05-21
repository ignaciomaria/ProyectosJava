package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface IClienteService {

	public void agregarCliente(Cliente cliente);
	public void agregarCuentaACliente(Cuenta cuenta);
	public void listarClientes();
	
	/*
	
	public List<Cliente> listarClientes(Integer nroSucursal);
	
	public List<Cuenta> listarCuentas();*/

}
