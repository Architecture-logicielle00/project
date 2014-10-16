package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UtilisateurTest {

	private static Utilisateur utilisateur;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		utilisateur = new Utilisateur("NomUtilisateur","mdp");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMotDePasseValide() {
		assertTrue(utilisateur.motDePasseValide("mdp"));
		assertFalse(utilisateur.motDePasseValide("FauxMdp"));
	}

}
