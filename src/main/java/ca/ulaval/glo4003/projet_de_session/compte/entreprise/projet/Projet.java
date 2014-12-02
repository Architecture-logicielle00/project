package ca.ulaval.glo4003.projet_de_session.compte.entreprise.projet;

import java.util.ArrayList;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.projet.tache.Tache;

public class Projet {

	private String nom;
	private String description;
	private ArrayList<Tache> taches;

	public Projet(String _numero, String _nom, String _description) {
		nom = _nom;
		description = _description;
		taches = new ArrayList<Tache>();
	}

	public Projet() {
		taches = new ArrayList<Tache>();
	}

	public String obtNom() {
		return nom;
	}

	public String obtDescription() {
		return description;
	}

	public ArrayList<Tache> obtTache() {
		return taches;
	}

	public void changerNom(String _nom) {
		nom = _nom;
	}

	public void changerDescription(String _description) {
		description = _description;
	}

	public void ajouterTache(Tache tache) {
		taches.add(tache);
	}

	public void enleverTache(Tache tache) {
		taches.remove(tache);
	}

}
