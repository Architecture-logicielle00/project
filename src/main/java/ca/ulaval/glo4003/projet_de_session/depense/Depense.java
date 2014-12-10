package ca.ulaval.glo4003.projet_de_session.depense;

public abstract class Depense {
	
	private String soumissionnaire;
	private String date;
	private String time;
	private String description;

	public Depense(String _soumissionnaire, String _date, String _time, String _description ) {
		soumissionnaire = _soumissionnaire;
		date = _date;
		time = _time;
		description = _description;
	}
	
	public Depense(){
		soumissionnaire = "";
		date = "";
		time = "";
		description = "";
	}

	public String obtIdentifiant(){
		return 
				this.obtSoumissionnaire() + 
				this.obtDate() + 
				this.obtTime();
	}
	
	public String obtSoumissionnaire() {
		return soumissionnaire;
	}
	
	public Boolean estSoumissionnaire(String _soumissionnaire){
		return soumissionnaire.equals(_soumissionnaire);
	}

	public void defSoumissionnaire(String _soumissionnaire) {
		this.soumissionnaire = _soumissionnaire;

	}

	public String obtDate() {
		return date;
	}
	
	public String obtTime() {
		return time;
	}

	public String obtDescription() {
		return description;
	}

	public void defDescription(String description) {
		this.description = description;

	}
	
}
