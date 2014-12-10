package ca.ulaval.glo4003.projet_de_session.compte.departement.projet;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;

public class ProjetTest {

	private Projet projet;
	private Projet projet2;
	private static Tache tache1;
	private static Tache tache2;
	
	private String nom;
	private String description;
	
	@Before
	public void setUp() throws Exception {
		projet = new Projet(nom,description);
		projet2 = new Projet(nom);
		tache1 = Mockito.mock(Tache.class);
		tache2 = Mockito.mock(Tache.class);
	}
	
	@Test
	public void changerNom(){
		String nouveauNom = "nouveauNom";
		
		projet.changerNom(nouveauNom);
		
		assertTrue(projet.obtNom().equals(nouveauNom));
	}
	
	@Test
	public void changerDescription(){
		String nouvelleDescription = "nouvelleDescription";
		
		projet.changerDescription(nouvelleDescription);
		
		assertTrue(projet.obtDescription().equals(nouvelleDescription));
	}
	
	@Test
	public void sansTache(){
		int nbTache = 0;
		
		assertTrue(projet.obtTache().size() == nbTache);
	}
	
	@Test
	public void ajouterTache(){
		int nbTache = 1;
		
		Tache tache = Mockito.mock(Tache.class);
		projet.ajouterTache(tache);
		
		assertTrue(projet.obtTache().size() == nbTache);
	}
	
	@Test
	public void enleverTache(){
		int nbTache = 0;
		
		Tache tache = Mockito.mock(Tache.class);
		projet.ajouterTache(tache);
		projet.enleverTache(tache);
		
		assertTrue(projet.obtTache().size() == nbTache);
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
