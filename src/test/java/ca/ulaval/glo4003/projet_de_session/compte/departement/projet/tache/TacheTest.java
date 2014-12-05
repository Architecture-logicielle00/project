package ca.ulaval.glo4003.projet_de_session.compte.departement.projet.tache;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.Tache;

public class TacheTest {

	private Tache tache;
	
	private String nom;
	private String description;
	
	@Before
	public void setUp() throws Exception {
		tache = new Tache(nom,description);
	}
	
	@Test
	public void changerNom(){
		String nouveauNom = "nouveauNom";
		
		tache.changerNom(nouveauNom);
		
		assertTrue(tache.obtNom().equals(nouveauNom));
	}
	
	@Test
	public void changerDescription(){
		String nouvelleDescription = "nouvelleDescription";
		
		tache.changerDescription(nouvelleDescription);
		
		assertTrue(tache.obtDescription().equals(nouvelleDescription));
	}
}
