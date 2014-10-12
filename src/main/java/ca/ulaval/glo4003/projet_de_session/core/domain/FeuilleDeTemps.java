package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

import ca.ulaval.glo4003.projet_de_session.exception.TacheIntrouvableException;

public class FeuilleDeTemps {

	private ArrayList<TempsParTache> taches;
	private Date debut;
	private Date fin;
	private String identifiant;

	public FeuilleDeTemps() {
	}

	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin,
			ArrayList<String> _listeTaches) {
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;

		taches = new ArrayList<TempsParTache>();

		for (int i = 0; i < _listeTaches.size(); i++) {
			taches.add(new TempsParTache(_listeTaches.get(i),
					obtNombreJourPeriode()));
		}
	}

	public ArrayList<TempsParTache> obtTaches() {
		return taches;
	}

	public void defTaches(ArrayList<TempsParTache> _taches) {
		taches = _taches;
	}

	public Date obtDebut() {
		return debut;
	}

	public void defDebut(Date dbt) {
		debut = dbt;
	}

	public Date obtFin() {
		return fin;
	}

	public void defFin(Date Fn) {
		fin = Fn;
	}

	public String obtNomEmploye() {
		return identifiant;
	}

	public void defNomEmploye(String id) {
		identifiant = id;
	}

	public TempsParTache obtUneTache(String _tache) {
		for (TempsParTache blocDeTemps : taches) {
			if (blocDeTemps.obtTache() == _tache)
				return blocDeTemps;
		}

		throw new TacheIntrouvableException();
	}

	public void defUneTache(TempsParTache _tache) {
		taches.add(_tache);
	}

	private int obtNombreJourPeriode() {
		return Days.daysBetween((new DateTime(debut)).toLocalDate(),
				(new DateTime(fin)).toLocalDate()).getDays();
	}

}
