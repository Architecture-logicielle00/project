package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.ProjetViewModel;

public class EmployeTachesViewModel {
	public String nomUtilisateur;
	public String nom;
	public ArrayList<String> taches;
	
	public String getNomUtilisateur(){return nomUtilisateur;}
	public String getNom(){return nom;}
	public ArrayList<String> getTaches(){return taches;}
	
	public void setNomUtilisateur(String _nomUtilisateur){nomUtilisateur = _nomUtilisateur;}
	public void setNom(String _nom){nom = _nom;}
	public void setTaches(ArrayList<String> _taches){taches = _taches;}
}
	
