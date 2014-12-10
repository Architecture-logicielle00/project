package ca.ulaval.glo4003.projet_de_session.compte.employe;

import java.util.Date;

public class InformationPersonnelle {
	public InformationPersonnelle(
			String _nom,
			String _prenom,
			String _email, 
			String _pays,
			String _province,
			String _ville,
			String _codePostal,
			Date _dateDeNaissance,
			String _genre,
			String _numTelephone){
		nom = _nom;
		prenom = _prenom;
		email = _email;
		pays = _pays;
		province = _province;
		ville = _ville;
		codePostal = _codePostal;
		dateDeNaissance = _dateDeNaissance;
		genre = _genre;
		numTelephone = _numTelephone;
	}
	
	public boolean estEgalA(InformationPersonnelle informationPersonnelle){
		return 
				this.nom.equals(informationPersonnelle.nom) &&
				this.prenom.equals(informationPersonnelle.prenom) &&
				this.email.equals(informationPersonnelle.email) &&
				this.pays.equals(informationPersonnelle.pays) &&
				this.province.equals(informationPersonnelle.province) &&
				this.ville.equals(informationPersonnelle.ville) &&
				this.codePostal.equals(informationPersonnelle.codePostal) &&
				this.dateDeNaissance.equals(informationPersonnelle.dateDeNaissance) &&
				this.genre.equals(informationPersonnelle.genre) &&
				this.numTelephone.equals(informationPersonnelle.numTelephone);
	}
	
	public String nom;
	public String prenom;
	public String email;
	public String pays;
	public String province;
	public String ville;
	public String codePostal;
	public Date dateDeNaissance;
	public String genre;
	public String numTelephone;


}
