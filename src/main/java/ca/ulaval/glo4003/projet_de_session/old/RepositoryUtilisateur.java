package ca.ulaval.glo4003.projet_de_session.old;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;

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
		
		ajouter(new Employe("JFGRA", mdp,  "Gravel", "Jean-François", "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("ALSAM", mdp, "Samson","Alexandra",  "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("DASAU", mdp, "Sauvé", "David", "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("JPDEL", mdp, "Delisle","Jean-Phillipe", "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("MOMEC", mdp, "Mechqrane","Mounir", "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("WAHJK", mdp, "inconnue","Walid", "", "", "", "", "", "", 0, 0, 0, "", ""));
		ajouter(new Employe("LAHOL", mdp, "Holy", "Laurianne", "", "", "", "", "", "", 0, 0, 0, "", ""));
		
		Employe gestionnaire = new Employe("OLDU", mdp, "Dugas", "Olivier", "", "", "", "", "", "", 0, 0, 0, "", "");
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
