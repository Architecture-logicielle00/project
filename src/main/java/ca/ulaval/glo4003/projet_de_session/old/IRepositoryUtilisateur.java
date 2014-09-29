package ca.ulaval.glo4003.projet_de_session.old;

import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;

public interface IRepositoryUtilisateur 
{
	public Utilisateur obtenirParNom(String nomUtilisateur);
	public void ajouter(Utilisateur utilisateur);
}
