package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class UserViewModel {
	
	private String nomUtilisateur;
	
	public UserViewModel(String _nomUtilisateur)
	{
		nomUtilisateur = _nomUtilisateur;
	}
	
	public String ObtenirNomUtilisateur()
	{
		return nomUtilisateur;
	}
}
