package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class Departement {
	private String nom;
	private String Entreprise;
	private List<Projet> projets;
	private List<String> employes;
	
	
	public Departement() {
	}
	
	public Departement(String nom)
	{
		this.nom = nom;
		this.employes = new ArrayList<String>();
		this.projets = new ArrayList<Projet>();
	}


	public Departement(String nom, List<Projet> projets) {
		this.nom = nom;
		this.projets = projets;
		this.employes = new ArrayList<String>();
	}


	public String obtNomDepartement() {
		return nom;
	}


	public void setNomDepartement(String nom) {
		this.nom = nom;
	}

	public String obtEntreprise() {
		return Entreprise;
	}


	public void setEntreprise(String entreprise) {
		Entreprise = entreprise;
	}


	public List<Projet> obtProjets() {
		return projets;
	}
	
	public List<String> obtNomProjets()
	{
		List<String> projetNoms = new ArrayList<String>();
		for (Projet projet : obtProjets())
		{
			projetNoms.add(projet.obtNom());
		}
		return projetNoms;
	}


	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}


	public List<String> obtEmployes() {
		return employes;
	}


	public void setEmployes(List<String> identifiants) {
		this.employes = employes;
	}
	
	public void ajouterEmploye(String identifiant) {
		employes.add(identifiant);
	}

	public void enleverEmploye(String identifiant) {
		employes.remove(identifiant);
	}
	
	public void ajouterProjet(Projet projet) {
		projets.add(projet);
	}

	public void enleverProjet(String projet) {
		
		projets.remove(projet);
	}
	
	public boolean containEmploye(String identifiant)
	{
		return employes.contains(identifiant);	
	}
	
}
