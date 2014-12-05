package ca.ulaval.glo4003.projet_de_session.compte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.compte.Utilisateur;

public class UtilisateurTest {

	private static Utilisateur utilisateur;

	@Before
	public void setUp() throws Exception {
		utilisateur = new Utilisateur("NomUtilisateur","mdp");
	}

	@Test
	public void testMotDePasseValide() {
		assertTrue(utilisateur.motDePasseValide("mdp"));
	}
	
	@Test
	public void testMotDePasseNonValide() {
		assertFalse(utilisateur.motDePasseValide("FauxMdp"));
	}

}
