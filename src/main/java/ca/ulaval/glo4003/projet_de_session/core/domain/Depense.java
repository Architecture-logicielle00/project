package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public abstract class Depense {
	
	private String identifiant;

	private Date date;

	private String description;

	public Depense(String _identifiant, Date _date, String _description ) {
		identifiant = _identifiant;
		date = _date;
		description = _description;
		
		
	}
	

	public String obtIdentifant() {
		return identifiant;
	}

	public void defIdentifiant(String indentifiant) {
		this.identifiant = indentifiant;

	}

	public Date obtDate() {
		return date;
	}

	public void defDate(Date date) {
		this.date = date;

	}

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}

	
}
