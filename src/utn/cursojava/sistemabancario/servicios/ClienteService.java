package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.dao.ClienteDAO;
import utn.cursojava.sistemabancario.dao.IClienteDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;

public class ClienteService implements IClienteService {

	private IClienteDAO clienteDao;

	public ClienteService() {
		this.clienteDao = new ClienteDAO();
	}
	
	
	@Override
	public void agregarCliente(Integer dni, String nombreApellido, Integer telefono, String email, String domicilio) {
		//nroCliente es auto-incremental
		int nroCliente=1;
		List<Cliente> listaAux = this.listarClientes();
		if(listaAux.size()>0) {
			 nroCliente = listaAux.get(listaAux.size()-1).getNroCliente()+1;
		}
		Cliente cliente = new Cliente(nroCliente ,dni, nombreApellido, telefono, email, domicilio);
		clienteDao.agregarClienteDAO(cliente);
	}
	
	public void imprimirClientes() {
		ICuentaService cuentaService = new CuentaService();
		System.out.println("\nClientes:");
		for (Cliente clientes : this.listarClientes()) {
			System.out.println(clientes);
			cuentaService.imprimirCuentas(clientes);
		}
	}
	
	@Override
	public List<Cliente> listarClientes() {
		// TODO Auto-generated method stub
		return clienteDao.listarClientesDAO();
	}
	
	@Override
	public void eliminarCliente(Integer dni) {
		// TODO Auto-generated method stub
		clienteDao.eliminarCliente(dni);
		System.out.println("El cliente con DNI "+dni+" fue eliminado.");
	}

	@Override
	public void eliminarClientes() {
		// TODO Auto-generated method stub
		clienteDao.eliminarTodosClientes();
		System.out.println("Todos los clientes fueron eliminados.");
	}
	
}
