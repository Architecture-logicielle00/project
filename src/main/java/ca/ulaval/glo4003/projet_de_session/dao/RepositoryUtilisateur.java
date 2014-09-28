package ca.ulaval.glo4003.projet_de_session.dao;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.model.Employee;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

public class RepositoryUtilisateur implements IRepositoryUtilisateur {
	
	protected List<Utilisateur> utilisateurs;
	
	public RepositoryUtilisateur()
	{
		if (utilisateurs == null)
		{
			utilisateurs = new ArrayList<Utilisateur>();
			InitialiserRepoTest();
		}
	}
	
	// TODO temporaire le temps d'avoir un vrai acc�s au xml
	public void InitialiserRepoTest()
	{
		String mdp = "12345";
		
		ajouter(new Employee("JFGRA", mdp,  "Gravel", "Jean-François", "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("ALSAM", mdp, "Samson","Alexandra",  "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("DASAU", mdp, "Sauvé", "David", "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("JPDEL", mdp, "Delisle","Jean-Phillipe", "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("MOMEC", mdp, "Mechqrane","Mounir", "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("WAHJK", mdp, "inconnue","Walid", "", "", "", "", "", "", "", "", "", ""));
		ajouter(new Employee("LAHOL", mdp, "Holy", "Laurianne", "", "", "", "", "", "", "", "", "", ""));
		
		Employee gestionnaire = new Employee("OLDU", mdp, "Dugas", "Olivier", "", "", "", "", "", "", "", "", "", "");
		gestionnaire.changerStatutGestionnaire(true);
		
		ajouter(gestionnaire);
	}
	
	@Override
	public void ajouter(Utilisateur utilisateur)
	{
		utilisateurs.add(utilisateur);
	}

	@Override
	public Utilisateur obtenirParNom(String nomUtilisateur) 
	{
		Utilisateur utilisateurRechercher = null;
		
		for (Utilisateur simpleUtilisateur : utilisateurs)
		{
			if (nomUtilisateur.equals(simpleUtilisateur.obtNomUtilisateur()))
			{
				utilisateurRechercher = simpleUtilisateur;
				break;
			}
		}
				
		return utilisateurRechercher;
	}

	public List<Utilisateur> obtenirTout(){
		return utilisateurs;
	}
}
