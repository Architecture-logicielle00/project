package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.Projet;

public class FactoryProjet {
	Projet creerProjet(String nom, String entreprise, String description)
	{
		return new Projet(nom, entreprise, description);
	}
	
	Projet creerProjet(Projet p)
	{
		return new Projet(p.obtNom(), p.obtEntreprise(), p.obtDescription());
	}
}
