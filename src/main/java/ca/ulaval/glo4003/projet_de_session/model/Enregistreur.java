package ca.ulaval.glo4003.projet_de_session.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;




public class Enregistreur extends Observable implements Observer{

	private List<WEM_Utilisateur> 	utilisateurs;
	private List<WEM_Projet>		projets;
	
	public Enregistreur(){
		this.utilisateurs	= new ArrayList<WEM_Utilisateur>();
		this.projets		= new ArrayList<WEM_Projet>();
	}
	
	/**
	 * utilisateur
	 * @param utilisateur The object to be added
	 * @return add utilisateur to the list of utilisateur
	 */
	public void addUtilisateur(WEM_Utilisateur utilisateurs){
		
		this.utilisateurs.add(this.utilisateurs.size(), utilisateurs);
		changed();
	}
	
	public void addProjet(WEM_Projet projets){
		this.projets.add(this.projets.size(), projets);
		changed();
	}
	
	/**
	 * Remove a user to the network
	 * 
	 * @param utilisateur The user has to remove to the networks user
	 * @return Returns false if user doesn't exist
	 */
	public boolean supprimerUtilisateur(WEM_Utilisateur utilisateur)
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
	public boolean supprimerProjet(WEM_Projet projet)
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

	public List<WEM_Utilisateur> getUtilisateur()
	{
		return (this.utilisateurs);
	}
	
	/**
	 * Get the list of project
	 * 
	 * @return Returns a list of project
	 */

	public List<WEM_Projet> getProjet()
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
	public WEM_Utilisateur getUtilisateur(int uid) {
		for(WEM_Utilisateur n : this.utilisateurs){
			int uidTmp = n.getUid();
			if(uidTmp == uid){
				return n;
			}
		}
		return null;
	}
	public WEM_Projet getProjet(int uidP) {
		for(WEM_Projet n : this.projets){
			int uidTmp = n.getUidP();
			if(uidTmp == uidP){
				return n;
			}
		}
		return null;
	}
}
