package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;
import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceDepartement {
	/*
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
	
	//Service
	public String createDepartement(String _nomDepartement, ArrayList<String> _projets) {
		Departement d = factory.creerDepartement( _nomDepartement);
		return repository.ajouter(d);
	}
	
	//Service
	public DepartementViewModel obtDepartementViewModel(String id) {
		return converter.convertDep(obtDepartement(id));
	}
	
	//Service
	public Collection<DepartementViewModel> obtDepartementViewModels() {
		return converter.convertDeps(obtDepartements());
	}
	
	//Service et 
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
	
	public ProjetTachesViewModel obtProjetTacheViewModel(Projet projet) {
		ProjetTachesViewModel viewModel=new ProjetTachesViewModel(); 
		viewModel.setNomProjet(projet.obtNom());
		for(Tache tache:projet.obtTache()){
			viewModel.obtNomTaches().add(tache.obtNom());
		}
		return viewModel;
	}
	
	public List<String> obtEmployesParDepartement(String id) {
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
	
	/*
	public List<EmployeTachesViewModel> obtEmployeTachesViewModelParDepartement(String id) {
		List<Employe> employes=new ArrayList<Employe>();
		List<EmployeTachesViewModel> EmployesTachesViewModels=new ArrayList<EmployeTachesViewModel>();
		employes=obtEmployesParDepartement(id);
		for(Employe employe:employes){
			EmployesTachesViewModels.add(obtEmployeTachesViewModel(employe));
		}
		return EmployesTachesViewModels;
		
	}
	*/

}


		

