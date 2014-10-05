package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;


public class FeuilleDeTemps {
	
	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin)
	{
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;
		
		//TODO : ajouter les taches par rapport à l'employe
	}
	
	public FeuilleDeTemps(){}
	
	public void ajouterUneTache(String _tache){
		
	}
	
	public Date obtDebut(){ return debut; }
	
	public Date obtFin(){ return fin; }
	
	public String obtNomEmploye(){ return identifiant; }
	
	
	private Dictionary<String, ArrayList<Float>> taches;
	
	private Date debut;
	private Date fin;
	private String identifiant;
}
