package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class UtilisateurViewModel {
	
	private String nomUtilisateur;
	boolean statutGestionnaire;
	
	public UtilisateurViewModel(String _nomUtilisateur)
	{
		nomUtilisateur = _nomUtilisateur;
		
		// TODO g�r� que tout le monde n'est pas gestionnaire lorsque les donn�e seront sauvegarder
		statutGestionnaire = true;
	}
	
	public String obtNomUtilisateur()
	{
		return nomUtilisateur;
	}
	
	public boolean estGestionnaire()
	{
		return statutGestionnaire;
	}
	
	public String nom;
	public String prenom;
	public String email;
	public String nomUsager;
	public String pays;
	public String province;
	public String ville;
	public String codePostal;
	public String mdp;
	
	public String mois;
	public String jour;
	public String annee;
	
	public String sexe;
	public String telephone;
}
