package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.Entreprise;

public class FactoryEntreprise {
	public Entreprise creerEntreprise(String nomUtilisateur, String mdp, String nom)
	{
		return new Entreprise(nomUtilisateur, mdp, nom);
	}
}
