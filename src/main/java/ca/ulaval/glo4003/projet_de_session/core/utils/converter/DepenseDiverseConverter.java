package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
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
		viewModel.date = depense.obtDate();
		viewModel.description = depense.obtDescription();
		viewModel.identifiant = depense.obtIdentifant();
		viewModel.nbRepas = depense.obtNbRepas();
		viewModel.divers = depense.obtDivers();
		viewModel.sousTotal = depense.obtSoutTotal();
		viewModel.total = depense.obtTotal();

		return viewModel;
	}
}
