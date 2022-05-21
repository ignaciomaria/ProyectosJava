package utn.cursojava.sistemabancario.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Persona {
	// ATRIBUTOS
	private Integer nroCliente;
	private String domicilio;
	private Date altaCliente;
	// private Sucursal sucursal;
	private Integer sucursalId;

	private List<Cuenta> cuentas;
	
	//Constructor
	public Cliente(Integer nroCliente, Integer dni, String nombreApellido, Integer telefono, String email, String domicilio) {
		super(dni, nombreApellido, telefono, email);
		this.nroCliente = nroCliente;
		this.domicilio = domicilio;
		//this.altaCliente = altaCliente;
		this.cuentas = new ArrayList<Cuenta>();
	}
	
	//Getter Setter
	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Date getAltaCliente() {
		return altaCliente;
	}

	public void setAltaCliente(Date altaCliente) {
		this.altaCliente = altaCliente;
	}

	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}
	
	public Integer getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(Integer nroCliente) {
		this.nroCliente = nroCliente;
	}

	@Override
	public String toString() {
		return this.nombreApellido+" | "+this.domicilio+"\n"+this.imprimirCuentas();
	}
	
	public String imprimirCuentas() {
		String auxiliar=" ";
		for(Cuenta cuenta: this.cuentas) {
			auxiliar += cuenta+"\n";
		}
		return auxiliar;
	}
}
