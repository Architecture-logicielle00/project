package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeViewModel;
public class DepartementConverter {
		
	public Collection<DepartementViewModel> convertDeps(Map<String, Departement> entries) {
		Collection<DepartementViewModel> viewModels = new LinkedList<DepartementViewModel>();
		for (Entry<String, Departement> entry : entries.entrySet()) {
			DepartementViewModel viewModel = convertDep(entry.getValue());
			viewModels.add(viewModel);
		}
		return viewModels;
	}

	public DepartementViewModel convertDep(Departement entry) {
		DepartementViewModel viewModel = new DepartementViewModel();
		viewModel.setNomDepartement(entry.obtNomDepartement());
		viewModel.setNomEntreprise(entry.obtEntreprise());
		viewModel.setProjets(entry.obtProjets());
		viewModel.setEmployes((ArrayList<EmployeeViewModel>) EmployeeConverter.convert(entry.obtEmployes()));
		return viewModel;//(ArrayList<EmployeeViewModel>) 
	}
	
	public Departement convertDep(DepartementViewModel viewModel) {
		Departement departement = new Departement();
		departement.setNomDepartement(viewModel.obtNomDepartement());
		departement.setEntreprise(viewModel.obtNomEntreprise());
		departement.setProjets(viewModel.obtProjets());
		ArrayList<EmployeeViewModel> entries= new ArrayList<EmployeeViewModel>();
		entries=viewModel.obtEmployes();
		ArrayList<Employe> employes= new ArrayList<Employe>();
		for (EmployeeViewModel entry : entries) {
			Employe employe = (new EmployeeConverter()).convert(entry);
			employes.add(employe);
		}
		departement.setEmployes(employes);
		return departement;
	}
	
}
