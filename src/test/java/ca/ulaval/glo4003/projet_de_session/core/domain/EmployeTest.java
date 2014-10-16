package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;

public class EmployeTest {

	private static Employe employe;
	private static ArrayList<String> taches;
	private static ArrayList<String> feuillesDeTemps;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		employe = new Employe();
		taches = new ArrayList<String>();
		taches.add("Dormir");	
		feuillesDeTemps = new ArrayList<String>();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAjouterTache() {
		employe.ajouterTache("Dormir");
		assertEquals(taches, employe.obtTaches());
	}

	@Test
	public void testSupprimerTache() {
		employe.ajouterTache("Dormir");
		employe.ajouterTache("Sortir");
		employe.supprimerTache("Sortir");
		assertEquals(taches, employe.obtTaches());
	}

	@Test(expected=FeuilleDeTempsIntrouvableException.class)
	public void testObtFeuilleDeTempsCourantePasDeFeuille() throws Exception {
		employe.obtIDFeuilleDeTempsCourante();
	}
	
	
	@Test
	public void testObtFeuilleDeTempsCourante() throws Exception {
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		employe.ajouterIdFeuilleDeTemps("Feuille2");
		assertEquals("Feuille2",employe.obtIDFeuilleDeTempsCourante());
	}

	@Test
	public void testAjouterIdFeuilleDeTemps() throws Exception {
		feuillesDeTemps.add("Feuille1");
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		assertEquals(feuillesDeTemps,employe.obtIDFeuillesDeTemps());
		
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		assertEquals(feuillesDeTemps,employe.obtIDFeuillesDeTemps());
	}

}
