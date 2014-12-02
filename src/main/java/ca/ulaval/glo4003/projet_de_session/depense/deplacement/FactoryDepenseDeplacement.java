package ca.ulaval.glo4003.projet_de_session.depense.deplacement;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

public class FactoryDepenseDeplacement {
	public DepenseDeplacement creer(String _identifiant, String _date, String _time,
			String _description, float _distance, float _coutkm)
	{
		return new DepenseDeplacement(_identifiant, _date, _time,
				_description, _distance, _coutkm);
	}
}
