package ca.ulaval.glo4003.projet_de_session.core.utils.converter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class DepenseDeplacementConverter {
	
	private SimpleDateFormat dateFormatter;
	
	public DepenseDeplacementConverter(){
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	}

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
		viewModel.description = depense.obtDescription();
		viewModel.identifiant = depense.obtIdentifant();
		viewModel.date = dateFormatter.format(depense.obtDate());
		viewModel.time = depense.obtTime();
		
		return viewModel;
	}
	
	public DepenseDeplacement convert(DepenseDeplacementViewModel deplacementViewModel) {
		DepenseDeplacement deplacement = new DepenseDeplacement();
		deplacement.defCoutKm(deplacementViewModel.coutKm);
		deplacement.defDistance(deplacementViewModel.distance);
		deplacement.defIdentifiant(deplacementViewModel.identifiant);
		deplacement.defDescription(deplacementViewModel.description);
		
		try {
			deplacement.defDate(dateFormatter.parse(deplacementViewModel.date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		deplacement.defTime(deplacementViewModel.time);
		return deplacement;
	}
}
