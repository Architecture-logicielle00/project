package ca.ulaval.glo4003.projet_de_session.compte.departement.projet;

import static org.junit.Assert.*;
import org.junit.Before;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.FactoryProjet;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class FactoryProjetTest {

	private static FactoryProjet facto;
	
	private String nom = "nom";
	private String description = "description";
	
	@Before
	public void setUp() throws Exception {
		facto = new FactoryProjet();
	}
	
	public void creerProjetSansDescriptionTest(){
		Projet projet = facto.creerProjet(nom);
		
		assertTrue(projet.obtNom() == nom);
	}
	
	public void creerProjetAvecDescriptionTest(){
		Projet projet = facto.creerProjet(nom,description);
		
		assertTrue(projet.obtNom() == nom);
		assertTrue(projet.obtDescription() == description);
	}
	
}
