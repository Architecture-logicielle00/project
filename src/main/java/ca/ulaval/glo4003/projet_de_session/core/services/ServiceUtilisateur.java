package ca.ulaval.glo4003.projet_de_session.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;

public class ServiceUtilisateur {
	@Autowired
	private ServiceEmploye serviceEmploye;
	@Autowired
	private ServiceEntreprise serviceEntreprise;
	
	public Utilisateur obtenirUtilisateur(String nomUtilisateur)
	{
		Utilisateur utilisateur = (Utilisateur) serviceEmploye.obtEmploye(nomUtilisateur);
		if(utilisateur == null)
		{
			return (Utilisateur) serviceEntreprise.obtEntreprise(nomUtilisateur);
		}
		return utilisateur;
	}
	
	public boolean verifierMotDePasse(String nomUtilisateur, String mdp)
	{
		return obtenirUtilisateur(nomUtilisateur).motDePasseValide(mdp);
	}
}
