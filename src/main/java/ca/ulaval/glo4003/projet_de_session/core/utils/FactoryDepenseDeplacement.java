package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class FactoryDepenseDeplacement {
	public DepenseDeplacement creer(DepenseDeplacementViewModel dvm) {
		// DepenseDeplacement a = new DepenseDeplacement("",new Date(), "",
		// (float) 1.5, (float) (1.6));
		DepenseDeplacement d = new DepenseDeplacement();
		d.defIdentifiant(dvm.identifiant);
		d.defCoutKm(dvm.coutKm);
		d.defDistance(dvm.distance);
		d.defDate(dvm.date);

		d.defDescription(dvm.description);

		return d;
	}
}
