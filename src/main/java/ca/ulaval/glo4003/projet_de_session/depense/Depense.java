package ca.ulaval.glo4003.projet_de_session.depense;

import java.util.Date;

import org.joda.time.DateTime;

import ca.ulaval.glo4003.projet_de_session.approbation.Approbation;

public abstract class Depense implements Approuvable {
	
	private String identifiant;

	private String date;
	
	private String time;

	private String description;
	
	private Approbation approbation;

	public Depense(String _identifiant, String _date, String _time, String _description ) {
		identifiant = _identifiant;
		date = _date;
		time = _time;
		description = _description;
		approbation = new Approbation();
	}
	
	public Depense(){approbation = new Approbation();}

	public String obtIdentifiant() {
		return identifiant;
	}
	
	public Boolean identifiantEstEgal(String _identifiant){
		return identifiant.equals(_identifiant);
	}

	public void defIdentifiant(String indentifiant) {
		this.identifiant = indentifiant;

	}

	public String obtDate() {
		return date;
	}

	public void defDate(String date) {
		this.date = date;

	}
	
	public String obtTime() {
		return time;
	}

	public void defTime(String _time) {
		this.time = _time;

	}

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}

	
}
