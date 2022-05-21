package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.CajaDeAhorro;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;

public interface ICuentaService {
	
	public CuentaCorriente crearCuentaCorriente(Integer numCuenta, Double saldo, String cbu);
	
	public CajaDeAhorro crearCajaDeAhorro(Integer numCuenta, Double saldo, String cbu, String tipoMoneda);
	
	/*public Double extraer(Double monto);

	public void depositar(Double monto);
	
	*/
}
