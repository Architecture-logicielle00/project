package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

import org.joda.time.DateTime;
import org.joda.time.Days;



public class FeuilleDeTemps {
	
	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin, ArrayList<String> _listeTaches)
	{
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;
		
		for (int i = 0; i < _listeTaches.size(); i++) {
			
			ArrayList<Float> nbHeuresParJour = new ArrayList<Float>();
			
			for (int j = 0; j < obtNombreJourPeriode(); j++) {
				nbHeuresParJour.add((float) 0.0);
			}
			
			taches.put(_listeTaches.get(i), nbHeuresParJour);
		}
		
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
	
	private int obtNombreJourPeriode(){
		return Days.daysBetween((new DateTime(debut)).toLocalDate(), (new DateTime(fin)).toLocalDate()).getDays();
	}
	
	
	
	private Long index;//id appel� dans le repo pour les meths ajouter, supp, modifiable 
	private Dictionary<String, ArrayList<Float>> taches; //en effet, je ne savais pas � quoi sert vraiment le ArrayList<Float>
	private Date debut;
	private Date fin;
	private String identifiant;
}
