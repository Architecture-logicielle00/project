package ca.ulaval.glo4003.projet_de_session.core.services;

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

	public DepenseDeplacement obtenir(String identifiant) {
		return repo.obt(identifiant);
	}

	public void creer(DepenseDeplacementViewModel v) {
		DepenseDeplacement d = factory.creer(v);
		repo.ajouter(d);
	}

	public void modifier(DepenseDeplacement depense) {
		repo.modifier(depense);
	}

	public List<DepenseDeplacement> obtTout() {
		return repo.obtTout();
	}
	
	public Collection<DepenseDeplacementViewModel> obtDepenseDeplacementViewModel() {
		return conv.convert(obtTout());
	}
	public void defDepenseDeplacement(DepenseDeplacementViewModel v) {
		DepenseDeplacement d = obtenir(v.identifiant);

//		d.defDate(v.date);
//		d.defCoutKm(v.coutkm);
//		d.defDistance(v.distance);
//		d.defDescription(v.description);
		

	}

}
