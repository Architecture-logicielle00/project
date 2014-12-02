package ca.ulaval.glo4003.projet_de_session.compte.entreprise;


public class FactoryEntreprise {
	public Entreprise creerEntreprise(String nomUtilisateur, String mdp, String nom)
	{
		return new Entreprise(nomUtilisateur, mdp, nom);
	}
}
