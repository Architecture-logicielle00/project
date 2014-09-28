package ca.ulaval.glo4003.projet_de_session.model;


public class Tache {
	
	public Tache(String _numero, String _nom, String _description)
	{
		numero = _numero;
		nom = _nom;
		description = _description;
	}
	
	public String obtNumero(){ return numero;	}
	
	public String obtNom(){ return nom;	}
	
	public String obtDescription(){ return description;	}
		
	public void changerNumero(String _numero){ numero = _numero; }
	
	public void changerNom(String _nom){ nom = _nom; }
	
	public void changerDescription(String _description){ description = _description; }
	
	private String numero;
	private String nom; 
	private String description;
	
}
