package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.Date;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

	public class FactoryDepenseDeplacement {
		public DepenseDeplacement creer(DepenseDeplacementViewModel d) {
			DepenseDeplacement a = new DepenseDeplacement("",new Date(), "", (float) 1.5, (float) (1.6));
			return a;
		}
	}

