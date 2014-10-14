//package ca.ulaval.glo4003.projet_de_session.core.utils.converter;
//
//import java.util.Collection;
//import java.util.LinkedList;
//import java.util.List;
//
//import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
//import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
//import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
//import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;
//import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;
//
//public class DepenseDeplacementConverter {
//
//	public Collection<DepenseDeplacementViewModel> convert(
//			List<DepenseDeplacement> entries) {
//		Collection<DepenseDeplacementViewModel> viewModels = new LinkedList<DepenseDeplacementViewModel>();
//		for (Depense entry : entries) {
//			DepenseDeplacementViewModel viewModel = convert((DepenseDeplacement) entry);
//			viewModels.add(viewModel);
//		}
//		return viewModels;
//	}
//
//	public DepenseDeplacementViewModel convert(DepenseDeplacement entry) {
//			DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
//			viewModel.coutkm= entry.obtCoutKm();
//			viewModel.distance = entry.obtDistance();
//			viewModel.description = entry.obtDescription();
//			viewModel.indentifiant = entry.obtIdentifant();
//			viewModel.date = entry.obtDate();
//			viewModel.sousTotal = entry.obtSoutTotal();
//			
//			
//		
//			return viewModel;
//		}
//}
