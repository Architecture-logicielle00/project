package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;

public interface IRepositoryUtilisateur 
{
	public SimpleUtilisateur ObtenirUnUtilisateur(String nomUtilisateur);
	public void AjouterUtilisateur(String nomUtilisateur, String mdp);
}
