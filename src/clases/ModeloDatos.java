package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import clases.empleados.EmpleadoEventual;
import clases.empleados.EmpleadoPlanilla;
import clases.empleados.Medico;

public class ModeloDatos {

	HashMap<String, Paciente> pacientesMap;
	HashMap<String, EmpleadoPlanilla> empleadosPlanillaMap;
	HashMap<String, EmpleadoEventual> empleadosEventual;
	HashMap<String, Medico> medicosMap;
	ArrayList<CitaMedica> citasList;

	public ModeloDatos() {

		pacientesMap = new HashMap<String, Paciente>();
		empleadosPlanillaMap = new HashMap<String, EmpleadoPlanilla>();
		medicosMap = new HashMap<String, Medico>();
		empleadosEventual = new HashMap<String, EmpleadoEventual>();
		citasList = new ArrayList<CitaMedica>();

	}

	public void registrarPresona(Paciente miPaciente) {
		pacientesMap.put(miPaciente.getNumeroDeDNI(), miPaciente);
		System.out.println("Se ha registrado el paciente " + miPaciente.getNombre() + "Satisfatoriamente");
	}

	public void registrarPresona(EmpleadoPlanilla miEmpPlanilla) {
		empleadosPlanillaMap.put(miEmpPlanilla.getNumeroDeDNI(), miEmpPlanilla);
		System.out.println(
				"Se ha registrado el empleado por planilla " + miEmpPlanilla.getNombre() + "Satisfatoriamente");
	}

	public void registrarPresona(EmpleadoEventual miEmpEventual) {
		empleadosEventual.put(miEmpEventual.getNumeroDeDNI(), miEmpEventual);
		System.out.println("Se ha registrado el empleado eventual" + miEmpEventual.getNombre() + "Satisfatoriamente");
	}

	public void registrarPresona(Medico miMedico) {
		medicosMap.put(miMedico.getNumeroDeDNI(), miMedico);
		System.out.println("Se ha registrado el medico " + miMedico.getNombre() + "Satisfatoriamente");
	}

	public void imprimirPacinetes() {
		String msj = "--- PACIENTES REGISTRADOS ---\n";
		Iterator<String> iterator = pacientesMap.keySet().iterator();

		while (iterator.hasNext()) {
			String clave = iterator.next();
			pacientesMap.get(clave).imprimirDatosPersona(msj);

		}

	}

	public void imprimirEmpleadosEventuales() {
		String msj = "--- EMPLEADOS EVENTUALES REGISTRADOS ---\n";

		for (String clave : empleadosEventual.keySet()) {
			empleadosEventual.get(clave).imprimirDatosPersona(msj);
		}

	}

	public void imprimirEmpleadosPorPlanilla() {
		String msj = "--- EMPLEADOS POR PLANILLA REGISTRADOS --- \n";

		for (EmpleadoPlanilla emplaEmpleadoPlanilla : empleadosPlanillaMap.values()) {
			emplaEmpleadoPlanilla.imprimirDatosPersona(msj);
		}

	}

	public void imprimirMedicos() {
		String msj = "--- MEDICOS REGISTRADOS ---";

		for (Map.Entry<String, Medico> elemento : medicosMap.entrySet()) {
			elemento.getValue().imprimirDatosPersona(msj);
		}

	}



	public Medico consultarMedicoPorNombre(String nombreMedico) {
		for (Medico medico : medicosMap.values()) {
			if (medico.getNombre().equalsIgnoreCase(nombreMedico)) {
				return medico;
			}

		}
		return null;
	}

	
	public void registrarCitaMedica(CitaMedica miCita) {
		citasList.add(miCita);
		System.out.println("Se he registrado la cita exitosamente \n");
		System.out.println(miCita.informacionCitaMedica());
		
		
	}

	public void imprimirCitasMedicasProgramadas() {
		String msj = "--- CITAS MEDICAS PROGRAMADAS --- \n";
		CitaMedica miCita=null;
		
		System.out.println(msj + "\n");
		
		if (citasList.size() >0) {
			for (int i = 0; i < citasList.size(); i++) {
				miCita=citasList.get(i);
				System.out.println(miCita.informacionCitaMedica());
			}
		}else {
			System.out.println("No existen citas porgramadas");
		}
		
	}
	
	public Paciente consultarPacientePorDocumneto(String documnetoPaciente) {
		Paciente miPaciente = null;

		if (pacientesMap.containsKey(documnetoPaciente)) {
			miPaciente = pacientesMap.get(documnetoPaciente);
		}
		
		String mensaje="*********************************************** \n El paciente "+ miPaciente.getNombre()+
		" \n Esta registrado con numero de identificacion:" + miPaciente.getNumeroDeDNI()+
		"\n Numero de historia Clínica "+miPaciente.getNumeroHistoriaClinica()+
		"\n Alegico a "+ miPaciente.getListaDeMedicamentosAlergico()+
		"\n ***********************************************";
		System.out.println(mensaje);
		return  miPaciente;
	}
	

	public Medico consultarMedicos(String documentoMedico) {
		Medico miMedico = null;
		if (medicosMap.containsValue(documentoMedico)) {
			miMedico=medicosMap.get(documentoMedico);
		}
		
		String mensaje = "*********************************************** \n El paciente "+ miMedico.getNombre()+
		" \n Esta registrado con numero de identificacion:" + miMedico.getNumeroDeDNI()+
		"\n Especializado en "+miMedico.getEspecialidad()+
		"En el consultorio " + miMedico.getNumeroDeConsultorio()
		+"\n ***********************************************";
		return miMedico;
	
		
	}

	public EmpleadoPlanilla consultarEmpPlani(String documentoEmpPlani) {
		EmpleadoPlanilla miEmpPlani = null;
		if (empleadosPlanillaMap.containsValue(documentoEmpPlani)) {
			miEmpPlani=empleadosPlanillaMap.get(documentoEmpPlani);
		}
		String mensaje = "*********************************************** \n El paciente "+ miEmpPlani.getNombre()+
				" \n Esta registrado con numero de identificacion:" + miEmpPlani.getNumeroDeDNI()+
				"\n con el cargo de: "+miEmpPlani.getCargo()+
				"Con un salario de: " + miEmpPlani.getSalarioMensual()+
				"\n ***********************************************";
		return miEmpPlani;
			
	}

	public EmpleadoEventual consultarEmpEvent(String documentoEmpEvent) {
		EmpleadoEventual miEmpEvent = null;
		if (empleadosEventual.containsValue(documentoEmpEvent)) {
			miEmpEvent=empleadosEventual.get(documentoEmpEvent);
		}
		String mensaje = "*********************************************** \n El paciente "+ miEmpEvent.getNombre()+
				" \n Esta registrado con numero de identificacion:" + miEmpEvent.getNumeroDeDNI()+
				"\n con los honorarios por hora: "+miEmpEvent.getHonorariosPorHora()+
				"Con un contrato hasta:  " + miEmpEvent.getFechaTerminoContrato()+
				"\n ***********************************************";
		return miEmpEvent;
	
		
	}
	
	
}
