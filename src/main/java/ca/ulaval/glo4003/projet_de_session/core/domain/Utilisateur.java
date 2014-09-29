package ca.ulaval.glo4003.projet_de_session.core.domain;

public class Utilisateur 
{
	protected String nomUtilisateur;
	protected String mdp;
	
	public Utilisateur(String _nomUtilisateur,String _mdp)
	{
		nomUtilisateur = _nomUtilisateur;
		mdp = _mdp;
	}
	
	public Utilisateur()
	{
	}
	
	public String obtNomUtilisateur()
	{
		return nomUtilisateur;
	}
	
	public boolean motDePasseValide(String _mdp)
	{
		return mdp.equals(_mdp);
	}
	
	//Avoir une vrai logique pour sa
	public boolean creationPower()
	{
		return true;
	}
}