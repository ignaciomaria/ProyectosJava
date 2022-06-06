package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;

public interface IClienteService {

	public void agregarCliente(Integer dni, String nombreApellido, Integer telefono, String email, String domicilio);
	public void imprimirClientes();
	public List<Cliente> listarClientes();
	public void eliminarCliente(Integer dni);
	public void eliminarClientes();
	

}
