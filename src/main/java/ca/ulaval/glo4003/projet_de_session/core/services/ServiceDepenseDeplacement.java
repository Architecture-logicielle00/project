package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.DepenseDeplacementConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class ServiceDepenseDeplacement {

	Repository<DepenseDeplacement> repo;
	FactoryDepenseDeplacement factory;
	DepenseDeplacementConverter conv;

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
		List<DepenseDeplacement> collection = obtTout();
		
		List<DepenseDeplacement> collectionFiltre = new ArrayList<DepenseDeplacement>();
		
		
		for (DepenseDeplacement depenseDeplacement : collection) {
			if(depenseDeplacement.obtIdentifant() == utilisateur)
				collectionFiltre.add(depenseDeplacement);
		}
		
		return (List<DepenseDeplacementViewModel>) conv.convert(collection);
		
		
	}
	
	public Collection<DepenseDeplacementViewModel> obtDepenseDeplacementViewModel() {
		return conv.convert(obtTout());
	}

}
