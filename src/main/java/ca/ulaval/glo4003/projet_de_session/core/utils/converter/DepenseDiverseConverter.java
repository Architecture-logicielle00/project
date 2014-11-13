package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.ArrayList;
import java.util.Collection;
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
		viewModel.date = depense.obtDate().toString();
		viewModel.description = depense.obtDescription();
		viewModel.identifiant = depense.obtIdentifiant();
		viewModel.nbRepas = depense.obtNbRepas();
		viewModel.divers = depense.obtDivers();

		return viewModel;
	}
	
	public DepenseDiverse convert(DepenseDiverseViewModel diverseViewModel) {
		DepenseDiverse diverse = new DepenseDiverse();
		diverse.defCoucher(diverseViewModel.coucher);
		diverse.defCoutRepas(diverseViewModel.coutRepas);
		diverse.defDate(diverseViewModel.date);
		diverse.defDescription(diverseViewModel.description);
		diverse.defIdentifiant(diverseViewModel.identifiant);
		diverse.defNbRepas(diverseViewModel.nbRepas);
		diverse.defDivers(diverseViewModel.divers);
		diverse.defTime(diverseViewModel.time);
		return diverse;
	}
}
