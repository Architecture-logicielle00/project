package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;


public class DepartementViewModel {
	public String nomDepartement;
	public ArrayList<ProjetViewModel> projetsViewModel;
	public ArrayList<EmployeTachesViewModel> employesTachesViewModels;	
}
