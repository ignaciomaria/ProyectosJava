package utn.cursojava.sistemabancario.modelo;

public abstract class Persona {

	// Atributos
	protected Integer dni;
	protected String nombreApellido;
	protected Integer telefono;
	protected String email;

	// Constructor
	public Persona(Integer dni, String nombreApellido, Integer telefono, String email) {
		this.dni = dni;
		this.nombreApellido = nombreApellido;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
