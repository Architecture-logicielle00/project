package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import org.junit.Before;
import org.junit.Test;

public class RepoEntrepriseXmlTest {

	private static RepoEntrepriseXml repo;

	@Before
	public void setUp() throws Exception {
		repo = new RepoEntrepriseXml();
	}
	
	private String nomUtilisateur = "nomUtilisateur"; 
	private String mdp ="mdp" ;
	private String nom ="nom" ;
	
	private Entreprise obtenirEntreprise()
	{
		return new Entreprise(nomUtilisateur, mdp, nom);
	}
	
	@Test
	public void ajouterTest()
	{
		
	}
	
}
