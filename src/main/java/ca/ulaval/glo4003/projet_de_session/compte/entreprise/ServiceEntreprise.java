package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementConverter;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.FactoryProjet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;
import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceEntreprise {
	Repository<Entreprise> repo;
	FactoryEntreprise factory;
	DepartementConverter departementConverter;
	
	@Autowired
	ServiceEmploye serviceEmploye;
	
	public ServiceEntreprise()
	{
		repo = FactoryRepository.cree(Entreprise.class);
		factory = new FactoryEntreprise();
		departementConverter = new DepartementConverter();
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
		
		return departementConverter.convertDeparmentementToViewModel(departement);
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
		 
		repo.ajouter(e1);
		
	}
	
}
