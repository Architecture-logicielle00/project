package ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.tempsParTache;

import java.util.ArrayList;

public class TempsParTache {

	private String tache;
	private ArrayList<Float> nbHeuresParJours;

	public TempsParTache() {
	}

	public TempsParTache(String _tache, int capacity) {
		tache = _tache;
		nbHeuresParJours = new ArrayList<Float>();

		for (int i = 0; i < capacity; i++) {
			nbHeuresParJours.add((float) 0);
		}
	}

	public String obtTache() {
		return tache;
	}

	public void defTache(String _tache) {
		tache = _tache;
	}

	public ArrayList<Float> obtNbHeuresParJours() {
		return nbHeuresParJours;
	}

	public void defNbHeuresParJours(ArrayList<Float> _nbHeuresParJours) {
		nbHeuresParJours = _nbHeuresParJours;
	}

}
