package ca.ulaval.glo4003.projet_de_session.old;

import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

public interface IAccesModel {
	public Boolean identificationValide(String _nomUtilisateur, String _mdp);
	
	public void creerUtilisateur(Utilisateur utilisateur);
	
	public void sauvegarderFeuilleDeTemps(String _nomUtilisateur, FeuilleDeTempsViewModel feuilleDeTemps);
	
	public void creerUtilisateur(EmployeeViewModel _nouveauUtilisateur);
}
