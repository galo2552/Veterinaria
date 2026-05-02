package userlogic;

import java.time.LocalDate;

public class Perro extends Mascota{

	public Perro(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) throws AdopcionException {
		super(nombre, fechaNacimiento, peso, especie, raza, condicionMedica);
		
	}
	
	@Override
	public String obtenerRecomendaciones() {
		String recomendacion = "Requiere paseos diarios, correa y vacunas anuales.";
		
		if (this.condicionMedica != null && !this.condicionMedica.isEmpty()) {
			recomendacion += " Condición médica: " + this.condicionMedica + ".";
		} 
		
			if ("Labrador".equalsIgnoreCase(this.raza)) {
				recomendacion += " Requiere ejercicio regular y una dieta equilibrada.";
			} else if ("Bulldog".equalsIgnoreCase(this.raza)) {
				recomendacion += " Evitar el ejercicio excesivo debido a problemas respiratorios.";
			}
			
		
		return recomendacion;
	}
	
	

}
