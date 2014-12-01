package ca.ulaval.glo4003.projet_de_session.core.domain;

public class Approbation {

	public Approbation() {
		EtatApprobation = etat.ATTENTE;
	}

	private Approuvable approbation;

	private enum etat {
		APPROUVEE, ATTENTE, REFUSEE
	}

	private etat EtatApprobation;

	private void approuver() {

		EtatApprobation = etat.APPROUVEE;

	}

	private void Refuser() {

		EtatApprobation = etat.REFUSEE;

	}

}
