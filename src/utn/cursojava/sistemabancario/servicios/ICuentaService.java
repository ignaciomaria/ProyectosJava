package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaService {
	
	public void crearCuenta(Integer dniCliente, Integer tipoCuenta, Double saldo, Integer cbu, String tipoMoneda);
	public void consultarSaldo(Integer cbu);
	public void imprimirCuentas(Cliente cliente);
	public void imprimirCuentas();
	public List<Cuenta> listarCuentas();
	public List<Cuenta> listarCuentasDeCliente(Cliente cliente);
	public void eliminarCuentas();
	public void eliminarCuenta(Integer cbu);
	/*public Double extraer(Double monto);

	public void depositar(Double monto);
	
	*/
}
