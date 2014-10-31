package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.Date;

public class DepenseViewModel {

	public String identifiant;
	public String date;
	public String description;

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

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}

}
