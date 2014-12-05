package ca.ulaval.glo4003.projet_de_session.compte.feuilleDeTemps;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	public void testObtUneTache() {
		assertEquals(tempsParTache1,feuilleDeTemps.obtTempsParTache("Dormir"));
	}
		

	@Test(expected=TacheIntrouvableException.class)
	public void testObtUneTacheIntrouvable() {
		feuilleDeTemps.obtTempsParTache("Sortir");
		
	}
	
	@Test
	public void testEstCourante() {
		assertTrue(feuilleDeTemps.estCourante(DateTime.now().toDate()));
		
	}
	
	@Test
	public void testApartientA() {
		assertTrue(feuilleDeTemps.appartientA("id1"));
	}
	
}
