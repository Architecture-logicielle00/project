package ca.ulaval.glo4003.projet_de_session.model;

public class Depense {
	public enum Etat
	{
		enAttente,
		accepter,
		refuser
	}
	
	public Depense(Employe _employe, float _montant, String _description, Projet _projet)
	{
		employe = _employe;
		montant = _montant;
		description = _description;
		projet = _projet;
	}
	
	public void confirmation(Etat _etat)
	{
		etat = _etat;
	}
	
	public void changerMontant(float _montant)
	{
		montant = _montant;
	}
	
	float montant;
	String description;
	Employe employe;
	Projet projet;
	Etat etat = Etat.enAttente;
}
