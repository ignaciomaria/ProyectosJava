package utn.cursojava.sistemabancario.servicios;

import java.util.List;

import utn.cursojava.sistemabancario.dao.CuentaDAO;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;

public class CuentaService implements ICuentaService {
	
	private CuentaDAO cuentaDAO;
	
	public CuentaService() {
		cuentaDAO = new CuentaDAO();
	}
	
	//Crea una nueva cuenta, la asigna al dni del cliente ingresado
	public void crearCuenta(Integer dniCliente, Integer tipoCuenta, Double saldo, Integer cbu, String tipoMoneda) {
		List<Cuenta> listaAux = this.listarCuentas();
		int id = 1;
		if(listaAux.size()>0) {
			id = listaAux.get(listaAux.size()-1).getNumCuenta()+1;
		}
		Cuenta nuevaCuenta = new Cuenta(id, tipoCuenta, saldo, cbu, tipoMoneda);
		nuevaCuenta.setDniCliente(dniCliente);
		cuentaDAO.agregarCuentaDAO(nuevaCuenta);
	}
	
	//Lista de las cuentas del cliente indicado por parametro
	public List<Cuenta> listarCuentasDeCliente(Cliente cliente) {
		return cuentaDAO.listarCuentasDAO(cliente);
	}
	
	//Lista de todas las cuentas de la tabla
	public List<Cuenta> listarCuentas() {
		return cuentaDAO.listarCuentasDAO();
	}
	
	//Imprime las cuentas del cliente que ingresa por parametro
	@Override
	public void imprimirCuentas(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("  Cuentas:");
		for (Cuenta cuentas : listarCuentasDeCliente(cliente)) {
			System.out.println(cuentas);
		}
	}
	
	//Imprime todas las cuentas de la tabla
	@Override
	public void imprimirCuentas() {
		// TODO Auto-generated method stub
		for (Cuenta cuentas : listarCuentas()) {
			System.out.println(cuentas);
		}
	}
	
	//Elimina todas las cuentas de la tabla
	@Override
	public void eliminarCuentas() {
		// TODO Auto-generated method stub
		cuentaDAO.eliminarCuentas();
		System.out.println("Todas las cuentas fueron eliminadas");
	}
	
	//Elimina la cuenta con el cbu indicado en el parametro
	@Override
	public void eliminarCuenta(Integer cbu) {
		// TODO Auto-generated method stub
		cuentaDAO.eliminarCuenta(cbu);
		System.out.println("Cuenta eliminada");
	}
	
	//Consulta el saldo de la cuenta indicada por cbu en el parametro
	@Override
	public void consultarSaldo(Integer cbu) {
		// TODO Auto-generated method stub
		for(Cuenta c: this.listarCuentas()) {
			if(c.getCbu()==cbu) {
				System.out.println("Saldo de cuenta "+cbu+": "+c.getSaldo());
			}
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
