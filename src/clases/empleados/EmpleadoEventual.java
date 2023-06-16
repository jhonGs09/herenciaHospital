package clases.empleados;

import javax.swing.JOptionPane;

public class EmpleadoEventual extends Empleado{

	private double honorariosPorHora;
	private String fechaTerminoContrato;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		honorariosPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario mensual"));
		fechaTerminoContrato = JOptionPane.showInputDialog("Ingrese fecha de vencimiento (dd/mm/aaaa)");
		
	}
	
	
	public double getHonorariosPorHora() {
		return honorariosPorHora;
	}
	public void setHonorariosPorHora(double honorariosPorHora) {
		try {
			Double validar=honorariosPorHora;
			this.honorariosPorHora=validar;
		} catch (Exception e) {
			System.out.println("Ingrese algo valido");
		}
		this.honorariosPorHora = honorariosPorHora;
	}
	public String getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}
	public void setFechaTerminoContrato(String fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}
	
	
	
}
