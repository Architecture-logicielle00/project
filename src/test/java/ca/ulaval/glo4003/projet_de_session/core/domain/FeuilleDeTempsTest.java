package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.exception.TacheIntrouvableException;

public class FeuilleDeTempsTest {
	
	private static FeuilleDeTemps feuilleDeTemps;
	private static TempsParTache tempsParTache1;
	private static TempsParTache tempsParTache2;
	private static ArrayList<TempsParTache> tempsParTache;
	private static ArrayList<String> tempsParTacheString;
	

	@Before
	public void setUp() throws Exception {
		feuilleDeTemps = new FeuilleDeTemps();
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
	
}
