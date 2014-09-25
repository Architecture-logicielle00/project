package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class UserViewModel {
	
	private String nomUtilisateur;
	boolean statutGestionnaire;
	
	public UserViewModel(String _nomUtilisateur)
	{
		nomUtilisateur = _nomUtilisateur;
		
		// TODO géré que tout le monde n'est pas gestionnaire lorsque les donnée seront sauvegarder
		statutGestionnaire = true;
	}
	
	public String ObtenirNomUtilisateur()
	{
		return nomUtilisateur;
	}
	
	public boolean EstGestionnaire()
	{
		return statutGestionnaire;
	}
}
