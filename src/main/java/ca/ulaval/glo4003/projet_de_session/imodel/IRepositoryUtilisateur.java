package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

public interface IRepositoryUtilisateur 
{
	public Utilisateur obtenirUnUtilisateur(String nomUtilisateur);
	public void ajouterUtilisateur(String nomUtilisateur, String mdp);
}
