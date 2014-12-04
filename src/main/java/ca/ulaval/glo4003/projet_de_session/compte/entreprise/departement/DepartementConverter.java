package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.FactoryProjet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;
public class DepartementConverter {
	@Autowired
	ServiceEmploye serviceEmploye;
	
	public DepartementViewModel convertDeparmentementToViewModel(Departement departement)
	{
		DepartementViewModel departementViewModel = new DepartementViewModel();
		
		List<ProjetViewModel> projetViewModels = getProjetViewModels(departement);
		List<EmployeTachesViewModel> employeTachesViewModels = getEmployeTachesViewModels(departement);
		
		departementViewModel.nomDepartement = departement.obtNomDepartement();
		departementViewModel.projetsViewModel = projetViewModels;
		departementViewModel.employesTachesViewModels = employeTachesViewModels;
		
		return departementViewModel;
	}
	
	private List<ProjetViewModel> getProjetViewModels(Departement departement)
	{
		List<ProjetViewModel> projetViewModels = new ArrayList<ProjetViewModel>();
		List<Projet> projets =  departement.obtProjets();
		for(Projet projet: projets)
		{
			List<Tache> taches = projet.obtTache();
			List<String> listeNomTache = new ArrayList<String>();
			for(Tache tache: taches)
			{
				listeNomTache.add(tache.obtNom());
			}
			ProjetViewModel pvm = new ProjetViewModel(projet.obtNom(), listeNomTache);
			projetViewModels.add(pvm);
		}
		
		return projetViewModels;
	}
	
	private List<EmployeTachesViewModel> getEmployeTachesViewModels(Departement departement)
	{
		List<EmployeTachesViewModel> employeTachesViewModels = new ArrayList<EmployeTachesViewModel>();
		List<String> nomUtilisateurEmployes = departement.obtEmployes();
		for(String nomUtilisateurEmploye : nomUtilisateurEmployes)
		{
			//remove gestionnaire
			Employe employe = serviceEmploye.obtEmploye(nomUtilisateurEmploye);
			String nom = employe.obtPrenom() + " " + employe.obtNom();
			List<String> tache = employe.obtTaches();
			employeTachesViewModels.add(new EmployeTachesViewModel(nomUtilisateurEmploye, nom, tache));
			
		}
		return employeTachesViewModels;
	}
}
