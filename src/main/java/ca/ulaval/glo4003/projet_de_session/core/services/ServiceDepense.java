package ca.ulaval.glo4003.projet_de_session.core.services;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoDepenseDeplacementXml;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoDepenseDiverseXml;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;



public class ServiceDepense {

	private RepoDepenseDiverse repoDepense;
	private RepoDepenseDeplacement repoDepenseDeux;
	private FactoryDepenseDiverse factoryA;
	private FactoryDepenseDeplacement factoryB;

	public ServiceDepense() {
		repoDepense = new RepoDepenseDiverseXml();
		repoDepenseDeux = new RepoDepenseDeplacementXml();
	}

	public void creerDepenseDiverse(DepenseDiverseViewModel DepenseDiverse) {
		DepenseDiverse d = factoryA.creerDepenseDiverse(DepenseDiverse);
		repoDepense.ajouter(d);
	}

	public void creerDepenseDeplacement(
			DepenseDeplacementViewModel DepenseDeplacement) {
		DepenseDeplacement d = factoryB
				.creerDepenseDeplacement(DepenseDeplacement);
		repoDepenseDeux.ajouter(d);
	}

}
