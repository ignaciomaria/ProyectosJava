package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.CajaDeAhorro;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.modelo.CuentaCorriente;

public class CuentaService implements ICuentaService {
	
	private CuentaDAO cuentaDAO;
	
	public CuentaService() {
		cuentaDAO = new CuentaDAO();
	}
	
	public CuentaCorriente crearCuentaCorriente(Integer numCuenta, Double saldo, String cbu) {
		CuentaCorriente cC = new CuentaCorriente(numCuenta, saldo, cbu);
		cuentaDAO.agregarCuentaDAO(cC);
		return cC;
	}
	public CajaDeAhorro crearCajaDeAhorro(Integer numCuenta, Double saldo, String cbu, String tipoMoneda) {
		CajaDeAhorro cC = new CajaDeAhorro(numCuenta, saldo, cbu, tipoMoneda);
		cuentaDAO.agregarCuentaDAO(cC);
		return cC;
	}
	
	public void listarCuentas() {
		for (Cuenta cuenta : cuentaDAO.listarCuentasDAO()) {
			System.out.println(cuenta);
			System.out.println("\n");
		}
	}
	
	/*@Override
	public Double extraer(Double monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depositar(Double monto) {
		// TODO Auto-generated method stub
		
	}*/
}
