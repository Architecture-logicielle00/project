package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.ArrayList;
import java.util.Date;


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
			Date _dateDeNaissance,
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
		dateDeNaissance = _dateDeNaissance;
		genre = _genre;
		numTelephone = _numTelephone;
		statutGestionnaire = false;
		taches = new ArrayList<String>();
		feuillesDeTemps= new ArrayList<Long>();
	}
	
	public Employe()
	{
		this("", "", "", "", "", "", "", "","","",new Date(),"","");
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
	
	public Date obtDateDeNaissance(){ return dateDeNaissance; }
	public void changerDateDeNaissance(Date _dateDeNaissance){ dateDeNaissance = _dateDeNaissance;}

	public String obtNumTelephone(){ return numTelephone; }
	public void changerNumTelephone(String _numTelephone){ numTelephone = _numTelephone;}

	public String obtGenre(){ return genre; }
	public void changerGenre(String _genre){ genre = _genre;}
	
	public boolean estGestionnaire(){ return statutGestionnaire; }
	public void changerStatutGestionnaire(boolean s){ statutGestionnaire = s;}
	
	
	public ArrayList<String> obtTaches(){
		return taches;
	}
	
	public boolean ajouterTache(String tache)
	{
		return taches.add(tache);
	}
	
	public void supprimerTache(String tache)
	{
		taches.remove(tache);
	}
	
	public Long obtFeuilleDeTempsCourante(){
		Long fg = new Long(2);//feuillesDeTemps.get(feuillesDeTemps.size() - 1);
		return fg;
	}
	
	String nom;
	String prenom;
	String entreprise;
	String email;
	String pays;
	String province;
	String ville;
	String codePostal;
	Date dateDeNaissance;
	String genre;
	String numTelephone;
	
	ArrayList<Long> feuillesDeTemps;
	ArrayList<String> taches;
	
	boolean statutGestionnaire;
}

