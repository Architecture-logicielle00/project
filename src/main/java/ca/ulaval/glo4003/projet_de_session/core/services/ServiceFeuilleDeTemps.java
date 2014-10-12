package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoFeuilleDeTempsXml;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

public class ServiceFeuilleDeTemps {
	
	RepoFeuilleDeTemps repository;
	FactoryFeuilleDeTemps factory;
	FeuilleDeTempsConverter converter;

	public ServiceFeuilleDeTemps() {
		factory = new FactoryFeuilleDeTemps();
		repository = new RepoFeuilleDeTempsXml();
		converter = new FeuilleDeTempsConverter();
	}

	public FeuilleDeTemps obtFeuilleDeTemps(String id) {
		return repository.obtenir(id);
	}

	public void suppFeuilleDeTemps(String id) {
		repository.supprimer(id);
	}

	public void creerFeuilleDeTemps(Employe _employe, Date _debut, Date _fin) {
		FeuilleDeTemps e = factory.creerFeuilleDeTemps(_employe, _debut, _fin);
		repository.ajouter(e);
	}

	public void modifierFeuilleDeTemps(String id, FeuilleDeTemps feuilleDeTemps) {
		repository.modifier(id, feuilleDeTemps);
	}

	public void modifierFeuilleDeTemps(FeuilleDeTempsViewModel feuilleDeTempsViewModel) {
		FeuilleDeTemps feuilleDeTemps = converter
				.convert(feuilleDeTempsViewModel);
		
		String id = feuilleDeTemps.obtNomEmploye()
				+ feuilleDeTemps.obtDebut().toString()
				+ feuilleDeTemps.obtFin().toString();

		repository.modifier(id, feuilleDeTemps);
	}

	public Map<String, FeuilleDeTemps> obtFeuillesDeTemps() {
		return repository.obtTout();
	}

	public Collection<FeuilleDeTempsViewModel> obtFeuillesDeTempsViewModel() {
		return converter.convert(obtFeuillesDeTemps());
	}

	public FeuilleDeTempsViewModel obtFeuilleDeTempsViewModel(String id) {
		return converter.convert(obtFeuilleDeTemps(id));
	}
}
