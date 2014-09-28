package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;


public class Employe extends Utilisateur
{
	public Employe(String _nomUtilisateur, String _mdp, String _nom, String _prenom)
	{
		super(_nomUtilisateur, _mdp);
		
		nom = _nom;
		prenom = _prenom;
		projets = new ArrayList<String>();
		feuillesDeTemps = new ArrayList<FeuilleDeTemps>();
	}
	
	public Employe()
	{
	}
	
	public String obtNom(){ return nom;	}
	public void changerNom(String _nom){ nom = _nom; }
	
	public String obtPrenom(){ return prenom; }
	public void changerPrenom(String _prenom){ prenom = _prenom;}
	
	public boolean estGestionnaire(){ return statutGestionnaire; }
	public void changerStatutGestionnaire(boolean s){ statutGestionnaire = s;}
	
	public void ajouterProjet(String projet)
	{
		projets.add(projet);
	}
	
	public void supprimerProjet(String projet)
	{
		//TODO
	}
	
	String nom;
	String prenom;
	
	ArrayList<String> projets;
	ArrayList<FeuilleDeTemps> feuillesDeTemps;
	
	
	boolean statutGestionnaire = false;
}

