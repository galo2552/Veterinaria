package userlayer;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import userlogic.Adopcion;
import userlogic.AdopcionException;
import userlogic.Adoptante;
import userlogic.Ave;
import userlogic.Empleado;
import userlogic.Gato;
import userlogic.Mascota;
import userlogic.Perro;
import userlogic.Reptil;

public class Main {

	public static void main(String[] args) {
		
		// 1. REGISTRO DEL EMPLEADO
		Empleado empleadoEncargado = Empleado.getInstancia();
		
		int respuestaBienvenida = JOptionPane.showConfirmDialog(null, 
				"Bienvenido al Sistema de Adopciones\nPara comenzar, debemos registrar al empleado en turno.\n¿Desea continuar?", 
				"Inicio de Sistema", 
				JOptionPane.OK_CANCEL_OPTION, 
				JOptionPane.INFORMATION_MESSAGE);
		
		if (respuestaBienvenida != JOptionPane.OK_OPTION) {
			System.exit(0);
		}
		
		String nombreEmp = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
		if (nombreEmp == null || nombreEmp.trim().isEmpty()) {
			System.exit(0); 
		}
		
		String[] cargosDisponibles = {"Administrador de Adopciones", "Recepcionista", "Veterinario/a", "Asistente"};
		
		String cargoEmp = (String) JOptionPane.showInputDialog(null, 
				"Seleccione el cargo del empleado:", 
				"Registro de Empleado", 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				cargosDisponibles, 
				cargosDisponibles[0]);
		
		if (cargoEmp == null) {
			System.exit(0);
		}

		try {
			empleadoEncargado.setNombre(nombreEmp);
			empleadoEncargado.setCargo(cargoEmp);
		} catch (AdopcionException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error al registrar empleado", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		boolean sistemaActivo = true;
		
		// HISTORIAL DE ADOPCIONES
		List<Adopcion> historialAdopciones = new ArrayList<>();

		// 2. CICLO DEL MENÚ PRINCIPAL
		while (sistemaActivo) {
			
			String[] opcionesMenu = {"Registrar Nueva Adopción", "Ver Mascotas Adoptadas", "Salir del Sistema"};
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
				
				try {
					// --- DATOS DEL ADOPTANTE ---
					JOptionPane.showMessageDialog(null, "A continuación, ingrese los datos del adoptante.");
					
					String nombreAdop = JOptionPane.showInputDialog("Nombre del adoptante:");
					if (nombreAdop == null) throw new Exception("Operacion cancelada");
					
					String edadStr = JOptionPane.showInputDialog("Edad del adoptante:");
					if (edadStr == null) throw new Exception("Operacion cancelada");
					int edadAdop = Integer.parseInt(edadStr);
					
					String dirAdop = JOptionPane.showInputDialog("Dirección:");
					if (dirAdop == null) throw new Exception("Operacion cancelada");
					
					Adoptante adoptante = new Adoptante(nombreAdop, edadAdop, dirAdop);
					
					// --- DATOS DE LA MASCOTA ---
					JOptionPane.showMessageDialog(null, "Ahora, ingrese los datos de la mascota.");
					
					String[] tiposMascota = {"Perro", "Gato", "Ave", "Reptil"};
					String tipoElegido = (String) JOptionPane.showInputDialog(null, 
							"Seleccione la clasificación de la mascota:", 
							"Clasificación", 
							JOptionPane.QUESTION_MESSAGE, 
							null, 
							tiposMascota, 
							tiposMascota[0]);
					if (tipoElegido == null) throw new Exception("Operacion cancelada");
					
					String nombreMasc = JOptionPane.showInputDialog("Nombre de la mascota:");
					if (nombreMasc == null) throw new Exception("Operacion cancelada");
					
					String especieMasc;
					String razaMasc = ""; 
					
					if (tipoElegido.equals("Perro") || tipoElegido.equals("Gato")) {
						especieMasc = tipoElegido; 
						razaMasc = JOptionPane.showInputDialog("Raza específica (ej: Labrador, Bulldog, Esfinge, Persa).\nDejar vacío si es mestizo:");
						if (razaMasc == null) throw new Exception("Operacion cancelada");
					} else {
						especieMasc = JOptionPane.showInputDialog("Ingrese la Especie exacta (ej: Loro, Canario, Iguana, Tortuga):");
						if (especieMasc == null) throw new Exception("Operacion cancelada");
					}
					
					String fechaStr = JOptionPane.showInputDialog("Fecha de Nacimiento (Formato AAAA-MM-DD):");
					if (fechaStr == null) throw new Exception("Operacion cancelada");
					LocalDate fechaNac = LocalDate.parse(fechaStr); 
					
					String pesoStr = JOptionPane.showInputDialog("Peso (en kg):");
					if (pesoStr == null) throw new Exception("Operacion cancelada");
					double pesoMasc = Double.parseDouble(pesoStr); 
					
					String condicionMasc = JOptionPane.showInputDialog("Condición médica (Dejar vacío si está sano):");
					if (condicionMasc == null) throw new Exception("Operacion cancelada");
					
					// --- INSTANCIACIÓN CON POLIMORFISMO ---
					Mascota mascota = null;
					
					if (tipoElegido.equals("Perro")) {
						mascota = new Perro(nombreMasc, fechaNac, pesoMasc, especieMasc, razaMasc, condicionMasc);
					} else if (tipoElegido.equals("Gato")) {
						mascota = new Gato(nombreMasc, fechaNac, pesoMasc, especieMasc, razaMasc, condicionMasc);
					} else if (tipoElegido.equals("Ave")) {
						mascota = new Ave(nombreMasc, fechaNac, pesoMasc, especieMasc, razaMasc, condicionMasc);
					} else if (tipoElegido.equals("Reptil")) {
						mascota = new Reptil(nombreMasc, fechaNac, pesoMasc, especieMasc, razaMasc, condicionMasc);
					}
					
					// --- REGISTRO Y TICKET ---
					if (mascota != null) {
						Adopcion transaccion = new Adopcion();
						transaccion.registrarAdopcion(adoptante, mascota, empleadoEncargado);
						
						historialAdopciones.add(transaccion);
						
						String textoTicket = transaccion.generarTicket();
						JOptionPane.showMessageDialog(null, textoTicket, "Confirmación de Adopción", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch (AdopcionException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
					
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Debe ingresar un valor numérico para la edad y el peso.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
					
				} catch (DateTimeParseException e) {
					JOptionPane.showMessageDialog(null, "Error: La fecha debe respetar el formato AAAA-MM-DD (ej: 2023-10-25).", "Error de Fecha", JOptionPane.ERROR_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Se canceló la carga de datos o ocurrió un error inesperado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				}
				
			} 
			// Si elige "Ver Mascotas Adoptadas" (Opción 1)
			else if (eleccion == 1) {
				if (historialAdopciones.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Aún no se han registrado adopciones en este turno.", "Historial Vacío", JOptionPane.INFORMATION_MESSAGE);
				} else {
					StringBuilder lista = new StringBuilder("Mascotas Adoptadas Históricas:\n\n");
					for (Adopcion adop : historialAdopciones) {
						lista.append(adop.getResumenAdopcion()).append("\n");
					}
					JOptionPane.showMessageDialog(null, lista.toString(), "Historial de Adopciones", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			// Si elige "Salir" (Opción 2) o cierra la ventana
			else {
				JOptionPane.showMessageDialog(null, "Cerrando el sistema de adopciones. ¡Hasta luego!");
				sistemaActivo = false;
			}
		}
	}
}