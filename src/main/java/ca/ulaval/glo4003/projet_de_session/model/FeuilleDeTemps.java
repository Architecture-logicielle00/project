package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;
import java.util.Date;

public class FeuilleDeTemps {
	
	public FeuilleDeTemps(String _employe, Date _debut, Date _fin)
	{
		employe = _employe;
		debut = _debut;
		fin = _fin;
	}
	
	public Date obtDebut(){ return debut; }
	
	public Date obtFin(){ return fin; }
	
	public ArrayList<BlocDeTemps> obtBlocsDeTemps() { return blocsDeTemps; }
	
	public void ajouterBlocDeTemps(String projet, String tache, Date jour, float nbHeure)
	{
		if( (jour.compareTo(debut) >= 0) && (jour.compareTo(fin) <= 0))
		{
			blocsDeTemps.add( new BlocDeTemps(projet, tache, jour, nbHeure) );
		}
	}
	
	private ArrayList<BlocDeTemps> blocsDeTemps = new ArrayList<BlocDeTemps>();
	private Date debut;
	private Date fin;
	private String employe;
}
