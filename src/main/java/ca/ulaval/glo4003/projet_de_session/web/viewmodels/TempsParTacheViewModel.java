package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;

public class TempsParTacheViewModel {
	public String tache;
	public ArrayList<Float> nbHeuresParJours;


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
