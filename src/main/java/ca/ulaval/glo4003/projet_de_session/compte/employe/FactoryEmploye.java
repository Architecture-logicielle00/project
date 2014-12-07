package ca.ulaval.glo4003.projet_de_session.compte.employe;

import java.util.Date;

public class FactoryEmploye
{	
	public Employe creerEmploye(String nomUtilisateur, String nom,
			String prenom, String email, String pays,
			String province, String ville, String codePostal,
			String genre, String numTelephone, boolean statutGestionnaire)
	{
		Employe employe =  new Employe(nomUtilisateur, "12345", nom, prenom, email, pays, province, ville, codePostal,
				new Date(), genre, numTelephone);
		
		employe.defStatutGestionnaire(statutGestionnaire);
		return employe;
	}
}
