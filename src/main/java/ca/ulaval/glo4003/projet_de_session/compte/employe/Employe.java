package ca.ulaval.glo4003.projet_de_session.compte.employe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTempsIntrouvableException;

public class Employe extends Utilisateur {

	InformationPersonnelle informationPersonnelle;
	
	private String entreprise;
	private String departement;

	private ArrayList<String> feuillesDeTemps;
	private ArrayList<String> taches;

	boolean statutGestionnaire;
	
	public Employe(String _nomUtilisateur, String _mdp, String _nom,
			String _prenom, String _email, String _pays,
			String _province, String _ville, String _codePostal,
			Date _dateDeNaissance, String _genre, String _numTelephone) {
		super(_nomUtilisateur, _mdp);
		informationPersonnelle = new InformationPersonnelle(_nom, _prenom, _email, _pays, _province, _ville, _codePostal, _dateDeNaissance, _genre, _numTelephone);
		statutGestionnaire = false;
		taches = new ArrayList<String>();
		feuillesDeTemps = new ArrayList<String>();
	}

	public Employe() {
		taches = new ArrayList<String>();
		feuillesDeTemps = new ArrayList<String>();
	}

	public InformationPersonnelle getInformationPersonelle(){
		return informationPersonnelle;
	}

	public void setInformationPersonelle(InformationPersonnelle _informationPersonnelle){
		this.informationPersonnelle = _informationPersonnelle;
	}

	public String obtEntreprise() {
		return entreprise;
	}

	public void defEntreprise(String _entreprise) {
		entreprise = _entreprise;
	}
	
	public String obtDepartement() {
		return departement;
	}

	public void defDepartement(String departement) {
		this.departement = departement;
	}
	
	public boolean estEmployeDe(String _entreprise){
		return entreprise.equals(_entreprise);
	}

	
	public boolean estGestionnaire() {
		return statutGestionnaire;
	}

	public void defStatutGestionnaire(boolean s) {
		statutGestionnaire = s;
	}

	public ArrayList<String> obtTaches() {
		return taches;
	}
	
	public void defTaches(List<String> taches){
		this.taches = (ArrayList<String>) taches;
	}

	public boolean ajouterTache(String tache) {
		return taches.add(tache);
	}

	public void supprimerTache(String tache) {
		taches.remove(tache); //
	}

	public String obtIDFeuilleDeTempsCourante() throws Exception{
		try{
			return feuillesDeTemps.get(feuillesDeTemps.size() -1);
		}
		catch(IndexOutOfBoundsException e)
		{
			throw new FeuilleDeTempsIntrouvableException();
		}
	}
	
	public ArrayList<String> obtIDFeuillesDeTemps() throws Exception{
		return feuillesDeTemps;
	}
	
	public void ajouterIdFeuilleDeTemps(String id) {
		if(!feuillesDeTemps.contains(id))
			feuillesDeTemps.add(id);
	}
	
	@Override
	public boolean equals(Object autreObj){
		if (!autreObj.getClass().isInstance(Employe.class))
			return false;

		return	estEgalA((Employe)autreObj);
	}
	
	private boolean estEgalA(Employe autreEmp)
	{
		return 
				statutGestionnaire == autreEmp.statutGestionnaire &&
				entreprise.equals(autreEmp.entreprise) &&
				departement.equals(autreEmp.departement) &&
				informationPersonnelle.estEgalA(autreEmp.informationPersonnelle);
	}
}