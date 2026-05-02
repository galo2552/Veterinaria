package userlogic;

import java.time.LocalDate;

public class Reptil extends Mascota {

	public Reptil(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) throws AdopcionException {
		super(nombre, fechaNacimiento, peso, especie, raza, condicionMedica);
	}

	@Override
	public String obtenerRecomendaciones() {
		String recomendacion = "Requiere terrario con control estricto de temperatura y humedad.";
		
		if (this.condicionMedica != null && !this.condicionMedica.isEmpty()) {
			recomendacion += " Condición médica: " + this.condicionMedica + ".";
		} 
		
			if ("Iguana".equalsIgnoreCase(this.especie)) {
				recomendacion += " Requiere lámpara de luz UVB para procesar el calcio correctamente.";
			} else if ("Serpiente".equalsIgnoreCase(this.especie)) {
				recomendacion += " Asegurar que el terrario esté completamente sellado para evitar escapes.";
			}
		
		return recomendacion;
	}
}
