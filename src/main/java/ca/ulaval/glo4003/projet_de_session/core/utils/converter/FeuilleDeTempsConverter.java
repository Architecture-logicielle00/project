package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.domain.TempsParTache;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.TempsParTacheViewModel;


public class FeuilleDeTempsConverter {

	public Collection<FeuilleDeTempsViewModel> convert(Map<String, FeuilleDeTemps> entries) {
		Collection<FeuilleDeTempsViewModel> viewModels = new LinkedList<FeuilleDeTempsViewModel>();
		for (Entry<String, FeuilleDeTemps> entry : entries.entrySet()) {
			FeuilleDeTempsViewModel viewModel = convert(entry.getValue());
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public FeuilleDeTempsViewModel convert(FeuilleDeTemps entry) {
		FeuilleDeTempsViewModel viewModel = new FeuilleDeTempsViewModel();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		viewModel.defDebutPeriode(formatter.format(entry.getDebut()));
		viewModel.defFinPeriode(formatter.format(entry.getFin()));
		viewModel.defEmploye(entry.getIdentifiant());
		
		viewModel.defTaches(convertTempsParTache(entry.getTaches()));

		return viewModel;
	}
	
	public FeuilleDeTemps convert(FeuilleDeTempsViewModel entry) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps();
		try {
			feuilleDeTemps.setDebut(formatter.parse(entry.debutPeriode));
			feuilleDeTemps.setFin(formatter.parse(entry.finPeriode));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		feuilleDeTemps.setIdentifiant(entry.employe);
		feuilleDeTemps.setTaches(convertTempsParTacheViewModel(entry.obtTaches()));
		
		return feuilleDeTemps;
	}
	
	
	
	private ArrayList<TempsParTacheViewModel> convertTempsParTache(ArrayList<TempsParTache> entries){
		ArrayList<TempsParTacheViewModel> listTempsParTacheViewModel = new ArrayList<TempsParTacheViewModel>();
		
		for (TempsParTache entry : entries) {
			TempsParTacheViewModel tempsParTacheViewModel = convert(entry);
			listTempsParTacheViewModel.add(tempsParTacheViewModel);
		}
		return listTempsParTacheViewModel;
	}
	
	private TempsParTacheViewModel convert(TempsParTache tempsParTache){
		TempsParTacheViewModel tempsParTacheViewModel = new TempsParTacheViewModel();
		tempsParTacheViewModel.defNbHeuresParJours(tempsParTache.obtNbHeuresParJours());
		tempsParTacheViewModel.defTache(tempsParTache.obtTache());
		
		return tempsParTacheViewModel;
	}
	
	private ArrayList<TempsParTache> convertTempsParTacheViewModel(ArrayList<TempsParTacheViewModel> entries){
		ArrayList<TempsParTache> listTempsParTache = new ArrayList<TempsParTache>();
		
		for (TempsParTacheViewModel entry : entries) {
			TempsParTache tempsParTache = convert(entry);
			listTempsParTache.add(tempsParTache);
		}
		return listTempsParTache;
	}
	
	private TempsParTache convert(TempsParTacheViewModel tempsParTacheViewModel){
		TempsParTache tempsParTache = new TempsParTache();
		tempsParTache.defNbHeuresParJours(tempsParTacheViewModel.obtNbHeuresParJours());
		tempsParTache.defTache(tempsParTacheViewModel.obtTache());
		
		return tempsParTache;
	}
}
