package clases.empleados;

import javax.swing.JOptionPane;

public class Medico extends EmpleadoPlanilla {
	
	private String especialidad;
	private int numeroDeConsultorio;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		especialidad = JOptionPane.showInputDialog("Ingrese su especialidad");
		numeroDeConsultorio = Integer.parseInt(JOptionPane.showInputDialog("N� de consultorio"));
	}
	
	
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getNumeroDeConsultorio() {
		return numeroDeConsultorio;
	}
	public void setNumeroDeConsultorio(int numeroDeConsultorio) {
		try {
			int validar=numeroDeConsultorio;
			this.numeroDeConsultorio=validar;
		} catch (Exception e) {
			System.out.println("Ingrese un número de consultorio válido.");
		}
		
		this.numeroDeConsultorio = numeroDeConsultorio;
	}
	
	
	
}
