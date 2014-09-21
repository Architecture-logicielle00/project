package ca.ulaval.glo4003.projet_de_session.mock;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;
import ca.ulval.glo4003.projet_de_session.imodel.IIdentificateur;
import ca.ulval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;

public class FakeIdentificateur implements IIdentificateur 
{

	private IRepositoryUtilisateur repoUtilisateur;
	
	public FakeIdentificateur() 
	{
		repoUtilisateur = new RepositoryUtilisateur();
	}
	
	@Override
	public boolean ConnectionValide(String nomUtilisateur, String mdp) 
	{
		SimpleUtilisateur utilisateur = repoUtilisateur.ObtenirUnUtilisateur(nomUtilisateur);
		
		return utilisateur != null ? utilisateur.MotDePasseValide(mdp) : false;
	}
}
