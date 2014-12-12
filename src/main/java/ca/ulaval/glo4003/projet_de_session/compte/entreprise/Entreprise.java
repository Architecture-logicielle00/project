package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.compte.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.FactoryDepartement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class Entreprise extends Utilisateur {
	protected String nom;

	private FactoryDepartement factoryDepartement;
	private Map<String, Departement> departements;

	public Entreprise(String nomUtilisateur, String mdp, String nom) {
		this(nomUtilisateur, mdp, nom, new FactoryDepartement());
	}

	public Entreprise(String nomUtilisateur, String mdp, String nom,
			FactoryDepartement factoryDepartement) {
		super(nomUtilisateur, mdp);
		this.nom = nom;
		this.departements = new HashMap<String, Departement>();
		this.factoryDepartement = factoryDepartement;
	}

	public Departement createDepartement(String nom) {
		Departement dep = factoryDepartement.creerDepartement(nom);
		addDepartement(dep);
		return dep;
	}

	public void addDepartement(Departement dep) {
		departements.put(dep.obtNomDepartement(), dep);
	}

	public void deleteDepartement(String nom) {
		departements.remove(nom);
	}

	public Departement getDepartement(String nom) {
		return departements.get(nom);
	}

	public Departement getDepartementParEmploye(String nom) {
		List<Departement> listeDepartement = new ArrayList<Departement>(
				departements.values());
		for (Departement dep : listeDepartement) {
			if (dep.obtEmployes().contains(nom))
				return dep;
		}
		return null;
	}

	public List<Departement> getDepartements() {
		return new ArrayList<Departement>(departements.values());
	}

	public List<Projet> getProjetsParDepartement(String nomDepartement) {
		Departement dep = departements.get(nomDepartement);
		if (dep != null)
			return dep.obtProjets();
		else
			return new ArrayList<Projet>();
	}

}
