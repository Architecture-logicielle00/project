package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

public class FactoryDepenseDiverse {

	public DepenseDiverse creer(DepenseDiverseViewModel v) {
		DepenseDiverse c = new DepenseDiverse(v.identifiant, v.date, v.total,
				v.sousTotal, v.description, v.nbRepas, v.coutRepas, v.divers,
				v.coucher);
		return c;
		}

}