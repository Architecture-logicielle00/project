package ca.ulaval.glo4003.projet_de_session.web.converters;

import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

public class UserConverter {

	public static UserViewModel Convert(SimpleUtilisateur utilisateur)
	{
		return new UserViewModel(utilisateur.ObtenirNomUtilisateur());
	}
}
