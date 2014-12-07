package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;


public class DepartementViewModel {
	public String nomDepartement;
	public ArrayList<ProjetViewModel> projetsViewModel;
	public ArrayList<EmployeTachesViewModel> employesTachesViewModels;
	
	public String getNomDepartement(){return nomDepartement;}
	public ArrayList<ProjetViewModel> getProjetsViewModel(){return projetsViewModel;}
	public ArrayList<EmployeTachesViewModel> getEmployeTachesViewModel(){return employesTachesViewModels;}

	public void setNomDepartement(String _nomDepartement){nomDepartement = _nomDepartement;}
	public void setProjetsViewModel(ArrayList<ProjetViewModel> _projetsViewModel){projetsViewModel = _projetsViewModel;}
	public void setEmployeTachesViewModel(ArrayList<EmployeTachesViewModel> _employesTachesViewModels){employesTachesViewModels = _employesTachesViewModels;}	
}
