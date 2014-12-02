package ca.ulaval.glo4003.projet_de_session.compte.employe;

import ca.ulaval.glo4003.projet_de_session.compte.UtilisateurViewModel;

public class EmployeeViewModel extends UtilisateurViewModel{
	//public String nomUtilisateur;
	public String nom;
	public String prenom;
	public String email;
	public String pays;
	public String province;
	public String ville;
	public String codePostal;
	public String sexe;
	public String telephone;
	public boolean statutGestionnaire;
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public boolean estGestionnaire() {
		return statutGestionnaire;
	}
}
