package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.modelo.Cuenta;

public interface ICuentaService {
	
	public Cuenta crearCuenta(Integer numCuenta, Double saldo, String cbu, String tipoMoneda);
	
	/*public Double extraer(Double monto);

	public void depositar(Double monto);
	
	*/
}
