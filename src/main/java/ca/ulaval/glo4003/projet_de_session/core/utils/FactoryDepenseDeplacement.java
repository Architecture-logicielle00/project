package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

	public class FactoryDepenseDeplacement {
		public DepenseDeplacement creerDepenseDeplacement(
				DepenseDeplacementViewModel depenseDeplacement) {
			return new DepenseDeplacement();
		}

	}


