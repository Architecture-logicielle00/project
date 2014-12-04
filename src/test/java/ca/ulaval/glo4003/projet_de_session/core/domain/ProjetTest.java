package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;

@RunWith(MockitoJUnitRunner.class)
public class ProjetTest {
	
	private static Projet projet; 
	private static Tache tache1;
	private static Tache tache2;

	@Before
	public void setUp() throws Exception {
		projet = new Projet();
		tache1 = Mockito.mock(Tache.class);
		tache2 = Mockito.mock(Tache.class);
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
