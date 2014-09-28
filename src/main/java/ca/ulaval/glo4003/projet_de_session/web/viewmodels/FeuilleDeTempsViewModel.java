package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class FeuilleDeTempsViewModel {
	
	public FeuilleDeTempsViewModel(){
		 blocsDeTemps = new ArrayList<BlocDeTempsViewModel>();
	}
	
	public Date obtDateDebutPeriode(){
		return debutPeriode;
	}
	
	public Date obtDateFinPeriode(){
		return finPeriode;
	}
	
	public ArrayList<BlocDeTempsViewModel> obtBlocsDeTemps(){
		return blocsDeTemps;
	}
	
	public ArrayList<String> obtListeJoursPeriode(){
		Calendar c = Calendar.getInstance();
		ArrayList<String> joursPeriode = new ArrayList<String>();
		Date dateTrotteur = debutPeriode;
		
		
		while(dateTrotteur.compareTo(finPeriode) != 0)
		{
			joursPeriode.add(dateTrotteur.toString());

			c.setTime(dateTrotteur);
			c.add(Calendar.DATE, 1);
			dateTrotteur = c.getTime();
		}
		
		return joursPeriode;
	}
	
	public ArrayList<BlocDeTempsViewModel> blocsDeTemps;
	
	public Date debutPeriode;
	
	public Date finPeriode;
	
	public String employe;
	
	public int id;
	
	
	
	
	
}
