package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;

public class FactoryEmploye
{	
	public Employe creerEmploye(String nomUtilisateur, String nom, String prenom, String mdp, String entreprise)
	{
		return new Employe(nomUtilisateur, mdp, nom, prenom, entreprise, "aaa@aaa.com", "Canada", "Quebec", "Quebec", "X0X0X0", 0, 0, 0, "homme", "999-999-9999");
	}
	public Employe creerEmploye(String nomUtilisateur,
			String mdp,
			String nom,
			String prenom,
			String entreprise,
			String email,
			String pays,
			String province,
			String ville,
			String codePostal,
			Integer jour,
			Integer mois,
			Integer annee,
			String genre,
			String telephone)
	{
		return new Employe(nomUtilisateur, mdp, nom, prenom, entreprise, email, pays, province, ville, codePostal, mois, jour, annee, genre, telephone);
	}
	
	public Employe creerGestionnaire(String nomUtilisateur, String nom, String prenom, String mdp, String entreprise)
	{
		Employe e = new Employe(nomUtilisateur, mdp, nom, prenom, entreprise, "aaa@aaa.com", "Canada", "Quebec", "Quebec", "X0X0X0", 0, 0, 0, "homme", "999-999-9999");
		e.changerStatutGestionnaire(true);
		return e;
	}
	
	public Employe creerGestionnaire(String nomUtilisateur,
			String mdp,
			String nom,
			String prenom,
			String entreprise,
			String email,
			String pays,
			String province,
			String ville,
			String codePostal,
			Integer jour,
			Integer mois,
			Integer annee,
			String genre,
			String telephone)
	{
		Employe e =  new Employe(nomUtilisateur, mdp, nom, prenom, entreprise, email, pays, province, ville, codePostal, mois, jour, annee, genre, telephone);
		e.changerStatutGestionnaire(true);
		return e;
	}
}
