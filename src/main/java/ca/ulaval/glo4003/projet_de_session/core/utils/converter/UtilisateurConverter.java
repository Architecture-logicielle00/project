package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

public class UtilisateurConverter implements IConverter {

	public UtilisateurViewModel convert(Utilisateur utilisateur)
	{
		UtilisateurViewModel viewModel = new UtilisateurViewModel();
		viewModel.nomUtilisateur = utilisateur.obtNomUtilisateur();
		
		return viewModel;
		
	}
}
