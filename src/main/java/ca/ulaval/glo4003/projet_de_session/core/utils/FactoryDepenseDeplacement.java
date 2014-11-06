package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class FactoryDepenseDeplacement {
	public DepenseDeplacement creer(DepenseDeplacementViewModel dvm) {
		DepenseDeplacement d = new DepenseDeplacement(dvm.identifiant,
				dvm.date, dvm.time, dvm.description, dvm.distance, dvm.coutKm);

		return d;
	}
}
