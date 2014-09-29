package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;

public class Projet {
	
	public Projet(String _nom, String _entreprise, String _description)
	{
		entreprise = _entreprise;
		nom = _nom;
		description = _description;
		taches = new ArrayList<Tache>();
	}
	
	public String obtEntreprise(){ return entreprise;	}
	
	public String obtNom(){ return nom;	}
	
	public String obtDescription(){ return description;	}
	
	public ArrayList<Tache> obtTache(){ return taches;	}
	
	public void changerEntreprise(String _entreprise){ entreprise = _entreprise; }
	
	public void changerNom(String _nom){ nom = _nom; }
	
	public void changerDescription(String _description){ description = _description; }
	
	public void ajouterTache(Tache tache){ taches.add(tache); }
	
	public void enleverTache(Tache tache){ taches.remove(tache); }
	
	private String entreprise;
	private String nom; 
	private String description;
	private ArrayList<Tache> taches;
	
}
