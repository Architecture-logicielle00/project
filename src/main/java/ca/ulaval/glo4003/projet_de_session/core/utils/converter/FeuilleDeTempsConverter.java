package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

public class FeuilleDeTempsConverter {
	
	public FeuilleDeTempsConverter(){
		blocDeTempsConverter = new BlocDeTempsConverter();
	}
	
	public Collection<FeuilleDeTempsViewModel> convert(Map<Integer, FeuilleDeTemps> entries) {
		Collection<FeuilleDeTempsViewModel> viewModels = new LinkedList<FeuilleDeTempsViewModel>();
		
		for (Entry<Integer, FeuilleDeTemps> entry : entries.entrySet()) {
			FeuilleDeTempsViewModel viewModel = convert(entry.getValue());
			viewModel.id = entry.getKey();
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public FeuilleDeTempsViewModel convert(FeuilleDeTemps entry) {
		FeuilleDeTempsViewModel viewModel = new FeuilleDeTempsViewModel();
		viewModel.blocsDeTemps = blocDeTempsConverter.convert(entry.obtBlocsDeTemps());
		viewModel.debutPeriode = entry.obtDebut();
		viewModel.finPeriode = entry.obtFin();
		return viewModel;
	}
	
	public FeuilleDeTemps convert(FeuilleDeTempsViewModel viewModel) {
		FeuilleDeTemps entry = new FeuilleDeTemps(viewModel.employe, viewModel.debutPeriode, viewModel.finPeriode);
		return entry;
	}
	
	private BlocDeTempsConverter blocDeTempsConverter;
}
