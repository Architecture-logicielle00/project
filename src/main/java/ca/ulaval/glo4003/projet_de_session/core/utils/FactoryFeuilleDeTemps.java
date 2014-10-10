package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.Date;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;


public class FactoryFeuilleDeTemps
{	
	public FeuilleDeTemps creerFeuilleDeTemps(Employe _employe, Date _debut, Date _fin){
		return new FeuilleDeTemps(_employe.obtNomUtilisateur(), _debut, _fin, _employe.obtTaches());
	}
}
