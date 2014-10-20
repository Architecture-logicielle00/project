package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

	public class FactoryDepenseDeplacement {
		public DepenseDeplacement creer(DepenseDeplacementViewModel d) {
			DepenseDeplacement a = new DepenseDeplacement(d.identifiant, d.date,
					d.total, d.sousTotal, d.description, d.distance, d.coutkm);
			return a;
		}
	}


