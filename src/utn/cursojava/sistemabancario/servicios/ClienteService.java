package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.dao.IClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public class ClienteService implements IClienteService {

	private IClienteDAO clienteDao;

	public ClienteService() {
		this.clienteDao = new ClienteDAO();
	}
	
	
	@Override
	public void agregarCliente(Cliente cliente) {
		clienteDao.agregarClienteDAO(cliente);;
	}
	
	public void agregarCuentaACliente(Cuenta cuenta) {
		
	}
	
	public void listarClientes() {
		System.out.println("\nClientes:\n");
		for (Cliente clientes : clienteDao.listarClientesDAO()) {
			System.out.println(clientes);
			System.out.println("\n");
		}
	}
	
	
	
	/*
	public void deleteCiente(String dni) {
		clienteDao.deleteCliente(dni);
	}

	// 31/03/1989
	public void validarFechaNacimiento(String fechaNacimiento) {
		// TODO: Validar que la edad sea mayor a 18 años
		
	}

	public Boolean validarEmail(String email) {
		// TODO: Validar que el email tenga un formato adecuado

		return Boolean.TRUE;
	}

	public List<Cliente> listarClientes(Integer nroSucursal) {
		return clienteDao.findClientsBySucursal(nroSucursal);
	}

	

	@Override
	public List<Cuenta> listarCuentas() {
		return clienteDao.listarCuentas();
	}
	*/


	
}
