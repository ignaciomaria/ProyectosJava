package utn.cursojava.sistemabancario.modelo;

import utn.cursojava.sistemabancario.constants.TipoCuenta;

public class Cuenta {
	private Integer tipoCuenta;
	private String descripcion;
	private Double saldo;
	private String cbu;
	private String tipoMoneda;

	// Constructor
	public Cuenta() {
	}

	public Cuenta(Integer tipoCuenta, Double saldo, String cbu, String tipoMoneda) {
		this.tipoCuenta = tipoCuenta;
		setTipoCuenta(tipoCuenta);   //Establece la descripcion en base al numero ingresado
		this.saldo = saldo;
		this.cbu = cbu;
		this.tipoMoneda = tipoMoneda;
	}

	public Integer getNumCuenta() {
		return tipoCuenta;
	}

	public void setNumCuenta(Integer numCuenta) {
		this.tipoCuenta = numCuenta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getCbu() {
		return cbu;
	}

	public void setCbu(String cbu) {
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
		this.descripcion = descripcion;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	//toString 
	public String toString() {
		return "  -"+this.descripcion+" Saldo= "+this.saldo+" Moneda= "+this.tipoMoneda;
	}
}
