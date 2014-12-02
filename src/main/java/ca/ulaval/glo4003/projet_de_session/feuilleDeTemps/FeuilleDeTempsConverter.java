package ca.ulaval.glo4003.projet_de_session.feuilleDeTemps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.tempsParTache.TempsParTache;
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
		
		viewModel.defDebutPeriode(formatter.format(entry.obtDebut()));
		viewModel.defFinPeriode(formatter.format(entry.obtFin()));
		viewModel.defEmploye(entry.obtIdentifiant());
		
		viewModel.defTaches(convertTempsParTache(entry.obtTaches()));
		viewModel.commentaires = entry.obtCommentaires();

		return viewModel;
	}
	
	public FeuilleDeTemps convert(FeuilleDeTempsViewModel entry) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date debut = new Date();
		Date fin = new Date();
		try {
			debut = formatter.parse(entry.debutPeriode);
			fin = formatter.parse(entry.finPeriode);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		FeuilleDeTemps feuilleDeTemps = (new FactoryFeuilleDeTemps()).creerFeuilleDeTemps(entry.employe, debut, fin);
		feuilleDeTemps.setTaches(convertTempsParTacheViewModel(entry.obtTaches()));
		feuilleDeTemps.setCommentaires(entry.commentaires);
		
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
