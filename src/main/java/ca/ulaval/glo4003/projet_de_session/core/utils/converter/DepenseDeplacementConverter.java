package ca.ulaval.glo4003.projet_de_session.core.utils.converter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class DepenseDeplacementConverter {

	public Collection<DepenseDeplacementViewModel> convert(
			List<DepenseDeplacement> depenses) {
		Collection<DepenseDeplacementViewModel> viewModels = new ArrayList<DepenseDeplacementViewModel>();
		for (Depense depense : depenses) {
			DepenseDeplacementViewModel viewModel = convert((DepenseDeplacement) depense);
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	public DepenseDeplacementViewModel convert(DepenseDeplacement depense) {
		DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
		viewModel.coutKm = depense.obtCoutKm();
		viewModel.distance = depense.obtDistance();
		viewModel.description = depense.getDescription();
		viewModel.identifiant = depense.getIdentifant();
		viewModel.date = depense.getDate();
		viewModel.time = depense.getTime();
		
		return viewModel;
	}
	
	public DepenseDeplacement convert(DepenseDeplacementViewModel deplacementViewModel) {
		DepenseDeplacement deplacement = new DepenseDeplacement();
		deplacement.defCoutKm(deplacementViewModel.coutKm);
		deplacement.defDistance(deplacementViewModel.distance);
		deplacement.setIdentifiant(deplacementViewModel.identifiant);
		deplacement.setDescription(deplacementViewModel.description);
		deplacement.setDate(deplacementViewModel.date);

		
		deplacement.setTime(deplacementViewModel.time);
		return deplacement;
	}
}
