package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;

import ca.ulaval.glo4003.projet_de_session.exception.EmployeIntrouvableException;

public class Departement {
	private String NomDepartement;
	private String Entreprise;
	private ArrayList<String> projets;
	private ArrayList<Employe> employes;
	
	
	public Departement() {
	}


	public Departement(String nomDepartement, String entreprise, ArrayList<String> projets) {
		NomDepartement = nomDepartement;
		Entreprise = entreprise;
		this.projets = projets;
		this.employes = new ArrayList<Employe>();
	}


	public String obtNomDepartement() {
		return NomDepartement;
	}


	public void setNomDepartement(String nomDepartement) {
		NomDepartement = nomDepartement;
	}

	public String obtEntreprise() {
		return Entreprise;
	}


	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
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
	
	public void ajouterEmploye(Employe employe) {
		employes.add(employe);
	}

	public void enleverEmploye(String NomEmploye) {
		for (Employe employe : employes) {
			if (employe.obtNom() == NomEmploye)
				 employes.remove(employe);
		}

		throw new EmployeIntrouvableException();
	}
	
	public Employe obtEmploye(String NomEmploye) {
		for (Employe employe : employes) {
			if (employe.obtNom() == NomEmploye)
				return employe;
		}

		throw new EmployeIntrouvableException();
	}
	
	public void ajouterProjet(String projet) {
		projets.add(projet);
	}

	public void enleverProjet(String projet) {
		
		projets.remove(projet);
	}
	
	
	
}
