package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;


public class DepartementViewModel {
	public String nomDepartement;
	public List<ProjetViewModel> projetsViewModel;
	public List<EmployeTachesViewModel> employesTachesViewModels;
	
	public DepartementViewModel()
	{
		this.nomDepartement = "";
		this.projetsViewModel = new ArrayList<ProjetViewModel>();
		this.employesTachesViewModels = new ArrayList<EmployeTachesViewModel>();
	}
	
	public DepartementViewModel(String nomDepartement, List<ProjetViewModel> projetsViewModel, List<EmployeTachesViewModel> employesTachesViewModels)
	{
		this.nomDepartement = nomDepartement;
		this.projetsViewModel = projetsViewModel;
		this.employesTachesViewModels = employesTachesViewModels;
	}
	
	
	
}
