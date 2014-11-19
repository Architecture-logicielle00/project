package ca.ulaval.glo4003.projet_de_session.core.services;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.core.domain.Entreprise;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryEntreprise;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;

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
