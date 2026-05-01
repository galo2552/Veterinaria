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
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
