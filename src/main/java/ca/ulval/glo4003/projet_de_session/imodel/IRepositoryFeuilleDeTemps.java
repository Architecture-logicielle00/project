package ca.ulval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.FeuilleDeTemps;

public interface IRepositoryFeuilleDeTemps 
{
	public FeuilleDeTemps ObtenirUnFeuilleDeTemps(String nomUtilisateur);
	public void AjouterFeuilleDeTemps(String nomUtilisateur, String mdp);
}
