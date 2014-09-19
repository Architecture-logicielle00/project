package ca.ulaval.glo4003.projet_de_session.mock;

import ca.ulval.glo4003.projet_de_session.imodel.IIdentificateur;

public class FakeIdentificateur implements IIdentificateur {

	@Override
	public boolean ConnectionValide(String nomUtilisateur, String mdp) 
	{
		return nomUtilisateur.equals("Jeff") && mdp.equals("12345");
	}
}
