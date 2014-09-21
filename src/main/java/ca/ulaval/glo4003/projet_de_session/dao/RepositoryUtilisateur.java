package ca.ulaval.glo4003.projet_de_session.dao;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.model.SimpleUtilisateur;
import ca.ulval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;

public class RepositoryUtilisateur implements IRepositoryUtilisateur {
	
	// TODO accédé au fichier de manière reel au lieu d'utiliser cette liste hardcoder, représente la base de donnée doit donc etre remplacer par ce qui fonctionne
	// Le static est une très MAUVAISE PRATIQUE mais ceci permet de simuler la persistence des données. À réglé.
	static List<SimpleUtilisateur> utilisateurs;
	
	public RepositoryUtilisateur()
	{
		if (utilisateurs == null)
		{
			utilisateurs = new ArrayList<SimpleUtilisateur>();
			InitialiserRepoTest();
		}
	}
	
	// TODO temporaire le temps d'avoir un vrai accès au xml
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
