package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;

public class Departement {
	private String NomDepartement;
	private ArrayList<String> projets;
	private ArrayList<Employe> employes;
	
	
	public Departement() {
	}


	public Departement(String nomDepartement, ArrayList<String> projets,
			ArrayList<Employe> employes) {
		super();
		NomDepartement = nomDepartement;
		this.projets = projets;
		this.employes = employes;
	}


	public String obtNomDepartement() {
		return NomDepartement;
	}


	public void setNomDepartement(String nomDepartement) {
		NomDepartement = nomDepartement;
	}


	public ArrayList<String> obtProjets() {
		return projets;
	}


	public void setProjets(ArrayList<String> projets) {
		this.projets = projets;
	}


	public ArrayList<Employe> obtEmployes() {
		return employes;
	}


	public void setEmployes(ArrayList<Employe> employes) {
		this.employes = employes;
	}
	
	
	
}
