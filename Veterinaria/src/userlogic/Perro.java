package userlogic;

import java.time.LocalDate;

public class Perro extends Mascota{

	public Perro(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) {
		super(nombre, fechaNacimiento, peso, especie, raza, condicionMedica);
		
	}
	
	@Override
	public String obtenerRecomendaciones() {
		String recomendacion = "Requiere paseos diarios, correa y vacunas anuales.";
		
		if (this.condicionMedica != null && !this.condicionMedica.isEmpty()) {
			recomendacion += " Condición médica: " + this.condicionMedica + ".";
		} 
		
		if (this.raza != null && !this.raza.isEmpty()) {
			recomendacion += " Raza: " + this.raza + ".";
			if (this.raza.equalsIgnoreCase("Labrador")) {
				recomendacion += " Requiere ejercicio regular y una dieta equilibrada.";
			} else if (this.raza.equalsIgnoreCase("Bulldog")) {
				recomendacion += " Evitar el ejercicio excesivo debido a problemas respiratorios.";
			}
			
		}
		
		return recomendacion;
	}
	
	

}
