package ca.ulaval.glo4003.projet_de_session.old;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;

public interface IRepositoryFeuilleDeTemps 
{
	public FeuilleDeTemps obtenirParUtilisateur(String nomUtilisateur);
	public void ajouterFeuilleDeTemps(String nomUtilisateur, FeuilleDeTemps feuilleDeTemps);
}