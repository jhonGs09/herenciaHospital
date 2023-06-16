package clases;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Paciente extends Personas{

	private int numeroHistoriaClinica;
	private String sexo;
	private String grupoSanguineo;
	private ArrayList<String> listaDeMedicamentosAlergico;
	
	@Override
	public void registrarDatos() {
		
		super.registrarDatos();
		listaDeMedicamentosAlergico = new ArrayList<String>();
		numeroHistoriaClinica = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la historia clinica"));
		sexo = JOptionPane.showInputDialog("Ingrese el sexo");
		grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo sanguineo");
		
		String pregunta = JOptionPane.showInputDialog("� Es alergico a algun medicamento ? ingrese si o no ");
		
		if (pregunta.equalsIgnoreCase("si")) {
			String medicamento = "";
			String continuar = "";
			
			do {
				medicamento = JOptionPane.showInputDialog("Ingrese el nombre del medicamento al que es alergico");
				listaDeMedicamentosAlergico.add(medicamento);
				
				continuar = JOptionPane.showInputDialog("Ingrese si , si desea continuar");
			} while (continuar.equalsIgnoreCase("si"));
		}
	}
	
	public int getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}
	public void setNumeroHistoriaClinica(int numeroHistoriaClinica) {
		
		try {
			int validar = numeroHistoriaClinica;
			this.numeroHistoriaClinica=validar;
		} catch (Exception e) {
			System.out.println("Dato inválido, ingrese algo bien.");
		}
		this.numeroHistoriaClinica = numeroHistoriaClinica;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}
	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}
	public ArrayList<String> getListaDeMedicamentosAlergico() {
		return listaDeMedicamentosAlergico;
	}
	public void setListaDeMedicamentosAlergico(ArrayList<String> listaDeMedicamentosAlergico) {
		this.listaDeMedicamentosAlergico = listaDeMedicamentosAlergico;
	}
}
