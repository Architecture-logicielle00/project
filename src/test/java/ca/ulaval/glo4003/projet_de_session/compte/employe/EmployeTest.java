package ca.ulaval.glo4003.projet_de_session.compte.employe;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTempsIntrouvableException;

public class EmployeTest {	
	@Test
	public void testAjouterTache() {
		Employe employe = new Employe();
		employe.ajouterTache("Dormir");
		
		ArrayList<String> taches = new ArrayList<String>();
		taches.add("Dormir");	
		
		assertEquals(taches, employe.obtTaches());
	}

	@Test
	public void testSupprimerTache() {
		Employe employe = new Employe();
		employe.ajouterTache("Dormir");
		employe.ajouterTache("Sortir");
		employe.supprimerTache("Sortir");
		
		ArrayList<String> taches = new ArrayList<String>();
		taches.add("Dormir");	
		
		assertEquals(taches, employe.obtTaches());
	}

	@Test(expected=FeuilleDeTempsIntrouvableException.class)
	public void testObtFeuilleDeTempsCourantePasDeFeuille() throws Exception {
		Employe employe = new Employe();
		employe.obtIDFeuilleDeTempsCourante();
	}
	
	
	@Test
	public void testObtFeuilleDeTempsCourante() throws Exception {
		Employe employe = new Employe();
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		employe.ajouterIdFeuilleDeTemps("Feuille2");
		assertEquals("Feuille2",employe.obtIDFeuilleDeTempsCourante());
	}

	@Test
	public void testAjouterIdFeuilleDeTemps() throws Exception {
		ArrayList<String> feuillesDeTemps = new ArrayList<String>();
		
		Employe employe = new Employe();
		feuillesDeTemps.add("Feuille1");
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		assertEquals(feuillesDeTemps,employe.obtIDFeuillesDeTemps());
		
		employe.ajouterIdFeuilleDeTemps("Feuille1");
		assertEquals(feuillesDeTemps,employe.obtIDFeuillesDeTemps());
	}

}
