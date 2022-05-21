package utn.cursojava.sistemabancario.modelo;

public class CajaDeAhorro extends Cuenta {
	// Atributos
	private String tipoMoneda;

	// COSNTRUCTOR
	public CajaDeAhorro() {
	}

	/**
	 * 
	 * @param numCuenta
	 * @param saldo
	 * @param tipoMoneda: pesos 'P', dolares 'D'
	 */
	public CajaDeAhorro(Integer numCuenta, Double saldo, String cbu, String tipoMoneda) {
		super(numCuenta, saldo, cbu);
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	
	//toString
	public String toString() {
		return " -"+this.tipoDeCuenta+": tipoMoneda= " + tipoMoneda + ", saldo= $" + this.saldo + ", cbu= "+ this.cbu;
	}
}
