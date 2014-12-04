package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache;

import java.util.List;

public class EmployeTachesViewModel {
	public String nomUtilisateur;
	public String nom;
	public List<String> taches;
	
	public EmployeTachesViewModel(String nomUtilisateur, String nom, List<String> taches)
	{
		this.nomUtilisateur = nomUtilisateur;
		this.nom = nom;
		this.taches = taches;
	}
}
	
