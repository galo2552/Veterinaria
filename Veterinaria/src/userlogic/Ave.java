package userlogic;

import java.time.LocalDate;

public class Ave extends Mascota {

	public Ave(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) throws AdopcionException {
		super(nombre, fechaNacimiento, peso, especie, raza, condicionMedica);
	}

	@Override
	public String obtenerRecomendaciones() {
		String recomendacion = "Requiere jaula amplia, limpieza diaria de la base y agua fresca constante.";
		
		if (this.condicionMedica != null && !this.condicionMedica.isEmpty()) {
			recomendacion += " Condición médica: " + this.condicionMedica + ".";
		} 
		
			if ("Loro".equalsIgnoreCase(this.especie)) {
				recomendacion += " Alta necesidad de estimulación mental y juguetes para picar.";
			} else if ("Canario".equalsIgnoreCase(this.especie)) {
				recomendacion += " Ubicar en un lugar libre de corrientes de aire frío.";
			}
		
		return recomendacion;
	}
}
