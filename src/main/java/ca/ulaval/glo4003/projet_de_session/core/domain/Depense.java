package ca.ulaval.glo4003.projet_de_session.core.domain;

import org.joda.time.DateTime;

public class Depense {

	private String indentifiant;

	public String obtIdentifant() {
		return indentifiant;
	}

	public void defIdentifiant(String indentifiant) {
		this.indentifiant = indentifiant;

	}

	private DateTime date;

	public DateTime obtDate() {
		return date;
	}

	public void defDate(DateTime date) {
		this.date = date;

	}

	private String description;

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}

	private float sousTotal;

	public float obtSoutTotal() {
		return sousTotal;
	}

	public void defSousTotal(float sousTotal) {
		this.sousTotal = sousTotal;
	}
}
