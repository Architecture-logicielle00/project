package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.Date;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

public class FactoryEmploye
{	
	public Employe creerEmploye(EmployeeViewModel evm)
	{
		Employe e = new Employe(evm.nomUtilisateur, "12345", evm.nom,
				evm.prenom, "NERV", evm.email, evm.pays,
				evm.province, evm.ville, evm.codePostal,
				new Date(), evm.sexe, evm.telephone);
		e.defStatutGestionnaire(evm.statutGestionnaire);
		return e;
	}
}
