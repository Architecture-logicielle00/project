package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet;



public class FactoryProjet {
	public Projet creerProjet(String nom, String description)
	{
		return new Projet(nom, description);
	}
	
	public Projet creerProjet(String nom)
	{
		return new Projet(nom);
	}
}
