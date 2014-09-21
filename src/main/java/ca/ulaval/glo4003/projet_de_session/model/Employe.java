package ca.ulaval.glo4003.projet_de_session.model;

import java.util.List;

public class Employe extends SimpleUtilisateur {
	public Employe(String _nomUtilisateur, String _mdp) {
		super(_nomUtilisateur, _mdp);
		// TODO Auto-generated constructor stub
	}

	List<Feuille> feuilles;
	List<SimpleProjet> projets;
	boolean estGestionnaire = false;
	Employe gestionnaire;
}
