package ca.ulaval.glo4003.projet_de_session.depense.diverse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceDepenseDiverse {

	Repository<DepenseDiverse> repo;
	FactoryDepenseDiverse factory;
	DepenseDiverseConverter conv;

	public ServiceDepenseDiverse() {
		factory = new FactoryDepenseDiverse();
		repo = FactoryRepository.cree(DepenseDiverse.class);
		conv = new DepenseDiverseConverter();
	}

	public DepenseDiverseViewModel obtenir(String id) {
		return conv.convert(repo.obt(id));
	}

	public void creer(DepenseDiverseViewModel v) {
		DepenseDiverse d = conv.convert(v);
		repo.ajouter(d);
	}

	public void modifier(DepenseDiverseViewModel depense) {
		repo.modifier(conv.convert(depense));
	}

	private List<DepenseDiverse> obtTout() {
		return repo.obtTout();
	}
	
	public List<DepenseDiverseViewModel> obtParUtilisateur(String utilisateur) {
		List<DepenseDiverse> collection = obtTout();
		
		List<DepenseDiverse> collectionFiltre = new ArrayList<DepenseDiverse>();
		
		
		for (DepenseDiverse depensediverse : collection) {
			if(depensediverse.identifiantEstEgal(utilisateur))
				collectionFiltre.add(depensediverse);
		}
		
		return (List<DepenseDiverseViewModel>) conv.convert(collectionFiltre);
		
		
	}
	
	public Collection<DepenseDiverseViewModel> obtDepensediverseViewModel() {
		return conv.convert(obtTout());
	}

}
