package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactoryEntrepriseTest {

	private static FactoryEntreprise facto;

	@Before
	public void setUp() throws Exception {
		facto = new FactoryEntreprise();
	}
	
	private String nomUtilisateur = "nomUtilisateur";
	private String mdp = "mdp";
	private String nom = "nom"; 
	
	private boolean estValide(Entreprise ent)
	{
		return
				ent.obtNomUtilisateur() == nomUtilisateur &&
				ent.motDePasseEstValide(mdp) &&
				ent.nom == nom;
	}
	
	@Test
	public void creeEntrepriseTest()
	{
		Entreprise ent = facto.creerEntreprise(nomUtilisateur, mdp, nom);
		
		assertTrue(estValide(ent));
	}
	
}
