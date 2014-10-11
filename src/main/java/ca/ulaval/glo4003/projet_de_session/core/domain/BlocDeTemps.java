package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;

public class BlocDeTemps {
	
	
	public String tache;
	public ArrayList<Float> nbHeuresParJours; 

	
	public BlocDeTemps(String _tache, int capacity)
	{
		tache = _tache;
		nbHeuresParJours = new ArrayList<Float>();
		
		for (int i = 0; i < capacity; i++) {
			nbHeuresParJours.add((float) 0);
		}
	}	
	
	public String obtTache(){
		return tache;
	}
	
	public void defTache(String _tache){
		tache = _tache;
	}
	
	public ArrayList<Float> obtNbHeuresParJours(){
		return nbHeuresParJours;
	}
	
	public void defNbHeuresParJours(ArrayList<Float> _nbHeuresParJours){
		nbHeuresParJours = _nbHeuresParJours;
	}
	
	

}
