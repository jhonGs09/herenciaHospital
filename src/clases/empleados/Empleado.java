package clases.empleados;

import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import clases.Personas;

public class Empleado extends Personas{
	
	private String codigoEmpleado;
	private int numeroDeHorasExtra;
	private String fechaDeIngreso;
	private String area;
	private String cargo;
	
	@Override
	public void registrarDatos() {
		super.registrarDatos();
		
		codigoEmpleado = JOptionPane.showInputDialog("Ingrese el codigo del empleado");
		numeroDeHorasExtra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese le numero de horas extra"));
		fechaDeIngreso = JOptionPane.showInputDialog("Ingrese la fecha de ingreso");
		area = JOptionPane.showInputDialog("Ingrese el area");
		cargo = JOptionPane.showInputDialog("Ingrese el cargo");
	}
	
	
	public String getCodigoEmpleado() {
		return codigoEmpleado;
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = codigoEmpleado;
	}
	public int getNumeroDeHorasExtra() {
		return numeroDeHorasExtra;
	}
	public void setNumeroDeHorasExtra(int numeroDeHorasExtra) {
		this.numeroDeHorasExtra = numeroDeHorasExtra;
	}
	public String getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(String fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
