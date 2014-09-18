package ca.ulaval.glo4003.projet_de_session.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class Projet extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer	idProjet;
	private Integer idUtilisateur;
	private String	nomProjet;
	private float	coutProjet;
	private Date	dateEcheance;
	
	private Integer uidP;
	private static Integer uidPCmpt = 0;
	
	public Projet(Integer idProjet){
		
		this.idProjet 		= idProjet;
		this.idUtilisateur	= new Integer(idUtilisateur);
		this.nomProjet		= new String(nomProjet);
		this.dateEcheance	= new Date();
		this.coutProjet		= new Float(coutProjet);
		
		this.uidP	 		= uidPCmpt;
		
		uidPCmpt++;
	}
	
	
	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}


	public float getCoutProjet() {
		return coutProjet;
	}


	public void setCoutProjet(float coutProjet) {
		this.coutProjet = coutProjet;
	}


	public Integer getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(Integer idProjet) {
		this.idProjet = idProjet;
		changed();
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
		changed();
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
		changed();
	}
	
	public Integer getUidP() {
		return uidP;
	}


	public void setUidP(Integer uidP) {
		this.uidP = uidP;
	}
	
	/**
	 * Override equals
	 * @param obj The object to be compared
	 * @return Returns true if the two objects are identical
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return (false);
		Projet other = (Projet) obj;
		return (this.uidP == other.uidP);
	}

	public static Integer getUidPCmpt() {
		return uidPCmpt;
	}

	public static void setUidPCmpt(Integer uidPCmpt) {
		Projet.uidPCmpt = uidPCmpt;
	}
	private void changed(){
		setChanged();
		notifyObservers();		
	}

}
