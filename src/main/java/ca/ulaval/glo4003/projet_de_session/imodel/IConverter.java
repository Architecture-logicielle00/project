package ca.ulaval.glo4003.projet_de_session.imodel;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

public interface IConverter 
{
	public UserViewModel Convert(Utilisateur utilisateur);
}
