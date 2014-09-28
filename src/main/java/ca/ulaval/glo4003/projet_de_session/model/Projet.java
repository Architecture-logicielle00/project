package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;

public class Projet {
	
	public Projet(String _numero, String _nom, String _description)
	{
		numero = _numero;
		nom = _nom;
		description = _description;
		taches = new ArrayList<Tache>();
	}
	
	public String obtNumero(){ return numero;	}
	
	public String obtNom(){ return nom;	}
	
	public String obtDescription(){ return description;	}
	
	public ArrayList<Tache> obtTache(){ return taches;	}
	
	public void changerNumero(String _numero){ numero = _numero; }
	
	public void changerNom(String _nom){ nom = _nom; }
	
	public void changerDescription(String _description){ description = _description; }
	
	public void ajouterTache(Tache tache){ taches.add(tache); }
	
	public void enleverTache(Tache tache){ taches.remove(tache); }
	
	private String numero;
	private String nom; 
	private String description;
	private ArrayList<Tache> taches;
	
}
