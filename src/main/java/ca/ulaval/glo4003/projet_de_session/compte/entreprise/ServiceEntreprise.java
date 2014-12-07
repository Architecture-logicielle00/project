package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.FactoryProjet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;
import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceEntreprise {
	Repository<Entreprise> repo;
	FactoryEntreprise factory;
	
	@Autowired
	ServiceEmploye serviceEmploye;
	
	public ServiceEntreprise(Repository<Entreprise> repo,FactoryEntreprise factory){
		repo = FactoryRepository.cree(Entreprise.class);
		factory = new FactoryEntreprise();		
	}
	
	public ServiceEntreprise(){
		repo = FactoryRepository.cree(Entreprise.class);
		factory = new FactoryEntreprise();	
		init();
	}
	
	public Entreprise obtEntreprise(String nomUtilisateur){
		return repo.obt(nomUtilisateur);
	}
	
	public DepartementViewModel getDepartementViewModelParEmploye(String nomGestionnaire)
	{
		Employe gestionnaire = serviceEmploye.obtEmploye(nomGestionnaire);
		
		String nomEntreprise = gestionnaire.obtEntreprise();
		Entreprise entreprise = obtEntreprise(nomEntreprise);
		Departement departement = entreprise.getDepartementParEmploye(nomGestionnaire);
		
		return getDepartementementViewModel(departement);
	}
	
	
	private DepartementViewModel getDepartementementViewModel(Departement departement)
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
			Employe employe = serviceEmploye.obtEmploye(nomUtilisateurEmploye);
			String nom = employe.obtPrenom() + " " + employe.obtNom();
			List<String> tache = employe.obtTaches();
			employeTachesViewModels.add(new EmployeTachesViewModel(nomUtilisateurEmploye, nom, tache));
			
		}
		return employeTachesViewModels;
	}
	
	public void ajouterEmploye(String nomUtilisateur)
	{
		Employe employe = serviceEmploye.obtEmploye(nomUtilisateur);
		repo.obt( employe.obtEntreprise() ).getDepartement( employe.obtDepartement() ).ajouterEmploye(nomUtilisateur);;	
	}
	
	private Entreprise obtenirEntreprise(String nom)
	{
		return repo.obt(nom);
	}
	
	private void init()
	{
		FactoryProjet fp = new FactoryProjet();
		Entreprise e1 = factory.creerEntreprise("desj", "12345", "Desjardins");
		Departement servicePersonnel = e1.createDepartement("Service personnel");
		
		Projet marketing = fp.creerProjet("Marketing");
		marketing.ajouterTache( new Tache("Telemarketing", "Appeller les clients pour proposer des services") );
		marketing.ajouterTache( new Tache("Journal", "Faire un publicité pour des journaux") );
		servicePersonnel.ajouterProjet(marketing);
		
		Projet serviceALaClientele = fp.creerProjet("Service a la clientele");
		serviceALaClientele.ajouterTache( new Tache("Caisse", "Répondre au client a la caisse") );
		serviceALaClientele.ajouterTache( new Tache("Pret personnel", "Accorder ou non des prets") );
		servicePersonnel.ajouterProjet(serviceALaClientele);
		
		servicePersonnel.ajouterEmploye("OLDU");
		 
		repo.ajouter(e1);
	}
}
