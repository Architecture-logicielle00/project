package ca.ulaval.glo4003.projet_de_session.old;

import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;

public class FakeIdentificateur implements IIdentificateur 
{

	private IRepositoryUtilisateur repoUtilisateur;
	
	public FakeIdentificateur() 
	{
		repoUtilisateur = new RepositoryUtilisateur();
	}
	
	@Override
	public boolean connectionValide(String nomUtilisateur, String mdp) 
	{
		Utilisateur utilisateur = repoUtilisateur.obtenirParNom(nomUtilisateur);
		
		return utilisateur != null ? utilisateur.motDePasseValide(mdp) : false;
	}
}
