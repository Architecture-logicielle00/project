package ca.ulaval.glo4003.projet_de_session.core.domain;

public class Entreprise extends Utilisateur {
	protected String nom;
	
	public Entreprise(String nomUtilisateur, String mdp, String nom)
	{
		super(nomUtilisateur, mdp);
		this.nom = nom;
	}
}
