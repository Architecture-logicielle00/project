package ca.ulaval.glo4003.projet_de_session.dao;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;
import ca.ulval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;

public class RepositoryUtilisateur implements IRepositoryUtilisateur {
	
	// TODO acc�d� au fichier de mani�re reel au lieu d'utiliser cette liste hardcoder, repr�sente la base de donn�e doit donc etre remplacer par ce qui fonctionne
	// Le static est une tr�s MAUVAISE PRATIQUE mais ceci permet de simuler la persistence des donn�es. � r�gl�.
	static List<SimpleUtilisateur> utilisateurs;
	
	public RepositoryUtilisateur()
	{
		if (utilisateurs == null)
		{
			utilisateurs = new ArrayList<SimpleUtilisateur>();
			InitialiserRepoTest();
		}
	}
	
	// TODO temporaire le temps d'avoir un vrai acc�s au xml
	public void InitialiserRepoTest()
	{
		String mdp = "12345";
		
		AjouterUtilisateur("Jeff",mdp);
		AjouterUtilisateur("Alexandra",mdp);
		AjouterUtilisateur("Walid",mdp);
		AjouterUtilisateur("Mounir",mdp);
		AjouterUtilisateur("David",mdp);
		AjouterUtilisateur("Lauriane",mdp);
		AjouterUtilisateur("JP",mdp);
	}
	
	@Override
	public void AjouterUtilisateur(String nomUtilisateur, String mdp)
	{
		utilisateurs.add(new SimpleUtilisateur(nomUtilisateur,mdp));
	}

	@Override
	public SimpleUtilisateur ObtenirUnUtilisateur(String nomUtilisateur) 
	{
		SimpleUtilisateur utilisateurRechercher = null;
		
		for (SimpleUtilisateur simpleUtilisateur : utilisateurs)
		{
			if (nomUtilisateur.equals(simpleUtilisateur.ObtenirNomUtilisateur()))
			{
				utilisateurRechercher = simpleUtilisateur;
				break;
			}
		}
				
		return utilisateurRechercher;
	}

}
