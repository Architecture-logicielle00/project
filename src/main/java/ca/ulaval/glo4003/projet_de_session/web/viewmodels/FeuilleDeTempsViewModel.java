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

public class FeuilleDeTempsViewModel {
	
	public Long id;
		
	public Long obtId() {
		return id;
	}

	public void defId(Long id) {
		this.id = id;
	}

	public Date obtDebutPeriode() {
		return debutPeriode;
	}
	
	public String obtStringDebutPeriode() {
		return DateTimeFormat.forPattern("YYYY-MM-DD").print(new DateTime(debutPeriode));
	}


	public void defDebutPeriode(Date debutPeriode) {
		this.debutPeriode = debutPeriode;
	}

	public Date obtFinPeriode() {
		return finPeriode;
	}

	public void defFinPeriode(Date finPeriode) {
		this.finPeriode = finPeriode;
	}
	
	public String obtStringFinPeriode() {
		return DateTimeFormat.forPattern("YYYY-MM-DD").print(new DateTime(finPeriode));
	}

	public String obtEmploye() {
		return employe;
	}

	public void defEmploye(String employe) {
		this.employe = employe;
	}
	
	public ArrayList<String> obtListeJoursPeriode(){
		ArrayList<String> dates = new ArrayList<String>();
		
		LocalDate debutPeriodeDateTime = new LocalDate(new DateTime(debutPeriode));
		LocalDate finPeriodeDateTime = new LocalDate(new DateTime(finPeriode));
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("DD-MM-YYYY");
		
		int days = Days.daysBetween(debutPeriodeDateTime, finPeriodeDateTime).getDays();
		for (int i=0; i < days; i++) {
		    LocalDate d = debutPeriodeDateTime.withFieldAdded(DurationFieldType.days(), i);
		    dates.add(formatter.print(d));
		}
		
		return dates;
	}

	public ArrayList<Float> obtTempsParTache(String key) {
		return taches.get(key);
	}
	
	public Set<String> obtListeTaches() {
		return taches.keySet();
	}

	public void defTaches(Map<String, ArrayList<Float>> taches) {
		this.taches = taches;
	}

	public Date debutPeriode;
	
	public Date finPeriode;
	
	public String employe;
	
	public Map<String, ArrayList<Float>> taches;

}
