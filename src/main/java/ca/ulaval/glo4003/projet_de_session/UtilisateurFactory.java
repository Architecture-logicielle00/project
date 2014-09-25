package ca.ulaval.glo4003.projet_de_session;

import ca.ulaval.glo4003.projet_de_session.model.Employe;
import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;

public class UtilisateurFactory
{
	public SimpleUtilisateur creerUtilisateur(String login, String mdp)
	{
		return new SimpleUtilisateur(login, mdp);
	}
	
	public SimpleUtilisateur creerEmploye(String login, String nom, String prenom, String mdp)
	{
		return new Employe(login, mdp, nom, prenom);
	}
	
	public SimpleUtilisateur creerGestionnaire(String login, String nom, String prenom, String mdp)
	{
		Employe e = new Employe(login, mdp, nom, prenom);
		e.changerStatutGestionnaire(true);
		return e;
	}
}
