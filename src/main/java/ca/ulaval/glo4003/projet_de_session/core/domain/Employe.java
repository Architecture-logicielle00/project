package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;


public class Employe extends Utilisateur
{
	public Employe(String _nomUtilisateur,
			String _mdp,
			String _nom,
			String _prenom,
			String _entreprise,
			String _email,
			String _pays,
			String _province,
			String _ville,
			String _codePostal,
			Integer _moisDeNaissance,
			Integer _jourDeNaissance,
			Integer _anneeDeNaissance,
    		String _genre,
    		String _numTelephone)
	{
		super(_nomUtilisateur, _mdp);
		
		nom = _nom;
		prenom = _prenom;
		entreprise = _entreprise;
		email = _email;
		pays = _pays;
		province = _province;
		ville= _ville;
		codePostal = _codePostal;
		moisDeNaissance = _moisDeNaissance;
		jourDeNaissance = _jourDeNaissance;
		anneeDeNaissance = _anneeDeNaissance;
		genre = _genre;
		numTelephone = _numTelephone;
		
		
		statutGestionnaire = false;
		projets = new ArrayList<String>();
		feuillesDeTemps = new ArrayList<FeuilleDeTemps>();
	}
	
	public Employe()
	{
	}
	
	public String obtNom(){ return nom;	}
	public void changerNom(String _nom){ nom = _nom; }
	
	public String obtPrenom(){ return prenom; }
	public void changerPrenom(String _prenom){ prenom = _prenom;}
	
	public String obtEntreprise(){ return entreprise; }
	public void changerEntreprise(String _entreprise){ entreprise = _entreprise;}
	
	public String obtEmail(){ return email; }
	public void changerEmail(String _email){ email = _email;}
	
	public String obtPays(){ return pays; }
	public void changerPays(String _pays){ pays = _pays;}
	
	public String obtProvince(){ return province; }
	public void changerProvince(String _province){ province = _province;}
	
	public String obtVille(){ return ville; }
	public void changerVille(String _ville){ ville = _ville;}
	
	public String obtCodePostal(){ return codePostal; }
	public void changerCodePostal(String _codePostal){ codePostal = _codePostal;}
	
	public Integer obtJourDeNaissance(){ return jourDeNaissance; }
	public void changerJourDeNaissance(Integer _jourDeNaissance){ jourDeNaissance = _jourDeNaissance;}

	public Integer obtMoisDeNaissance(){ return moisDeNaissance; }
	public void changerMoisDeNaissance(Integer _moisDeNaissance){ moisDeNaissance = _moisDeNaissance;}

	public Integer obtAnneeDeNaissance(){ return anneeDeNaissance; }
	public void changerAnneeDeNaissance(Integer _anneeDeNaissance){ anneeDeNaissance = _anneeDeNaissance;}

	public String obtNumTelephone(){ return numTelephone; }
	public void changerNumTelephone(String _numTelephone){ numTelephone = _numTelephone;}

	public String obtGenre(){ return genre; }
	public void changerGenre(String _genre){ genre = _genre;}
	
	public boolean estGestionnaire(){ return statutGestionnaire; }
	public void changerStatutGestionnaire(boolean s){ statutGestionnaire = s;}
	
	public void ajouterProjet(String projet)
	{
		projets.add(projet);
	}
	
	public void supprimerProjet(String projet)
	{
		//TODO
	}
	
	String nom;
	String prenom;
	String entreprise;
	String email;
	String pays;
	String province;
	String ville;
	String codePostal;
	Integer moisDeNaissance;
	Integer jourDeNaissance;
	Integer anneeDeNaissance;
	String genre;
	String numTelephone;
	
	ArrayList<String> projets;
	ArrayList<FeuilleDeTemps> feuillesDeTemps;
	
	
	boolean statutGestionnaire;
}

