package ca.ulaval.glo4003.projet_de_session.web.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import ca.ulaval.glo4003.projet_de_session.model.BlocDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.BlocDeTempsViewModel;


public class BlocDeTempsConverter {
	
	public ArrayList<BlocDeTempsViewModel> convert(ArrayList<BlocDeTemps> entries) {
		ArrayList<BlocDeTempsViewModel> viewModels = new ArrayList<BlocDeTempsViewModel>();
		
		for (BlocDeTemps entry : entries) {
			BlocDeTempsViewModel viewModel = convert(entry);
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public BlocDeTempsViewModel convert(BlocDeTemps entry) {
		BlocDeTempsViewModel viewModel = new BlocDeTempsViewModel();
		viewModel.numProjet = entry.obtProjet();
		viewModel.numTache = entry.obtTache();
		viewModel.nbHeures = entry.obtNbHeure();
		viewModel.dateDuJour = entry.obtJour().toString();
		return viewModel;
	}
	
	public BlocDeTemps convert(BlocDeTempsViewModel viewModel) {
		BlocDeTemps entry = new BlocDeTemps(viewModel.numProjet, viewModel.numTache, new Date(viewModel.dateDuJour), viewModel.nbHeures);
		return entry;
	}
}
