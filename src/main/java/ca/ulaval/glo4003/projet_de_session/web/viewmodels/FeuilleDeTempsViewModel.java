package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Map;

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

	public void defDebutPeriode(Date debutPeriode) {
		this.debutPeriode = debutPeriode;
	}

	public Date obtFinPeriode() {
		return finPeriode;
	}

	public void defFinPeriode(Date finPeriode) {
		this.finPeriode = finPeriode;
	}

	public String obtEmploye() {
		return employe;
	}

	public void defEmploye(String employe) {
		this.employe = employe;
	}

	public Map<String, ArrayList<Float>> obtTaches() {
		return taches;
	}

	public void defTaches(Map<String, ArrayList<Float>> taches) {
		this.taches = taches;
	}

	public Date debutPeriode;
	
	public Date finPeriode;
	
	public String employe;
	
	public Map<String, ArrayList<Float>> taches;

}
