package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;


public class FactoryDepartement {
	public Departement creerDepartement(String nom)
	{
		return new Departement(nom);
	}
	
	public Departement creerDepartement(String nom, List<Projet> projets)
	{
		return new Departement(nom, projets);
	}
}
