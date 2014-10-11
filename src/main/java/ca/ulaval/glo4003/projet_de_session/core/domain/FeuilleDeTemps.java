package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class FeuilleDeTemps {
	
	
	private Long index;
	private ArrayList<TempsParTache> taches; 
	private Date debut;
	private Date fin;
	private String identifiant;
	
	public FeuilleDeTemps(){}
	
	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin, ArrayList<String> _listeTaches)
	{
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;
		
		taches = new ArrayList<TempsParTache>();
		
		for (int i = 0; i < _listeTaches.size(); i++) {
			taches.add(new TempsParTache(_listeTaches.get(i), obtNombreJourPeriode()));
		}
		
	}	
	
	public ArrayList<TempsParTache> obtTaches(){return taches;}

	public void defTaches(ArrayList<TempsParTache> _taches) {
		taches = _taches;
	}
	
	public TempsParTache obtUneTache(String _tache){		
		for (TempsParTache blocDeTemps : taches) {
			if(blocDeTemps.obtTache() == _tache)
				return blocDeTemps;
		}
		
		return null; //////////TODO :!!!!!!!!!!!!!!!!!!
	}

	public void defUneTache(TempsParTache _tache){
		taches.add(_tache);
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
	
	

}
