package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public class Depense {
	
	private String identifiant;

	private Date date;

	private String description;

	private float sousTotal;
	
	private float total;

	public Depense(String _identifiant, Date _date, float _total, float _sousTotal, String _description ) {
		identifiant = _identifiant;
		date = _date;
		total = _total;
		sousTotal = _sousTotal;
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

	public float obtSoutTotal() {
		return sousTotal;
	}

	public void defSousTotal(float sousTotal) {
		this.sousTotal = sousTotal;
	}
	
	public float obtTotal() {
		return total;
	}

	public void defTotal(float total) {
		this.total = total;
	}
}
