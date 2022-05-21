package utn.cursojava.sistemabancario.modelo;

import utn.cursojava.sistemabancario.constants.TipoCuenta;

public abstract class Cuenta {
	protected Integer tipoCuenta;
	protected String tipoDeCuenta;
	protected Double saldo;
	protected String cbu;

	// Constructor
	public Cuenta() {
	}

	public Cuenta(Integer tipoCuenta, Double saldo, String cbu) {
		this.tipoCuenta = tipoCuenta;
		if(this.tipoCuenta==1) {
			this.tipoDeCuenta = TipoCuenta.CAJA_AHORRO.getDescripcion();
		}else if(this.tipoCuenta==2) {
			this.tipoDeCuenta = TipoCuenta.CUENTA_CORRIENTE.getDescripcion();
		}
		this.saldo = saldo;
		this.cbu = cbu;
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
}
