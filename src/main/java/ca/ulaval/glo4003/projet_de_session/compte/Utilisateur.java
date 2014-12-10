package ca.ulaval.glo4003.projet_de_session.compte;

public class Utilisateur {
	protected String nomUtilisateur;
	protected String mdp;

	public Utilisateur(String _nomUtilisateur, String _mdp) {
		nomUtilisateur = _nomUtilisateur;
		mdp = _mdp;
	}

	public Utilisateur() {
		nomUtilisateur = "";
		mdp = "";
	}

	public String obtNomUtilisateur() {
		return nomUtilisateur;
	}

	public boolean motDePasseEstValide(String _mdp) {
		return mdp.equals(_mdp);
	}
}