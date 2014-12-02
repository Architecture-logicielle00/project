package ca.ulaval.glo4003.projet_de_session.depense.diverse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.depense.Depense;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

public class DepenseDiverseConverter {

	public Collection<DepenseDiverseViewModel> convert(
			List<DepenseDiverse> depenses) {
		Collection<DepenseDiverseViewModel> viewModels = new ArrayList<DepenseDiverseViewModel>();
		for (Depense depense : depenses) {
			DepenseDiverseViewModel viewModel = convert((DepenseDiverse) depense);
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	public DepenseDiverseViewModel convert(DepenseDiverse depense) {
		DepenseDiverseViewModel viewModel = new DepenseDiverseViewModel();
		viewModel.coucher = depense.obtCoucher();
		viewModel.coutRepas = depense.obtCoutRepas();
		viewModel.date = depense.obtDate().toString();
		viewModel.description = depense.obtDescription();
		viewModel.identifiant = depense.obtIdentifiant();
		viewModel.nbRepas = depense.obtNbRepas();
		viewModel.divers = depense.obtDivers();

		return viewModel;
	}
	
	public DepenseDiverse convert(DepenseDiverseViewModel diverseViewModel) {
		return (new FactoryDepenseDiverse()).creer(diverseViewModel.identifiant,
				diverseViewModel.date, diverseViewModel.time, diverseViewModel.description,
				diverseViewModel.nbRepas, diverseViewModel.coutRepas, diverseViewModel.divers,
				diverseViewModel.coucher);
	}
}
