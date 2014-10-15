package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import ca.ulaval.glo4003.projet_de_session.core.domain.TempsParTacheTest;

public class FeuilleDeTempsViewModel {
	
	public String debutPeriode;
	
	public String finPeriode;
	
	public String employe;
	
	public ArrayList<TempsParTacheViewModel> taches;
			
	public String obtDebutPeriode() {return debutPeriode;}	
	public void defDebutPeriode(String _debutPeriode){debutPeriode = _debutPeriode;}

	public String obtFinPeriode() {return finPeriode;}
	public void defFinPeriode(String _finPeriode){finPeriode = _finPeriode;}

	public String obtEmploye() {return employe;}
	public void defEmploye(String _employe) {this.employe = _employe;}
	
	public ArrayList<TempsParTacheViewModel> obtTaches() {return taches;}
	public void defTaches(ArrayList<TempsParTacheViewModel> _taches) {this.taches = _taches;}
	
	public ArrayList<String> obtListeJoursPeriode(){
		ArrayList<String> dates = new ArrayList<String>();
		
		LocalDate debutPeriodeDateTime = new LocalDate(new DateTime(debutPeriode));
		LocalDate finPeriodeDateTime = new LocalDate(new DateTime(finPeriode));
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-yyyy");
		
		int days = Days.daysBetween(debutPeriodeDateTime, finPeriodeDateTime).getDays();
		for (int i=0; i < days; i++) {
		    LocalDate d = debutPeriodeDateTime.withFieldAdded(DurationFieldType.days(), i);
		    dates.add(formatter.print(d));
		}
		
		return dates;
	}
	
	



}
