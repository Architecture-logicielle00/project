package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.Date;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

public class FactoryDepenseDiverse {

	public DepenseDiverse creer(DepenseDiverseViewModel v) {
		DepenseDiverse c = new DepenseDiverse(v.identifiant, new Date(), v.description, v.nbRepas, v.coutRepas, v.divers,
				v.coucher);
		return c;
		}

}