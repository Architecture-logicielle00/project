package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

public class FactoryEmploye
{	
	public Employe creerEmploye(EmployeeViewModel employe)
	{
		return new Employe(); //TODO ajouter les paramètres
	}
}
