package userlogic;

public class Adoptante {

	private int edad;
	private String nombre;
	private String direccion;
	
	public Adoptante(String nombre, int edad, String direccion) throws AdopcionException {
	    setNombre(nombre);
	    setEdad(edad);
	    setDireccion(direccion);
	}
	
	public Adoptante() {}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) throws AdopcionException {
		if (edad < 18) {
			throw new AdopcionException("El adoptante debe ser mayor de edad(+18) para adoptar una mascota.");
		}
		if (edad > 120) {
			throw new AdopcionException("Por favor, ingrese una edad realista.");
		}
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) throws AdopcionException {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new AdopcionException("El nombre del adoptante no puede estar vacío.");
		}
		if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
			throw new AdopcionException("El nombre solo debe contener letras, no números ni símbolos.");
		}
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) throws AdopcionException {
		if (direccion == null || direccion.trim().isEmpty()) {
			throw new AdopcionException("La dirección no puede estar vacía.");
		}
		this.direccion = direccion;
	}
	
}
