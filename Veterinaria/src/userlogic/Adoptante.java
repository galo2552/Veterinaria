package userlogic;

public class Adoptante {

	private int edad;
	private String nombre;
	private String direccion;
	
	public Adoptante(String nombre, int edad, String direccion) {
		this.nombre = nombre;
		this.edad = edad;
		this.direccion = direccion;
	}
	
	public Adoptante() {}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
