package ca.ulaval.glo4003.projet_de_session.model;

public class SimpleUtilisateur 
{
	private String nomUtilisateur;
	private final String mdp;
	
	public SimpleUtilisateur(String _nomUtilisateur,String _mdp)
	{
		nomUtilisateur = _nomUtilisateur;
		mdp = _mdp;
	}
	
	public String ObtenirNomUtilisateur()
	{
		return nomUtilisateur;
	}
	
	public boolean MotDePasseValide(String _mdp)
	{
		return mdp.equals(_mdp);
	}
	
	//Avoir une vrai logique pour sa
	public boolean CreationPower()
	{
		return true;
	}
}