package ca.ulaval.glo4003.projet_de_session.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;




public class Enregistreur extends Observable implements Observer{

	private List<Utilisateur> 	utilisateurs;
	private List<Projet>		projets;
	
	public Enregistreur(){
		this.utilisateurs	= new ArrayList<Utilisateur>();
		this.projets		= new ArrayList<Projet>();
	}
	
	/**
	 * utilisateur
	 * @param utilisateur The object to be added
	 * @return add utilisateur to the list of utilisateur
	 */
	public void addUtilisateur(Utilisateur utilisateurs){
		
		this.utilisateurs.add(this.utilisateurs.size(), utilisateurs);
		changed();
	}
	
	public void addProjet(Projet projets){
		this.projets.add(this.projets.size(), projets);
		changed();
	}
	
	/**
	 * Remove a user to the network
	 * 
	 * @param utilisateur The user has to remove to the networks user
	 * @return Returns false if user doesn't exist
	 */
	public boolean supprimerUtilisateur(Utilisateur utilisateur)
	{	
		if (this.utilisateurs.contains(utilisateur) == false){
			return (false);
		}
		this.utilisateurs.remove(utilisateur);
		changed();
		return (true);
	}
	/**
	 * Remove a project to the network
	 * 
	 * @param project The project has to remove to the networks project
	 * @return Returns false if project doesn't exist
	 */
	public boolean supprimerProjet(Projet projet)
	{	
		if (this.projets.contains(projet) == false){
			return (false);
		}
		this.projets.remove(projet);
		changed();
		return (true);
	}
	/**
	 * Get the list of user
	 * 
	 * @return Returns a list of user
	 */

	public List<Utilisateur> getUtilisateur()
	{
		return (this.utilisateurs);
	}
	
	/**
	 * Get the list of project
	 * 
	 * @return Returns a list of project
	 */

	public List<Projet> getProjet()
	{
		return (this.projets);
	}
	
	public int getTotalCountProjets(){
		
		return(this.projets.size());
		
	}
	
	public int getTotalCountUtilisateurs(){
		
		return(this.utilisateurs.size());
		
	}
	
	private void changed(){
		setChanged();
		notifyObservers();		
	}
	@Override
	public void update(Observable o, Object arg) {
		changed();
		
	}
	public Utilisateur getUtilisateur(int uid) {
		for(Utilisateur n : this.utilisateurs){
			int uidTmp = n.getUid();
			if(uidTmp == uid){
				return n;
			}
		}
		return null;
	}
	public Projet getProjet(int uidP) {
		for(Projet n : this.projets){
			int uidTmp = n.getUidP();
			if(uidTmp == uidP){
				return n;
			}
		}
		return null;
	}
}
