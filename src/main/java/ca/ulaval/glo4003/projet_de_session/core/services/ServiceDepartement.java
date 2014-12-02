package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.core.domain.Departement;
import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.Projet;
import ca.ulaval.glo4003.projet_de_session.core.domain.Tache;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryDepartement;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.DepartementConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeTachesViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.ProjetTachesViewModel;

public class ServiceDepartement {
	private Repository<Departement> repository;
	private Repository<Projet> repositoryProjet;
	private FactoryDepartement factory;
	private DepartementConverter converter;
	
	public ServiceDepartement(){
		factory = new FactoryDepartement();
		repository= FactoryRepository.cree(Departement.class);
		repositoryProjet= FactoryRepository.cree(Projet.class);
		converter = new DepartementConverter();
		
	}
	
	public String createDepartement(String _nomDepartement, String _nomEntreprise, ArrayList<String> _projets) {
		Departement d = factory.creerDepartement( _nomDepartement, _nomEntreprise, _projets);
		return repository.ajouter(d);
	}
	
	public DepartementViewModel obtDepartementViewModel(String id) {
		return converter.convertDep(obtDepartement(id));
	}
	
	public Collection<DepartementViewModel> obtDepartementViewModels() {
		return converter.convertDeps(obtDepartements());
	}
	
	private Departement obtDepartement(String id) {
		return repository.obt(id);
	}
	
	private Map<String, Departement> obtDepartements() {
		return repository.obtMap();
	}
	
	public void deleteDepartement(String id) {
		repository.supprimer(id);
	}
	
	private void updateDepartement(String id, Departement departement) {
		repository.modifier(id, departement);
	}
	
	public void updateDepartement(DepartementViewModel departementViewModel) {
		Departement departement = converter
				.convertDep(departementViewModel);
		String id = departement.obtNomDepartement() +
				departement.obtEntreprise();
		updateDepartement(id, departement);
	}
	
	public ArrayList<Projet> obtProjetParDepartement(String id) {
		ArrayList<Projet> projets = new ArrayList<Projet>();
		for(String nomProjet:obtDepartement(id).obtProjets()){
			for(Projet projet:repositoryProjet.obtTout()){
				if(projet.obtNom()== nomProjet){
					projets.add(projet);
				}
			}	
		}
		
		return projets;
	}
	
	public ArrayList<ProjetTachesViewModel> obtProjetTachesViewModelParDepartement(String id) {
		ArrayList<Projet> projets=new ArrayList<Projet>();
		ArrayList<ProjetTachesViewModel> ProjetTachesViewModels=new ArrayList<ProjetTachesViewModel>();
		projets=obtProjetParDepartement(id);
		for(Projet projet:projets){
			ProjetTachesViewModels.add(obtProjetTacheViewModel(projet));
		}
		return ProjetTachesViewModels;
	}
	
	public ProjetTachesViewModel obtProjetTacheViewModel(Projet projet) {
		ProjetTachesViewModel viewModel=new ProjetTachesViewModel(); 
		viewModel.setNomProjet(projet.obtNom());
		for(Tache tache:projet.obtTache()){
			viewModel.obtNomTaches().add(tache.obtNom());
		}
		return viewModel;
	}
	
	public ArrayList<Employe> obtEmployesParDepartement(String id) {
		return obtDepartement(id).obtEmployes();
	}
	
	public EmployeTachesViewModel obtEmployeTachesViewModel(Employe employe) {
		EmployeTachesViewModel viewModel=new EmployeTachesViewModel(); 
		viewModel.setNomEmploye(employe.obtNomUtilisateur());
		for(String tache:employe.obtTaches()){
			viewModel.obtNomTaches().add(tache);
		}
		return viewModel;
	}
	
	public ArrayList<EmployeTachesViewModel> obtEmployeTachesViewModelParDepartement(String id) {
		ArrayList<Employe> employes=new ArrayList<Employe>();
		ArrayList<EmployeTachesViewModel> EmployesTachesViewModels=new ArrayList<EmployeTachesViewModel>();
		employes=obtEmployesParDepartement(id);
		for(Employe employe:employes){
			EmployesTachesViewModels.add(obtEmployeTachesViewModel(employe));
		}
		return EmployesTachesViewModels;
		
	}

}


		

