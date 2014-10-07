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

	public void defTaches(Dictionary<String, ArrayList<Float>> lesTaches) {
		taches = lesTaches;
	}
	
	
	public ArrayList<Float> obtUneTache(String _tache){
		return taches.get(_tache);
	}

	public void defUneTache(String _tache, ArrayList<Float> val){
		taches.put(_tache, val);
	}
	
	
	public Date obtDebut(){ return debut; }
	
	public void defDebut(Date dbt){
		debut=dbt;
	}
	
	
	public Date obtFin(){ return fin; }
	
	public void defFin(Date Fn){
		fin=Fn;
	}
	
	
	public String obtNomEmploye(){ return identifiant; }
	
	public void defNomEmploye(String id){ identifiant=id; }
	
	
    public Long obtIndex(){ return index; }
	
	public void defIndex(Long idx){ index=idx; }
	
	
	
	private Long index;
	private Dictionary<String, ArrayList<Float>> taches; //en effet, je ne savais pas à quoi sert vraiment le ArrayList<Float>
	private Date debut;
	private Date fin;
	private String identifiant;
}
