package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet;

import java.util.ArrayList;
import java.util.List;

public class ProjetViewModel {
	public String nom;
	public ArrayList<String> taches;
	
	public String getNom(){return nom;}
	public ArrayList<String> getTaches(){return taches;}
	
	public void setNom(String _nom){nom = _nom;}
	public void setTaches(ArrayList<String> _taches){taches = _taches;}
	
}
