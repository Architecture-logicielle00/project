package ca.ulaval.glo4003.projet_de_session.mock;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IIdentificateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

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
