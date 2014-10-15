package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

public class DepenseDiverseConverter {

	public Collection<DepenseDiverseViewModel> convert(
			List<DepenseDiverse> entries) {
		Collection<DepenseDiverseViewModel> viewModels = new LinkedList<DepenseDiverseViewModel>();
		for (Depense entry : entries) {
			DepenseDiverseViewModel viewModel = convert((DepenseDiverse) entry);
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	public DepenseDiverseViewModel convert(DepenseDiverse entry) {
		DepenseDiverseViewModel viewModel = new DepenseDiverseViewModel();
		viewModel.coucher = entry.obtCoucher();
		viewModel.coutRepas = entry.obtCoutRepas();
		viewModel.date = entry.obtDate();
		viewModel.description = entry.obtDescription();
		viewModel.indentifiant = entry.obtIdentifant();
		viewModel.nbRepas = entry.obtNbRepas();
		viewModel.divers = entry.obtDivers();
		viewModel.sousTotal = entry.obtSoutTotal();

		return viewModel;
	}

}
