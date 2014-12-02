package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;

public class ProjetTachesViewModel {
	public String nomProjet;
	public ArrayList<String> nomTaches;
	
	public String obtNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public ArrayList<String> obtNomTaches() {
		return nomTaches;
	}
	public void setNomTaches(ArrayList<String> nomTaches) {
		this.nomTaches = nomTaches;
	}

}
