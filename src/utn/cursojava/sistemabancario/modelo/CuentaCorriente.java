package utn.cursojava.sistemabancario.modelo;

public class CuentaCorriente extends Cuenta {
	
	public CuentaCorriente() {}
	
	/**
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @param cbu
	 */
	public CuentaCorriente(Integer numCuenta, Double saldo, String cbu) {
		super(numCuenta, saldo, cbu);
	}

	public String toString() {
		return "-"+this.tipoDeCuenta+": Saldo= $" + this.saldo + ", cbu= " + this.cbu;
	}
}
