package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

public interface IAccesModel {
	public Boolean IdentificationValide(String _nomUtilisateur, String _mdp);
	public void CreerUtilisateur(String _nomUtilisateurNouveauCompte, String _mdp);
	public void SauvegarderFeuilleDeTemps(String _nomUtilisateur, FeuilleDeTempsViewModel feuilleDeTemps);
}
