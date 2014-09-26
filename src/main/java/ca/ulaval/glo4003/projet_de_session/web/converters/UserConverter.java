package ca.ulaval.glo4003.projet_de_session.web.converters;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

public class UserConverter {

	public static UserViewModel Convert(Utilisateur utilisateur)
	{
		return new UserViewModel(utilisateur.ObtenirNomUtilisateur());
	}
}
