package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.ArrayList;

public class EmployeTachesViewModel {
	public String nomEmploye;
	public ArrayList<String> nomTaches;
	
	public String obtNomEmploye() {
		return nomEmploye;
	}
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}
	public ArrayList<String> obtNomTaches() {
		return nomTaches;
	}
	public void setNomTaches(ArrayList<String> nomTaches) {
		this.nomTaches = nomTaches;
	}
}
	
