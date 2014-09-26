package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;

public class Projet {
	
	public Projet(String _nom, String _description, String _entreprise)
	{
		nom = _nom;
		description = _description;
		entreprise = _entreprise;
		taches = new ArrayList<String>();
	}
	
	public String obtNom(){ return nom;	}
	
	public String obtDescription(){ return description;	}
	
	public String obtEntreprise(){ return entreprise;	}
	
	public ArrayList<String> obtTache(){ return taches;	}
	
	public void changerNom(String _nom){ nom = _nom; }
	
	public void changerDescription(String _description){ description = _description; }
	
	public void changerEntreprise(String _entreprise){ entreprise = _entreprise; }
	
	public void ajouterTache(String tache){ taches.add(tache); }
	
	public void enleverTache(String tache){ taches.remove(tache); }
	
	private String nom; 
	private String description;
	private String entreprise;
	private ArrayList<String> taches;
	
}
