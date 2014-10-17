package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProjetTest {
	
	private static Projet projet; 
	private static Tache tache1;
	private static Tache tache2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		projet = new Projet();
		tache1 = Mockito.mock(Tache.class);
		tache2 = Mockito.mock(Tache.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAjouterTache() {
		
		ArrayList<Tache> listTache = new ArrayList<Tache>();
		listTache.add(tache1);
		projet.ajouterTache(tache1);
		assertEquals(listTache,projet.obtTache());
	}

	@Test
	public void testEnleverTache() {
		projet.ajouterTache(tache1);
		projet.ajouterTache(tache2);
		projet.enleverTache(tache1);
		
		ArrayList<Tache> listTache = new ArrayList<Tache>();
		listTache.add(tache2);
		assertEquals(listTache, projet.obtTache());
	
	}

}
