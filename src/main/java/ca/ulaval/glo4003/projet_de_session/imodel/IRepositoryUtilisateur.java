package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

public interface IRepositoryUtilisateur 
{
	public Utilisateur obtenirParNom(String nomUtilisateur);
	public void ajouter(Utilisateur utilisateur);
}
