package utn.cursojava.sistemabancario.main;

import utn.cursojava.sistemabancario.constants.ConexionMySql;
import utn.cursojava.sistemabancario.modelo.Cliente;
import utn.cursojava.sistemabancario.modelo.Cuenta;
import utn.cursojava.sistemabancario.servicios.ClienteService;
import utn.cursojava.sistemabancario.servicios.CuentaService;
import utn.cursojava.sistemabancario.servicios.IClienteService;
import utn.cursojava.sistemabancario.servicios.ICuentaService;

/**
 * Tomando como punto de partida el diagrama de Clases del sistema de Gestión
 * Bancaria construya una aplicación que permita realizar las siguientes
 * operaciones:<br>
 * 
 * 
 * **********MENU PRINCIPAL********** <br>
 * 1) Agregar Cliente<br>
 * 2) Agregar cuenta a Cliente<br>
 * 3) Listar Clientes por sucursal<br>
 * 4) Listar Clientes de una sucursal<br>
 * 5) Extraer dinero<br>
 * 6) Consultar Saldo<br>
 * 7) Realizar Deposito<br>
 * 8) Realizar transferencias<br>
 * 9) Eliminar una sucursal<br>
 * 
 * @author
 *
 */
public class SistemaBancario {

	// private IClienteService clienteService;

	public static void main(String[] args) {
		IClienteService clienteService = new ClienteService();
		ICuentaService cuentaService = new CuentaService();

		System.out.println("Punto de inicio del Sistema Bancario");
		
		//Instancia un cliente y le agrega la lista de cuentas
		/*Cliente cliente1 = new Cliente(1,38589545, "Ignacio Maria", 1115124578, "igna.m@gmail.com",
				"Luis Guillon");
		
		//Agrega una cuenta al cliente --> 1-Caja de ahorro 2-Cuenta Corriente
		Cuenta cuenta1 = cuentaService.crearCuentaCorriente(2, 1500.0, "1000002225484");
		cliente1.getCuentas().add(cuenta1);
		Cuenta cuenta2 = cuentaService.crearCajaDeAhorro(1, 10000.0, "30000055515458", "Pesos");
		cliente1.getCuentas().add(cuenta2);
		
		//Agrega el cliente a la lista
		clienteService.agregarCliente(cliente1);*/

		//Imprime la lista de clientes
		clienteService.listarClientes();
		
		ConexionMySql conn = new ConexionMySql();
		conn.getConexion();
	}
}
