package utn.cursojava.sistemabancario.main;

import java.util.Scanner;

import utn.cursojava.sistemabancario.dao.ConexionMySql;
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
		ConexionMySql con = new ConexionMySql();
		
		System.out.println("-------------------------Sistema Bancario-------------------------");
		con.verificarConexion();
		
		//Agrega el cliente a la lista
		
		try {
			clienteService.agregarCliente(38589545, "Ignacio Maria", 1115124578, "igna.m@gmail.com", "Luis Guillon");
		}catch(RuntimeException re) {
			System.out.println("\nRegistros repetidos en la base de datos.");
		}
		try {
			clienteService.agregarCliente(40578542, "Nicolas Santillan", 1545987600, "nick.s@gmail.com", "Berazategui");
		}catch(RuntimeException re) {
			System.out.println("\nRegistros repetidos en la base de datos.");
		}
		
		//Agrega una cuenta al cliente --> 1-Caja de ahorro 2-Cuenta Corriente
		try {
		    cuentaService.crearCuenta(38589545, 2, 1500.0, 1002225484, "Peso");
		}catch(RuntimeException re) {
			System.out.println("\nCuenta repetida en la base de datos.");
		}
		try {
		    cuentaService.crearCuenta(40578542, 2, 2222.0, 1004825227, "Peso");
		}catch(RuntimeException re) {
			System.out.println("\nCuenta repetida en la base de datos.");
		}
		try {
		    cuentaService.crearCuenta(40578542, 1, 10000.0, 300055158, "Dolar");
		}catch(RuntimeException re) {
			System.out.println("\nCuenta repetida en la base de datos.");
		}
		
		
		Scanner dato = new Scanner(System.in);
		
		//Menu
		int opcion=0; 
		do {
			System.out.println("\nElige una opcion");
			System.out.println("1-Listar clientes");
			System.out.println("2-Eliminar cliente");
			System.out.println("3-Eliminar todos los clientes");
			System.out.println("4-Eliminar todas las cuentas");
			//System.out.println("5-Consultar saldo");
			System.out.println("0-Salir");
			opcion = dato.nextInt();
			switch(opcion) {
			case 1: //Imprime la lista de clientes
					clienteService.imprimirClientes();break;
					//cuentaService.imprimirCuentas();
			case 2: //Eliminar cliente buscado
					clienteService.eliminarCliente(40578542);break;
			case 3: //Eliminar clientes
					try {
						clienteService.eliminarClientes();break;
					}catch(RuntimeException re) {
						System.out.println("Antes de eliminar los clientes, elimine las cuentas");
					}
			case 4: //Eliminar cuentas
					cuentaService.eliminarCuentas();break;
			//case 5: cuentaService.consultarSaldo(1004825227);break;
			case 0: System.out.println("\n-------------------------Fin del sistema-------------------------");break;//Salir
			default: System.out.println("\nOpcion incorrecta.");
			}
		}while(opcion!=0);
		dato.close();
	}
//---------------------------------------------------------------------------------------------------------------------------------------	
}
