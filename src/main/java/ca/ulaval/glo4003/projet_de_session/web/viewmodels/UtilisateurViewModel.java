package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class UtilisateurViewModel {
	
	private String nomUtilisateur;
	
	public UtilisateurViewModel(String _nomUtilisateur)
	{
		nomUtilisateur = _nomUtilisateur;
	}
	
	public String obtNomUtilisateur()
	{
		return nomUtilisateur;
	}
}
