package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.FeuilleDeTemps;

public interface IRepositoryFeuilleDeTemps 
{
	public FeuilleDeTemps obtenirParUtilisateur(String nomUtilisateur);
	public void AjouterFeuilleDeTemps(String nomUtilisateur, FeuilleDeTemps feuilleDeTemps);
}
