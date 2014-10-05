package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

public class FeuilleDeTempsViewModel {
	
	public int id;
		
	public Date debutPeriode;
	
	public Date finPeriode;
	
	public String employe;
	
	public Dictionary<String, ArrayList<Float>> taches;

}
