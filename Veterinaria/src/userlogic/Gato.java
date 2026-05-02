package userlogic;

import java.time.LocalDate;

public class Gato extends Mascota {

	public Gato(String nombre, LocalDate fechaNacimiento, double peso, String especie, String raza, String condicionMedica) throws AdopcionException {
		super(nombre, fechaNacimiento, peso, especie, raza, condicionMedica);
	}

	@Override
	public String obtenerRecomendaciones() {
		String recomendacion = "Requiere bandeja sanitaria limpia, rascador y dieta rica en taurina.";
		
		if (this.condicionMedica != null && !this.condicionMedica.isEmpty()) {
			recomendacion += " Condición médica: " + this.condicionMedica + ".";
		} 
		
			if ("Persa".equalsIgnoreCase(this.raza)) {
				recomendacion += " Cepillado diario obligatorio para evitar nudos en el pelaje.";
			} else if ("Esfinge".equalsIgnoreCase(this.raza)) {
				recomendacion += " Cuidado estricto con la temperatura ambiente y limpieza de piel.";
			}
			
		return recomendacion;
	}
}
