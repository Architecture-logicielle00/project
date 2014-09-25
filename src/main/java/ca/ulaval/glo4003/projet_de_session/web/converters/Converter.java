package ca.ulaval.glo4003.projet_de_session.web.converters;

import ca.ulaval.glo4003.projet_de_session.imodel.IConverter;
import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

public class Converter implements IConverter {
	
	public UserViewModel Convert(SimpleUtilisateur utilisateur)
	{
		return UserConverter.Convert(utilisateur);
	}
}
