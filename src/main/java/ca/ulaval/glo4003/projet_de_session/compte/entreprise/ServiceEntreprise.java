package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceEntreprise {
	Repository<Entreprise> repo;
	FactoryEntreprise factory;
	
	public ServiceEntreprise()
	{
		repo = FactoryRepository.cree(Entreprise.class);
		factory = new FactoryEntreprise();
		
		init();
	}
	
	public Entreprise obtEntreprise(String nomUtilisateur){
		return repo.obt(nomUtilisateur);
	}
	
	private void init()
	{
		repo.ajouter(factory.creerEntreprise("desj", "12345", "Desjardins"));
		repo.ajouter(factory.creerEntreprise("home", "12345", "Home Depot"));
	}
}
