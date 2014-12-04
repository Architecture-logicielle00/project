package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache;

public class Tache {
	
	private String nom;
	private String description;

	public Tache(String _nom, String _description) {
		nom = _nom;
		description = _description;
	}

	public String obtNom() {
		return nom;
	}

	public String obtDescription() {
		return description;
	}

	public void changerNom(String _nom) {
		nom = _nom;
	}

	public void changerDescription(String _description) {
		description = _description;
	}

}
