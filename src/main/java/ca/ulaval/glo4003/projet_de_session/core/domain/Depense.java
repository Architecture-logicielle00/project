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

	public String getIdentifant() {
		return identifiant;
	}

	public void setIdentifiant(String indentifiant) {
		this.identifiant = indentifiant;

	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;

	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String _time) {
		this.time = _time;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;

	}

	
}
