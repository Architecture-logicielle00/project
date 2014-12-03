package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;

import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeViewModel;


public class DepartementViewModel {
	private String nomDepartement;
	private String nomEntreprise;
	private ArrayList<String> projets;
	private ArrayList<EmployeeViewModel> employes;
	
	
	public String obtNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public String obtNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public ArrayList<String> obtProjets() {
		return projets;
	}
	public void setProjets(ArrayList<String> projets) {
		this.projets = projets;
	}
	public ArrayList<EmployeeViewModel> obtEmployes() {
		return employes;
	}
	public void setEmployes(ArrayList<EmployeeViewModel> employes) {
		this.employes = employes;
	}
	
}
