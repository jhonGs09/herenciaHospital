import javax.swing.JOptionPane;

import clases.CitaMedica;
import clases.ModeloDatos;
import clases.Paciente;
import clases.empleados.EmpleadoEventual;
import clases.empleados.EmpleadoPlanilla;
import clases.empleados.Medico;

public class Procesos {

	ModeloDatos miModeloDeDatos;

	public Procesos() {

		miModeloDeDatos = new ModeloDatos();
		presentraMenuOpciones();
	}

	private void presentraMenuOpciones() {
		String menu = "---MENU HOSPITAL---\n\n";
		menu += "1. Registrar paciente \n";
		menu += "2. Registrar empleado \n";
		menu += "3. Registrar cita medica \n";
		menu += "4. Imprimir informacion \n";
		menu += "5. Consultar por numero ID";
		menu += "6. Salir \n";
		menu += "INGRESE UNA OPCION \n";

		int opcion = 0;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcion) {
			case 1:registrarPaciente();break;
			case 2:registrarEmpleado();break;
			case 3:registrarCitaMedica();break;
			case 4:imprimirInformacion();break;
			case 5:consultarPorID();break;
			case 6:System.out.println("El sistema ha terminado");break;

			default:
				System.out.println("No existe el codigo, verifique nuevamente");
				break;
			}
		} while (opcion != 5);

	}





	

	private void consultarPorID() {
		imprimirInformacion();
	}

	private void registrarPaciente() {
		Paciente miPaciente = new Paciente();
		miPaciente.registrarDatos();

		miModeloDeDatos.registrarPresona(miPaciente);

	}

	private void registrarEmpleado() {
		String menuTipoEmpleado = "---Registro de empleado--- \n";
		menuTipoEmpleado += "1. Empleado Evential \n";
		menuTipoEmpleado += "2. Empleado por planilla \n";
		menuTipoEmpleado += "Seleccione el tipo de empleado a registrar";

		int tipoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(menuTipoEmpleado));

		switch (tipoEmpleado) {
		case 1:
			EmpleadoEventual miEmpleadoEventual = new EmpleadoEventual();
			miEmpleadoEventual.registrarDatos();
			miModeloDeDatos.registrarPresona(miEmpleadoEventual);

			break;

		case 2:
			String resp = JOptionPane
					.showInputDialog("Ingrese si , si es un medico, de lo contrario es otro tipo de empleado");
			if (resp.equalsIgnoreCase("si")) {
				Medico miMedico = new Medico();
				miMedico.registrarDatos();
				miModeloDeDatos.registrarPresona(miMedico);
			} else {
				EmpleadoPlanilla miEmpleadoPLanilla = new EmpleadoPlanilla();
				miEmpleadoPLanilla.registrarDatos();
				miModeloDeDatos.registrarPresona(miEmpleadoPLanilla);
			}
			
			break;

		default:System.out.println("El tipo de empleado no es valido, intentelo nuevamente ");
			break;
		}

	}

	private void registrarCitaMedica() {
		String documentoPaciente= JOptionPane.showInputDialog("Ingrese le documneto del paciente");
		
		Paciente pacienteEncontrado=miModeloDeDatos.consultarPacientePorDocumneto(documentoPaciente);
		
		if (pacienteEncontrado!=null) {
			String nombreMedico = JOptionPane.showInputDialog("Ingrese el nombre del medico");
			Medico MedicoEncontrado = miModeloDeDatos.consultarMedicoPorNombre(nombreMedico);
			
			if (MedicoEncontrado!=null) {
				String servicio = JOptionPane.showInputDialog("Ingrese el servicio o motivo de la consulata");
				String fechaConsulta = JOptionPane.showInputDialog("Ingrese la fecha de la consulta");
				String hoarConsulta = JOptionPane.showInputDialog("Ingrese la hora de la consulta");
				
				String lugar = "La cita sera en el consultorio "+ MedicoEncontrado.getNumeroDeConsultorio();
				CitaMedica miCita = new CitaMedica(pacienteEncontrado, MedicoEncontrado, servicio, fechaConsulta, fechaConsulta, lugar);
				miModeloDeDatos.registrarCitaMedica(miCita);
			}else {
				System.out.println("El medico no se encuentra registrado en el sistema ");
			}
		}else {
			System.out.println("El paciente no se encuentra registrado en el sistema ");
		}
	}

	private void imprimirInformacion() {
		
		String menuImprimir = "---MENU IMPRESIONES---";
		menuImprimir+= "1. Listar Pacientes \n";
		menuImprimir+= "2. Listar Empleados Eventuales \n";
		menuImprimir+= "3. Listar Empleados por planilla \n";
		menuImprimir+= "4. Listar medicos \n";
		menuImprimir+= "5. Listar citas programadas \n";
		menuImprimir += "6.  Consultar pacientes \n";
		menuImprimir += "7. Consultar empleados eventuales.  \n";
		menuImprimir += "8. Consultar empleados planilla. \n";
		menuImprimir += "9. Consultar medicos. \n";
		menuImprimir+= "Ingrese una opcion \n";
		
		System.out.println("------------------------------------------");
		
		int opcion = Integer.parseInt(JOptionPane.showInputDialog(menuImprimir));
		String numID=JOptionPane.showInputDialog("Ingrese el numero de identificacion");
		
		switch (opcion) {
		
		case 1: miModeloDeDatos.imprimirPacinetes(); break;
		case 2: miModeloDeDatos.imprimirEmpleadosEventuales(); break;
		case 3: miModeloDeDatos.imprimirEmpleadosPorPlanilla(); break;
		case 4: miModeloDeDatos.imprimirMedicos(); break;
		case 5: miModeloDeDatos.imprimirCitasMedicasProgramadas();
		case 6:miModeloDeDatos.consultarPacientePorDocumneto(numID);break;
		case 7:miModeloDeDatos.consultarEmpEvent(numID);break;
		case 8:miModeloDeDatos.consultarMedicos(numID);break;
		case 9:miModeloDeDatos.consultarEmpPlani(numID);break;
		

		default:System.out.println("No existe esta opcion ");
			break;
		}
		

	}
	
	
	

}
