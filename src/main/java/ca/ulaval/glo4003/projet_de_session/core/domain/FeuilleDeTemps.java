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
		
		//TODO : ajouter les taches par rapport Ã  l'employe
	}
	
	public FeuilleDeTemps(){super();}
	
	public 	Dictionary<String, ArrayList<Float>> obtTaches(){return taches;}

	public void definirTaches(Dictionary<String, ArrayList<Float>> lesTaches) {
		taches = lesTaches;
	}

	
	public void definirUneTache(String _tache, ArrayList<Float> val){
		taches.put(_tache, val);
	}
	
	public ArrayList<Float> obtenirUneTache(String _tache){
		return taches.get(_tache);
	}
	
	public Date obtDebut(){ return debut; }
	
	public void definirDebut(Date dbt){
		debut=dbt;
	}
	
	public Date obtFin(){ return fin; }
	
	public void definirFin(Date Fn){
		fin=Fn;
	}
	
	public String obtNomEmploye(){ return identifiant; }
	
	public void defNomEmploye(String id){ identifiant=id; }
	
	
	
	private Dictionary<String, ArrayList<Float>> taches; //en effet, je ne savais pas à quoi sert vraiment le ArrayList<Float>
	private Date debut;
	private Date fin;
	private String identifiant;
}
