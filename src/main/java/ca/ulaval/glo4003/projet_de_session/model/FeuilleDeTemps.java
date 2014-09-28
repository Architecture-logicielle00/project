package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;
import java.util.Date;


public class FeuilleDeTemps {
	
	public FeuilleDeTemps(String _nomEmploye, Date _debut, Date _fin)
	{
		nomEmploye = _nomEmploye;
		debut = _debut;
		fin = _fin;
		
		blocsDeTemps = new ArrayList<BlocDeTemps>();
	}
	
	public Date obtDebut(){ return debut; }
	
	public Date obtFin(){ return fin; }
	
	public String obtNomEmploye(){ return nomEmploye; }
	
	public ArrayList<BlocDeTemps> obtBlocsDeTemps() { return blocsDeTemps; }
	
	public void ajouterBlocDeTemps(String projet, String tache, Date jour, float nbHeure)
	{
		if( (jour.compareTo(debut) >= 0) && (jour.compareTo(fin) <= 0))
		{
			blocsDeTemps.add( new BlocDeTemps(projet, tache, jour, nbHeure) );
		}
	}
	
	private ArrayList<BlocDeTemps> blocsDeTemps;
	private Date debut;
	private Date fin;
	private String nomEmploye;
}
