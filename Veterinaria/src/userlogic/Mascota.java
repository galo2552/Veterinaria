package userlogic;

import java.time.LocalDate;

public abstract class Mascota {

	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected double peso;
	protected String especie;
	protected String raza;
	protected String condicionMedica;
	
	public Mascota(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) throws AdopcionException {
		if (nombre == null || nombre.trim().isEmpty()) {
			throw new AdopcionException("El nombre de la mascota no puede estar vacío.");
		}
		if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
			throw new AdopcionException("El nombre de la mascota solo debe contener letras.");
		}
		
		// Validación de Fecha de Nacimiento
		if (fechaNacimiento.isAfter(LocalDate.now())) {
			throw new AdopcionException("La fecha de nacimiento no puede estar en el futuro.");
		}
		
		// Validación de Peso
		if (peso <= 0) {
			throw new AdopcionException("El peso de la mascota debe ser mayor a 0.");
		}
		
		// Validación de Especie
		if (especie == null || especie.trim().isEmpty()) {
			throw new AdopcionException("La especie no puede estar vacía.");
		}
		
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
