package ca.ulaval.glo4003.projet_de_session.feuilleDeTemps;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.TacheIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.tempsParTache.TempsParTache;

public class FeuilleDeTemps {

	private ArrayList<TempsParTache> tempsParTaches;
	private ArrayList<String> commentaires;
	private Date debut;
	private Date fin;
	private String identifiant;

	public FeuilleDeTemps() {}

	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin,
			ArrayList<String> _listeTaches) {
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;

		commentaires = new ArrayList<String>();
		for (int i = 0; i < obtNombreJourPeriode(); i++) {
			commentaires.add("");
		}

		tempsParTaches = new ArrayList<TempsParTache>();
		for (int i = 0; i < _listeTaches.size(); i++) {
			tempsParTaches.add(new TempsParTache(_listeTaches.get(i),
					obtNombreJourPeriode()));
		}
	}

	public FeuilleDeTemps(String _identifiant, Date _debut, Date _fin) {
		identifiant = _identifiant;
		debut = _debut;
		fin = _fin;
		commentaires = new ArrayList<String>();
		for (int i = 0; i < obtNombreJourPeriode(); i++) {
			commentaires.add("");
		}
	}
	
	private boolean containsTache(String tache)
	{
		for (TempsParTache tempsParTache : tempsParTaches)
		{
			if(tempsParTache.obtTache().equals(tache)) return true;
		}
		return false;
	}
	
	public void addTache(String tache)
	{
		if(containsTache(tache) == false)
		{
			tempsParTaches.add(new TempsParTache(tache, obtNombreJourPeriode()) );
		}
	}
	
	public void addTaches(List<String> taches)
	{
		for(String tache : taches)
		{
			addTache(tache);
		}
	}

	public ArrayList<TempsParTache> obtTaches() {
		return tempsParTaches;
	}

	public void setTaches(ArrayList<TempsParTache> _taches) {
		tempsParTaches = _taches;
	}

	public ArrayList<String> obtCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<String> _commentaires) {
		commentaires = _commentaires;
	}

	public Date obtDebut() {
		return debut;
	}

	public void setDebut(Date dbt) {
		debut = dbt;
	}

	public Date obtFin() {
		return fin;
	}

	public void setFin(Date Fn) {
		fin = Fn;
	}

	public Boolean estCourante(Date date) {
		return !(date.before(debut) || date.after(fin));
	}

	public String obtIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String id) {
		identifiant = id;
	}

	public boolean appartientA(String _identifiant) {
		return identifiant.equals(_identifiant);
	}

	public TempsParTache obtTempsParTache(String _tache) {
		for (TempsParTache blocDeTemps : tempsParTaches) {
			if (blocDeTemps.obtTache() == _tache)
				return blocDeTemps;
		}

		throw new TacheIntrouvableException();
	}

	public void addTempsParTache(TempsParTache _tache) {
		tempsParTaches.add(_tache);
	}

	private int obtNombreJourPeriode() {
		return Days.daysBetween((new DateTime(debut)).toLocalDate(),
				(new DateTime(fin)).toLocalDate()).getDays() + 1;
	}

}
