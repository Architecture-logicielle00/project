package ca.ulaval.glo4003.projet_de_session.dao;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;

public class RepositoryUtilisateur implements IRepositoryUtilisateur {
	
	// TODO acc�d� au fichier de mani�re reel au lieu d'utiliser cette liste hardcoder, repr�sente la base de donn�e doit donc etre remplacer par ce qui fonctionne
	// Le static est une tr�s MAUVAISE PRATIQUE mais ceci permet de simuler la persistence des donn�es. � r�gl�.
	static List<Utilisateur> utilisateurs;
	
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
		
		ajouterUtilisateur("Jeff",mdp);
		ajouterUtilisateur("Alexandra",mdp);
		ajouterUtilisateur("Walid",mdp);
		ajouterUtilisateur("Mounir",mdp);
		ajouterUtilisateur("David",mdp);
		ajouterUtilisateur("Lauriane",mdp);
		ajouterUtilisateur("JP",mdp);
	}
	
	@Override
	public void ajouterUtilisateur(String nomUtilisateur, String mdp)
	{
		utilisateurs.add(new Utilisateur(nomUtilisateur,mdp));
	}

	@Override
	public Utilisateur obtenirUnUtilisateur(String nomUtilisateur) 
	{
		Utilisateur utilisateurRechercher = null;
		
		for (Utilisateur simpleUtilisateur : utilisateurs)
		{
			if (nomUtilisateur.equals(simpleUtilisateur.obtenirNomUtilisateur()))
			{
				utilisateurRechercher = simpleUtilisateur;
				break;
			}
		}
				
		return utilisateurRechercher;
	}

}
