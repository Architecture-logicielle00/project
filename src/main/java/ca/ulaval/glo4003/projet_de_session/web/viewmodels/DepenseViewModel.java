package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.Date;

public class DepenseViewModel {

	public String identifiant;
	public Date date;
	public float distance;
	public float coutkm;
	public int nbRepas;
	public float coutRepas;
	public float divers;
	public float coucher;
	public float sousTotal;
	public String description;
	public float total;

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

	public float obtSoutTotal() {
		return sousTotal;
	}

	public void defSousTotal(float sousTotal) {
		this.sousTotal = sousTotal;
	}

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}

	public float obtTotalDepense() {
		return total;
	}

}
