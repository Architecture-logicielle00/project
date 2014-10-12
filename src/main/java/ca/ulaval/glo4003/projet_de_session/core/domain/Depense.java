package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public class Depense {

	private String indentifiant;

	private Date date;

	private String description;

	private float sousTotal;

	public String obtIdentifant() {
		return indentifiant;
	}

	public void defIdentifiant(String indentifiant) {
		this.indentifiant = indentifiant;

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
}
