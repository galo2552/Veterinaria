package userlogic;

import java.time.LocalDate;

public abstract class Mascota {

	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected double peso;
	protected String especie;
	protected String raza;
	protected String condicionMedica;
	
	public Mascota(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) {
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
		this.especie = especie;
		this.raza = raza;
		this.condicionMedica = condicionMedica;
	}
	
	public abstract String obtenerRecomendaciones();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getRaza() {
		return raza;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public String getCondicionMedica() {
		return condicionMedica;
	}
	
	public void setCondicionMedica(String condicionMedica) {
		this.condicionMedica = condicionMedica;
	}
	
}
