package ca.ulaval.glo4003.projet_de_session.compte.entreprise.projet;


public class FactoryProjet {
	Projet creerProjet(String nom, String entreprise, String description)
	{
		return new Projet(nom, entreprise, description);
	}
}
