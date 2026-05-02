package userlogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Adopcion {
	
	private LocalDateTime fechaAdopcion;
	private Adoptante adoptante;
	private Mascota mascota;
	private Empleado empleado;
	
	public Adopcion(){}
	
	public void registrarAdopcion(Adoptante adoptante, Mascota mascota, Empleado empleado) throws AdopcionException {
	    if (adoptante == null) {
	        throw new AdopcionException("El adoptante no puede ser nulo.");
	    }
	    if (mascota == null) {
	        throw new AdopcionException("La mascota no puede ser nula.");
	    }
	    if (empleado == null) {
	        throw new AdopcionException("El empleado no puede ser nulo.");
	    }
	    
	    this.adoptante = adoptante;
	    this.mascota = mascota;
	    this.empleado = empleado;
	    this.fechaAdopcion = LocalDateTime.now();
	}
	
	public String generarTicket() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String fechaFormateada = fechaAdopcion.format(formatter);
		
		String nombreClase = mascota.getClass().getSimpleName();
		String clasificacionAnimal = (nombreClase.equals("Perro") || nombreClase.equals("Gato")) ? "Mamífero" : nombreClase;
		String razaMostrar = (mascota.getRaza() == null || mascota.getRaza().trim().isEmpty()) ? "No aplica / Mestiza" : mascota.getRaza();
		
		String ticket = "--------------------------------------------------------------------------------\n"
				+ "                                 TICKET DE ADOPCIÓN\n"
				+ "--------------------------------------------------------------------------------\n\n"

				+ "Fecha y Hora: " + fechaFormateada + "\n\n"

				+ "Datos del Adoptante:\n"
				+ "Nombre: " + adoptante.getNombre() + "\n"
				+ "Edad: " + adoptante.getEdad() + "\n"
				+ "Dirección: " + adoptante.getDireccion() + "\n\n"

				+ "Datos de la Mascota:\n"
				+ "Nombre: " + mascota.getNombre() + "\n"
				+ "Fecha de Nacimiento: " + mascota.getFechaNacimiento() + "\n"
				+ "Peso: " + mascota.getPeso() + " kg\n"
				+ "Clasificación: " + clasificacionAnimal + "\n"
				+ "Especie: " + mascota.getEspecie() + "\n"
				+ "Raza: " + razaMostrar + "\n\n"
				+ "Recomendaciones de Cuidado:\n" + mascota.obtenerRecomendaciones() + "\n\n" 

				+ "Empleado Encargado:\n"
				+ "Nombre: " + empleado.getNombre() + "\n"
				+ "Cargo: " + empleado.getCargo() + "\n\n"
				+ "--------------------------------------------------------------------------------\n"
				+ "¡Gracias por adoptar a una mascota!\n"
				+ "--------------------------------------------------------------------------------";

		return ticket;
	}

	public String getResumenAdopcion() {
		String razaMostrar = (mascota.getRaza() == null || mascota.getRaza().trim().isEmpty()) ? "Mestiza" : mascota.getRaza();
		return "- " + mascota.getNombre() + " (Especie: " + mascota.getEspecie() + " | Raza: " + razaMostrar + ")";
	}
		
}
