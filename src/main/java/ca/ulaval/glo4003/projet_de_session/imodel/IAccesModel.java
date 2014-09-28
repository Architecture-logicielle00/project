package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

public interface IAccesModel {
	public Boolean identificationValide(String _nomUtilisateur, String _mdp);
	public void creerUtilisateur(String _nomUtilisateurNouveauCompte, String _mdp);
	public void sauvegarderFeuilleDeTemps(String _nomUtilisateur, FeuilleDeTempsViewModel feuilleDeTemps);
	public void creerUtilisateur(EmployeViewModel _nouveauUtilisateur);
}
