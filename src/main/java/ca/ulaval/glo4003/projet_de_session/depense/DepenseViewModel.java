package ca.ulaval.glo4003.projet_de_session.depense;

public class DepenseViewModel {

	public String identifiant;
	public String date;
	public String time;
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
