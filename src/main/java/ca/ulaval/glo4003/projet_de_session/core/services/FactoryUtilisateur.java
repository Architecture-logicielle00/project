package ca.ulaval.glo4003.projet_de_session.core.services;

import ca.ulaval.glo4003.projet_de_session.model.Employe;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

public class FactoryUtilisateur
{
	public Utilisateur creerUtilisateur(String login, String mdp)
	{
		return new Utilisateur(login, mdp);
	}
	
	public Utilisateur creerEmploye(String login, String nom, String prenom, String mdp)
	{
		return new Employe(login, mdp, nom, prenom);
	}
	
	public Utilisateur creerGestionnaire(String login, String nom, String prenom, String mdp)
	{
		Employe e = new Employe(login, mdp, nom, prenom);
		e.changerStatutGestionnaire(true);
		return e;
	}
}
