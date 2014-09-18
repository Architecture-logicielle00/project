package ca.ulaval.glo4003.projet_de_session.model;


import java.io.Serializable;
import java.util.Observable;


public abstract class Utilisateur extends Observable implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer	id;
	private String	nomProjet;
	private String	prenom;
	private String	nom;
	private String	tache;	
	private float	temps;
	private float	salaire;
	private float	cout;
	private float	millage;
	
	private Integer uid;
	private static Integer uidCmpt = 0;
	
	public Utilisateur(Integer id){
		
		this.id			= new Integer(id);
		this.nomProjet	= new String(nomProjet);
		this.prenom		= new String(prenom);
		this.nom		= new String(nom);
		this.tache		= new String(tache);
		this.temps		= new Float(temps);
		this.salaire	= new Float(salaire);
		this.cout		= new Float(cout);
		this.millage	= new Float(millage);
		this.uid 		= uidCmpt;
		
		uidCmpt++;
	}
	
	
	
	public float getMillage() {
		return millage;
	}
	public void setMillage(float millage) {
		this.millage = millage;
		changed();
	}
	public float getCost() {
		return cout;
	}
	public void setCost(float cost) {
		this.cout = cost;
		changed();
	}
	public float getSalaire() {
		return salaire;
	}
	public void setSalaire(float pay) {
		this.salaire = pay;
		changed();
	}
	public float getTime() {
		return temps;
	}
	public void setTime(float time) {
		this.temps = time;
		changed();
	}
	public String getProjet() {
		return nomProjet;
	}
	public void setProjet(String projet) {
		this.nomProjet = projet;
		changed();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirtname() {
		return prenom;
	}
	public void setFirtname(String firtname) {
		this.prenom = firtname;
		changed();
	}
	public String getLastname() {
		return nom;
	}
	public void setLastname(String lastname) {
		this.nom = lastname;
		changed();
	}
	public String getTache() {
		return tache;
	}
	public void setTache(String tache) {
		this.tache = tache;
		changed();
	}
	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
		changed();
	}
	
	public static Integer getUidCmpt() {
		return uidCmpt;
	}

	public static void setUidCmpt(Integer uidCmpt) {
		Utilisateur.uidCmpt = uidCmpt;
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
		Utilisateur other = (Utilisateur) obj;
		return (this.uid == other.uid);
	}

	
	private void changed(){
		setChanged();
		notifyObservers();		
	}
}