package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet;

import java.util.List;

public class ProjetViewModel {
	String nom;
	List<String> taches;
	
	public ProjetViewModel(String nom, List<String> taches)
	{
		this.nom = nom;
		this.taches = taches;
	}
}
