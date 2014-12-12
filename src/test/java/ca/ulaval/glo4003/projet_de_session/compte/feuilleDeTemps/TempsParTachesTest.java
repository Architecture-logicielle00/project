package ca.ulaval.glo4003.projet_de_session.compte.feuilleDeTemps;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.tempsParTache.TempsParTache;

public class TempsParTachesTest {
	
	private TempsParTache tempsParTaches;

	@Before
	public void setUp() throws Exception {
		tempsParTaches = new TempsParTache();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTempsParTacheStringInt() {
		tempsParTaches= new TempsParTache("tacheTest", 7);
		
		assertEquals(tempsParTaches.obtTache(), "tacheTest");
		assertEquals(tempsParTaches.obtNbHeuresParJours().size(), 7);
	}

	@Test
	public void testDefNbHeuresParJours() {
		ArrayList<Float> nbHeuresParJours = new ArrayList<Float>();
		nbHeuresParJours.add(1f);
		nbHeuresParJours.add(2f);
		nbHeuresParJours.add(3f);
		nbHeuresParJours.add(4f);
		nbHeuresParJours.add(5f);
		nbHeuresParJours.add(6f);
		
		tempsParTaches.defNbHeuresParJours(nbHeuresParJours);
		
		assertEquals(tempsParTaches.obtNbHeuresParJours(), nbHeuresParJours);
	}

}
