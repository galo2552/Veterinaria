package userlogic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class Adopcion {
	
	private LocalDateTime fechaAdopcion;
	private Adoptante adoptante;
	private Mascota mascota;
	private Empleado empleado;
	
	public Adopcion(LocalDateTime fechaAdopcion, Adoptante adoptante, Mascota mascota, Empleado empleado) {
		this.fechaAdopcion = LocalDateTime.now();
		this.adoptante = adoptante;
		this.mascota = mascota;
		this.empleado = empleado;
	}
	
	public Adopcion(){}
	
	public void registrarAdopcion(Adoptante adoptante, Mascota mascota, Empleado empleado) {
		
	}
	
	public void generarTicket() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String fechaFormateada = fechaAdopcion.format(formatter);
		
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
				+ "Especie: " + mascota.getEspecie() + "\n"
				
				+ "Recomendaciones de Cuidado: " + mascota.obtenerRecomendaciones() + "\n\n" 
				+ "Empleado Encargado:\n"
				+ "Nombre: " + empleado.getNombre() + "\n"
				+ "Cargo: " + empleado.getCargo() + "\n\n"
				
				+ "--------------------------------------------------------------------------------\n"
				+ "¡Gracias por adoptar a una mascota!\n"
				+ "--------------------------------------------------------------------------------";

		JOptionPane.showMessageDialog(null, ticket, "Confirmación de Adopción", JOptionPane.INFORMATION_MESSAGE);
	}
		
}
