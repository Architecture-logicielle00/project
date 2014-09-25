package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;
import java.util.Date;


public class Employe extends SimpleUtilisateur {
	public Employe(String _nomUtilisateur, String _mdp, String _nom, String _prenom)
	{
		super(_nomUtilisateur, _mdp);
		
		nom = _nom;
		prenom = _prenom;
	}
	
	public String obtNom()
	{
		return nom;
	}
	
	public void changerNom(String _nom)
	{
		nom = _nom;
	}
	
	public String obtPrenom()
	{
		return prenom;
	}
	
	public void changerPrenom(String _prenom)
	{
		prenom = _prenom;
	}
	
	public FeuilleDeTemps obtFeuilleDeTemps(Date date)
	{
		for (FeuilleDeTemps f : feuilles)
		{
			if ( f.obtDebut().equals(date) ) return f ;
		}
		return null;
	}
	
	public boolean estGestionnaire()
	{
		return statutGestionnaire;
	}
	
	public void changerStatutGestionnaire(boolean s)
	{
		statutGestionnaire = s;
	}
	
	String nom;
	String prenom;
	ArrayList<FeuilleDeTemps> feuilles;
	ArrayList<SimpleProjet> projets;
	boolean statutGestionnaire = false;
	String superieur;
}

