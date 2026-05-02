package userlogic;

public class Empleado {

	private static Empleado instancia;
	private String nombre;
	private String cargo;
	
	private Empleado() {
		
	}
	
	public static Empleado getInstancia() {
		if (instancia == null) {
			instancia = new Empleado();
		}
		return instancia;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) throws AdopcionException {
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new AdopcionException("El nombre del empleado no puede estar vacío.");
	    }
	    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
	        throw new AdopcionException("El nombre del empleado solo debe contener letras.");
	    }
	    this.nombre = nombre;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) throws AdopcionException {
	    if (cargo == null || cargo.trim().isEmpty()) {
	        throw new AdopcionException("El cargo del empleado no puede estar vacío.");
	    }
	    this.cargo = cargo;
	}
}
