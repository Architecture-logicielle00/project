package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

import org.joda.time.DateTime;

public abstract class Depense {
	
	private String identifiant;

	private String date;
	
	private String time;

	private String description;

	public Depense(String _identifiant, String _date, String _time, String _description ) {
		identifiant = _identifiant;
		date = _date;
		time = _time;
		description = _description;
		
		
	}
	
	public Depense(){}

	public String obtIdentifant() {
		return identifiant;
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
