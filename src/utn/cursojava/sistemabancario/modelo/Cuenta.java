package utn.cursojava.sistemabancario.modelo;

import utn.cursojava.sistemabancario.constants.TipoCuenta;

public class Cuenta {
	//Atributos
	private Integer nroCuenta;
	private Integer tipoCuenta;
	private String descripcion;
	private Double saldo;
	private Integer cbu;
	private String tipoMoneda;
	private Integer dniCliente;

	// Constructor 
	public Cuenta() {
	}

	public Cuenta(Integer nroCuenta, Integer tipoCuenta, Double saldo, Integer cbu, String tipoMoneda) {
		this.nroCuenta = nroCuenta;
		this.tipoCuenta = tipoCuenta;
		setTipoCuenta(tipoCuenta);   //Establece la descripcion en base al numero ingresado
		this.saldo = saldo;
		this.cbu = cbu;
		this.tipoMoneda = tipoMoneda;
	}

	//Getter Setter
	public Integer getNumCuenta() {
		return tipoCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.tipoCuenta = numCuenta;
	}

	public Integer getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getCbu() {
		return cbu;
	}

	public void setCbu(Integer cbu) {
		this.cbu = cbu;
	}

	public Integer getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(Integer tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
		if(this.tipoCuenta==1) {
			this.descripcion = TipoCuenta.CAJA_AHORRO.getDescripcion();
		}else if(this.tipoCuenta==2) {
			this.descripcion = TipoCuenta.CUENTA_CORRIENTE.getDescripcion();
		}
	}
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if(descripcion.compareTo(TipoCuenta.CAJA_AHORRO.getDescripcion())==0) {
			setTipoCuenta(1);
		}else if(descripcion.compareTo(TipoCuenta.CUENTA_CORRIENTE.getDescripcion())==0) {
			setTipoCuenta(2);
		}
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	public Integer getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(Integer dniCliente) {
		this.dniCliente = dniCliente;
	}

	//toString 
	public String toString() {
		return "  -"+this.descripcion+" Saldo= "+this.saldo+" Moneda= "+this.tipoMoneda;
	}
}
