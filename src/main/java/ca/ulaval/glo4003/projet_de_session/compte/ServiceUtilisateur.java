package ca.ulaval.glo4003.projet_de_session.compte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;

@Service
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
	
	public boolean estUneEntreprise(String nomUtilisateur)
	{
		Utilisateur utilisateur = (Utilisateur) serviceEntreprise.obtEntreprise(nomUtilisateur);
		if(utilisateur == null)
		{
			return false;
		}
		return true;
	}
	
	public boolean estUnEmploye(String nomUtilisateur){
		Utilisateur utilisateur = (Utilisateur) serviceEmploye.obtEmploye(nomUtilisateur);
		if(utilisateur == null)
		{
			return false;
		}
		return true;
	}
	
	public boolean verifierMotDePasse(String nomUtilisateur, String mdp)
	{
		return obtenirUtilisateur(nomUtilisateur).motDePasseValide(mdp);
	}
}
