package ca.ulaval.glo4003.projet_de_session.core.domain;

import org.joda.time.DateTime;

public class Depense {

	private DateTime date;
	
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;

	}

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;

	}
	
	private float sousTotal;

	public float getSoutTotal() {
		return sousTotal;
	}

	public void setSousTotal(float sousTotal) {
		this.sousTotal = sousTotal;
	}
}
