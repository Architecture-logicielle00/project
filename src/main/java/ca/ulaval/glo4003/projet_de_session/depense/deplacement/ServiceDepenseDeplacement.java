package ca.ulaval.glo4003.projet_de_session.depense.deplacement;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceDepenseDeplacement {

	Repository<DepenseDeplacement> repo;
	FactoryDepenseDeplacement factory;
	DepenseDeplacementConverter conv;

	public ServiceDepenseDeplacement(Repository<DepenseDeplacement> repo,
									 FactoryDepenseDeplacement factory,
									 DepenseDeplacementConverter conv) {
		this.repo = repo;
		this.factory = factory;
		this.conv = conv;
	}
	
	public ServiceDepenseDeplacement() {
		factory = new FactoryDepenseDeplacement();
		repo = FactoryRepository.cree(DepenseDeplacement.class);
		conv = new DepenseDeplacementConverter();
	}

	public DepenseDeplacementViewModel obtenir(String id) {
		return conv.convert(repo.obt(id));
	}

	public void creer(DepenseDeplacementViewModel v) {
		DepenseDeplacement d = conv.convert(v);
		repo.ajouter(d);
	}

	public void modifier(DepenseDeplacementViewModel depense) {
		repo.modifier(conv.convert(depense));
	}

	private List<DepenseDeplacement> obtTout() {
		return repo.obtTout();
	}
	
	public List<DepenseDeplacementViewModel> obtParUtilisateur(String utilisateur) {
		List<DepenseDeplacement> collectionComplete = obtTout();
		
		List<DepenseDeplacement> collectionFiltre = new ArrayList<DepenseDeplacement>();
		
		
		for (DepenseDeplacement depenseDeplacement : collectionComplete) {
			if(depenseDeplacement.estSoumissionnaire(utilisateur))
				collectionFiltre.add(depenseDeplacement);
		}
		
		return (List<DepenseDeplacementViewModel>) conv.convert(collectionFiltre);
		
		
	}
	
	public Collection<DepenseDeplacementViewModel> obtDepenseDeplacementViewModel() {
		return conv.convert(obtTout());
	}

}
