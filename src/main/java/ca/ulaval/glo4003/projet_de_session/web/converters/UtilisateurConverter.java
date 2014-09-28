package ca.ulaval.glo4003.projet_de_session.web.converters;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

public class UtilisateurConverter {

	public static UtilisateurViewModel convert(Utilisateur utilisateur)
	{
		return new UtilisateurViewModel(utilisateur.obtenirNomUtilisateur());
	}
}
