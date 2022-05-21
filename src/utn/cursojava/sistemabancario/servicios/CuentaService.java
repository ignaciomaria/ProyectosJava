package utn.cursojava.sistemabancario.servicios;

import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public class CuentaService implements ICuentaService {
	
	private CuentaDAO cuentaDAO;
	
	public CuentaService() {
		cuentaDAO = new CuentaDAO();
	}
	
	public Cuenta crearCuenta(Integer numCuenta, Double saldo, String cbu, String tipoMoneda) {
		Cuenta c = new Cuenta(numCuenta, saldo, cbu, tipoMoneda);
		cuentaDAO.agregarCuentaDAO(c);
		return c;
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
