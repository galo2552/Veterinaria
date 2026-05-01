package userlayer;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import userlogic.Empleado;
import userlogic.Adoptante;
import userlogic.Mascota;
import userlogic.Adopcion;
import userlogic.Perro;


public class Main {

	public static void main(String[] args) {
		
		// 1. REGISTRO DEL EMPLEADO
		Empleado empleadoEncargado = Empleado.getInstancia();
		JOptionPane.showMessageDialog(null, "Bienvenido al Sistema de Adopciones\nPrimero debemos registrar al empleado en turno.");
		empleadoEncargado.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del empleado:"));
		empleadoEncargado.setCargo(JOptionPane.showInputDialog("Ingrese el cargo del empleado:"));
		
		boolean sistemaActivo = true;

		// 2. CICLO DEL MENÚ PRINCIPAL
		while (sistemaActivo) {
			
			String[] opcionesMenu = {"Registrar Nueva Adopción", "Salir del Sistema"};
			int eleccion = JOptionPane.showOptionDialog(null, 
					"¿Qué acción desea realizar?", 
					"Menú Principal - Veterinaria",
					JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, 
					null, 
					opcionesMenu, 
					opcionesMenu[0]);

			// Si elige "Registrar Nueva Adopción" (Opción 0)
			if (eleccion == 0) {
				
				// --- DATOS DEL ADOPTANTE ---
				JOptionPane.showMessageDialog(null, "A continuación, ingrese los datos del adoptante.");
				String nombreAdop = JOptionPane.showInputDialog("Nombre del adoptante:");
				int edadAdop = Integer.parseInt(JOptionPane.showInputDialog("Edad del adoptante:"));
				String dirAdop = JOptionPane.showInputDialog("Dirección:");
				
				Adoptante adoptante = new Adoptante();
				adoptante.setNombre(nombreAdop);
				adoptante.setEdad(edadAdop);
				adoptante.setDireccion(dirAdop);
				
				// --- DATOS DE LA MASCOTA ---
				JOptionPane.showMessageDialog(null, "Ahora, ingrese los datos de la mascota.");
				
				// Menú desplegable para elegir qué objeto instanciar
				String[] tiposMascota = {"Perro", "Gato", "Ave", "Reptil"};
				String tipoElegido = (String) JOptionPane.showInputDialog(null, 
						"Seleccione el tipo de mascota:", 
						"Tipo de Mascota", 
						JOptionPane.QUESTION_MESSAGE, 
						null, 
						tiposMascota, 
						tiposMascota[0]);
				
				String nombreMasc = JOptionPane.showInputDialog("Nombre de la mascota:");
				String fechaStr = JOptionPane.showInputDialog("Fecha de Nacimiento (Formato AAAA-MM-DD):");
				LocalDate fechaNac = LocalDate.parse(fechaStr); // Convierte el String a LocalDate
				double pesoMasc = Double.parseDouble(JOptionPane.showInputDialog("Peso (en kg):"));
				String especieMasc = JOptionPane.showInputDialog("Especie específica (ej: Pug, Siamés, Canario):");
				String razaMasc = JOptionPane.showInputDialog("Raza (Dejar vacío si no aplica):");
				String condicionMasc = JOptionPane.showInputDialog("Condición médica (Dejar vacío si está sano):");
				
				// --- INSTANCIACIÓN CON POLIMORFISMO ---
				Mascota mascota = null;
				
				// Dependiendo de lo que eligió en el menú desplegable, creamos el objeto correcto
				if (tipoElegido.equals("Perro")) {
					mascota = new Perro(nombreMasc, fechaNac, pesoMasc, especieMasc, razaMasc, condicionMasc);
				} 
				// Aquí podríamos agregar más condiciones para otros tipos de mascotas (Gato, Ave, Reptil)
				
				
				// --- REGISTRO Y TICKET ---
				if (mascota != null) {
					Adopcion transaccion = new Adopcion();
					transaccion.registrarAdopcion(adoptante, mascota, empleadoEncargado);
					transaccion.generarTicket();
				}
				
			} 
			// Si elige "Salir" (Opción 1) o cierra la ventana
			else {
				JOptionPane.showMessageDialog(null, "Cerrando el sistema de adopciones. ¡Hasta luego!");
				sistemaActivo = false;
			}
		}
	}
}
