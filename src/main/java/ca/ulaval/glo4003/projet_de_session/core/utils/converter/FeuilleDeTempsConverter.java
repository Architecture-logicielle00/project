package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;


public class FeuilleDeTempsConverter {

	public Collection<FeuilleDeTempsViewModel> convert(List<FeuilleDeTemps> entries) {
		Collection<FeuilleDeTempsViewModel> viewModels = new LinkedList<FeuilleDeTempsViewModel>();
		for (FeuilleDeTemps entry : entries) {
			FeuilleDeTempsViewModel viewModel = convert((FeuilleDeTemps)entry);
			viewModel.id= entry.obtIndex();
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public FeuilleDeTempsViewModel convert(FeuilleDeTemps entry) {
		FeuilleDeTempsViewModel viewModel = new FeuilleDeTempsViewModel();
		viewModel.defDebutPeriode(entry.obtDebut().toString());
		viewModel.defFinPeriode(entry.obtFin().toString());
		viewModel.defEmploye(entry.obtNomEmploye());
		viewModel.defTaches(entry.obtTaches());

		return viewModel;
	}
	
	public FeuilleDeTemps convert(FeuilleDeTempsViewModel entry) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps();
		try {
			feuilleDeTemps.defDebut(formatter.parse(entry.debutPeriode));
			feuilleDeTemps.defFin(formatter.parse(entry.finPeriode));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		feuilleDeTemps.defNomEmploye(entry.employe);
		feuilleDeTemps.defTaches(entry.taches);
		
		return feuilleDeTemps;
	}
}
