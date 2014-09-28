package ca.ulaval.glo4003.projet_de_session.web.converters;

import ca.ulaval.glo4003.projet_de_session.imodel.IConverter;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

public class UtilisateurConverter implements IConverter {

	public UtilisateurViewModel convert(Utilisateur utilisateur)
	{
		UtilisateurViewModel viewModel = new UtilisateurViewModel();
		viewModel.nomUtilisateur = utilisateur.obtNomUtilisateur();
		
		return viewModel;
		
	}
}
