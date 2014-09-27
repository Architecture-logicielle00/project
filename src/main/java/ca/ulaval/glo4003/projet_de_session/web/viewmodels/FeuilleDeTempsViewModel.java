package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

import ca.ulaval.glo4003.projet_de_session.model.BlocDeTemps;

public class FeuilleDeTempsViewModel {
	
	public Date obtDateDebut(){
		return debut;
	}
	
	public Date obtDateFin(){
		return fin;
	}
	
	public String obtNomUtilisateur(){
		return nom_utilisateur;
	}
	
	public ArrayList<BlocDeTemps> obtBlocsDeTemps(){
		return blocsDeTemps;
	}
	
	public ArrayList<BlocDeTemps> obtBlocsDeTempsParDate(Date _jour){
		ArrayList<BlocDeTemps> blocsSpecifique = new ArrayList<BlocDeTemps>();
		
		for (BlocDeTemps blocDeTemps : blocsDeTemps) {
			if(blocDeTemps.obtJour().compareTo(_jour) == 0)
				blocsSpecifique.add(blocDeTemps);
		}
		
		return blocsSpecifique;
	}
	
	public ArrayList<BlocDeTemps> obtBlocsDeTempsParTache(String _tache){
		ArrayList<BlocDeTemps> blocsSpecifique = new ArrayList<BlocDeTemps>();
		
		for (BlocDeTemps blocDeTemps : blocsDeTemps) {
			if(blocDeTemps.obtTache() == _tache)
				blocsSpecifique.add(blocDeTemps);
		}
		
		return blocsSpecifique;
	}
	
	public void changerNbHeureBlocDeTemps(Date jour, String tache, float _nbHeure){
		
		for (BlocDeTemps blocDeTemps : blocsDeTemps) {
			if(blocDeTemps.obtJour().compareTo(jour) == 0 && blocDeTemps.obtTache() == tache)
				blocDeTemps.changerNbHeure(_nbHeure);
		}
	}
		
	public ArrayList<DateTime> obtListeJourPeriode(){
		DateTime dtDebut = new DateTime(debut);
		DateTime dtFin = new DateTime(fin);
		ArrayList<DateTime> dates = new ArrayList<DateTime>();
	
		int nbJours = Days.daysBetween(dtDebut, dtFin).getDays()+1;
		for (int i=0; i < nbJours; i++) {
		    DateTime d = dtDebut.withFieldAdded(DurationFieldType.days(), i);
		    dates.add(d);
		}
		
		return dates;
	}
	
	
	private ArrayList<BlocDeTemps> blocsDeTemps = new ArrayList<BlocDeTemps>();
	
	private Date debut;
	
	private Date fin;
	
	private String nom_utilisateur;
	
	
	
}
