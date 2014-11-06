package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.DepenseDiverseConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

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

	public DepenseDiverse obtenir(String identifiant) {
		return repo.obt(identifiant);
	}

	public void Creer(DepenseDiverseViewModel v) {
		DepenseDiverse d = factory.creer(v);
		repo.ajouter(d);
	}

	public void modifier(DepenseDiverse depense) {
		repo.modifier(depense);
	}

	public List<DepenseDiverse> obtTout() {
		return repo.obtTout();
	}

	public Collection<DepenseDiverseViewModel> obtDepenseDiverseViewModel() {
		return conv.convert(obtTout());
	}

	public void defDepenseDiverse(DepenseDiverseViewModel v) {
		DepenseDiverse d = obtenir(v.identifiant);

//		d.defDate(v.date);
//		d.defCoutRepas(v.coutRepas);
//		d.defNbRepas(v.nbRepas);
//		d.defCoucher(v.coucher);
//		d.defDivers(v.divers);
//		d.defSousTotal(v.sousTotal);
//		d.defDescription(v.description);
//		d.defTotal(v.total);

}
}