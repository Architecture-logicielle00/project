package ca.ulaval.glo4003.projet_de_session.compte.feuilleDeTemps;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.TacheIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.tempsParTache.TempsParTache;

public class FeuilleDeTempsTest {
	
	private static FeuilleDeTemps feuilleDeTemps;
	private static TempsParTache tempsParTache1;
	private static TempsParTache tempsParTache2;
	private static ArrayList<TempsParTache> tempsParTache;
	private static ArrayList<String> tempsParTacheString;
	

	@Before
	public void setUp() throws Exception {
		
		DateTime aujourdhui = DateTime.now();
		DateTime debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY);
		DateTime finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY);
		DateTime finDelaPeriodeCourante = finDelaSemaineCourante.plusWeeks(1);
		
		feuilleDeTemps = new FeuilleDeTemps("id1", debutDelasemaineCourante.toDate(), finDelaPeriodeCourante.toDate());;
		tempsParTache = new  ArrayList<TempsParTache>();
		
		tempsParTacheString = new ArrayList<String>();
		tempsParTacheString.add("Dormir");
		tempsParTacheString.add("Manger");
		
		tempsParTache1 = Mockito.spy(new TempsParTache());
		tempsParTache2 = Mockito.spy(new TempsParTache());
		Mockito.doCallRealMethod().when(tempsParTache1).defTache(Mockito.anyString());
		Mockito.doCallRealMethod().when(tempsParTache2).defTache(Mockito.anyString());
		tempsParTache1.defTache("Dormir");
		tempsParTache2.defTache("Manger");
		
		tempsParTache.add(tempsParTache1);
		tempsParTache.add(tempsParTache2);
		
		feuilleDeTemps.setTaches(tempsParTache);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructeurVide() {
		FeuilleDeTemps feuilleDeTempsVide = new FeuilleDeTemps();
		
		assertEquals(feuilleDeTempsVide.obtDebut(),new Date());
		assertEquals(feuilleDeTempsVide.obtDebut(),new Date());
	}

	@Test
	public void testObtUneTache() {
		assertEquals(tempsParTache1,feuilleDeTemps.obtTempsParTache("Dormir"));
	}
		

	@Test(expected=TacheIntrouvableException.class)
	public void testObtUneTacheIntrouvable() {
		feuilleDeTemps.obtTempsParTache("Sortir");
	}
	
	@Test
	public void testContainsTache() {
		assertTrue(feuilleDeTemps.containsTache("Dormir"));
	}
	
	@Test
	public void testAddTache() {
		feuilleDeTemps.addTache("TacheTest");
		assertTrue(feuilleDeTemps.containsTache("TacheTest"));
	}
	
	@Test
	public void testAddTacheDejaExistante() {
		feuilleDeTemps.addTache("TacheTest");
		feuilleDeTemps.addTache("TacheTest");
		assertTrue(feuilleDeTemps.containsTache("TacheTest"));
	}
	
	@Test
	public void testAddTaches() {
		ArrayList<String> taches = new ArrayList<String>();
		taches.add("tacheTest1");
		taches.add("tacheTest2");
		taches.add("tacheTest3");
		taches.add("tacheTest4");
		taches.add("tacheTest5");

		feuilleDeTemps.addTaches(taches);
		
		assertTrue(feuilleDeTemps.containsTache("tacheTest1"));
		assertTrue(feuilleDeTemps.containsTache("tacheTest2"));
		assertTrue(feuilleDeTemps.containsTache("tacheTest3"));
		assertTrue(feuilleDeTemps.containsTache("tacheTest4"));
		assertTrue(feuilleDeTemps.containsTache("tacheTest5"));
	}
	
	@Test
	public void testSetTaches() {
		ArrayList<String> tachesEspere = new ArrayList<String>();
		tachesEspere.add("tacheTest1");
		tachesEspere.add("tacheTest2");
		tachesEspere.add("tacheTest3");
		tachesEspere.add("tacheTest4");
		tachesEspere.add("tacheTest5");

		feuilleDeTemps.setTaches(tachesEspere);
		
		ArrayList<TempsParTache> tachesReel = feuilleDeTemps.obtTaches();
		
		assertEquals(tachesEspere.get(0), tachesReel.get(0).obtTache());
		assertEquals(tachesEspere.get(1), tachesReel.get(1).obtTache());
		assertEquals(tachesEspere.get(2), tachesReel.get(2).obtTache());
		assertEquals(tachesEspere.get(3), tachesReel.get(3).obtTache());
		assertEquals(tachesEspere.get(4), tachesReel.get(4).obtTache());
	}
	
	@Test
	public void testAddTempsParTache(){
		TempsParTache tempsParTache = new TempsParTache("tacheTest", 7);
		
		feuilleDeTemps.addTempsParTache(tempsParTache);
		
		ArrayList<TempsParTache> tempsParTachesListe = feuilleDeTemps.obtTaches();
		
		assertEquals(tempsParTachesListe.get(tempsParTachesListe.size() - 1), tempsParTache);
	}
	
	
	@Test
	public void testEstCourante() {
		assertTrue(feuilleDeTemps.estCourante(DateTime.now().toDate()));
	}
	
	@Test
	public void testNEstPasCourante() {
		assertFalse(feuilleDeTemps.estCourante(DateTime.now().withYear(1990).toDate()));
	}
	
	@Test
	public void testApartientA() {
		assertTrue(feuilleDeTemps.appartientA("id1"));
	}
	
}
