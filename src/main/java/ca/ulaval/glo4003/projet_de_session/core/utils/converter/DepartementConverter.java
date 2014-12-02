package ca.ulaval.glo4003.projet_de_session.core.utils.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Departement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.EmployeeConverter;
public class DepartementConverter {
		
	public Collection<DepartementViewModel> convertDeps(List<Departement> entries) {
		Collection<DepartementViewModel> viewModels = new LinkedList<DepartementViewModel>();
		for (Departement entry : entries) {
			DepartementViewModel viewModel = convertDep((Departement) entry);
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	private DepartementViewModel convertDep(Departement entry) {
		DepartementViewModel viewModel = new DepartementViewModel();
		viewModel.setNomDepartement(entry.obtNomDepartement());
		viewModel.setNomEntreprise(entry.obtEntreprise());
		viewModel.setProjets(entry.obtProjets());
		viewModel.setEmployes((ArrayList<EmployeeViewModel>) EmployeeConverter.convert(entry.obtEmployes()));

		
		return viewModel;
	}
	
}
