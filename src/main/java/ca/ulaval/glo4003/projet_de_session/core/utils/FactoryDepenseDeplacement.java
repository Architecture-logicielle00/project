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
		d.defCoutKm(dvm.coutkm);
		d.defDistance(dvm.distance);
		try {
			d.defDate(new SimpleDateFormat("yyyy-MM-dd").parse(dvm.date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d.defDescription(dvm.description);

		return d;
	}
}
