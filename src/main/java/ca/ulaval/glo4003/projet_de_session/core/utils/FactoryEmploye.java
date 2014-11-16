package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.Date;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

public class FactoryEmploye
{	
	public Employe creerEmploye(String nomUtilisateur, String nom,
			String prenom, String email, String pays,
			String province, String ville, String codePostal,
			String genre, String numTelephone, boolean statutGestionnaire)
	{
		Employe employe =  new Employe(nomUtilisateur, "12345", nom, prenom, "NERV", email, pays, province, ville, codePostal,
				new Date(), genre, numTelephone);
		
		employe.defStatutGestionnaire(statutGestionnaire);
		return employe;
	}
}
