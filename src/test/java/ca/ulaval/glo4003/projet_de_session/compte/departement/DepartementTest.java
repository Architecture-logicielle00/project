package ca.ulaval.glo4003.projet_de_session.compte.departement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class DepartementTest {
	
	private static Departement departement;

	private String nom = "nom";
	
	@Before
	public void setUp() throws Exception {
		departement = new Departement(nom);
	}
	
	@Test
	public void obtNomDepartementTest(){
		assertEquals(nom,departement.obtNomDepartement());
	}

	@Test
	public void changerNomDepartement(){
		String nouveauNom = "nouveauNom";
		
		departement.setNomDepartement(nouveauNom);
		
		assertEquals(nouveauNom,departement.obtNomDepartement());
	}
	
	@Test
	public void obtenirEntrepriseTest(){
		assertEquals(null, departement.obtEntreprise());
	}
	
	@Test
	public void assignerEntreprise(){
		String ent = "ent";
		
		departement.setEntreprise(ent);
		
		assertEquals(ent,departement.obtEntreprise());
	}
	
	@Test
	public void obtenirProjetVideTest(){
		assertEquals(0,departement.obtProjets().size());
	}
	
	@Test
	public void obtenirNomProjetVideTest(){
		assertEquals(0,departement.obtNomProjets().size());
	}
	
	@Test
	public void assigationProjetTest(){
		List<Projet> projets = new ArrayList<Projet>();
		
		int nbProjet = 5;
		
		for (int i = 0; i < nbProjet; i++){
			projets.add(Mockito.mock(Projet.class));
		}
		
		departement.setProjets(projets);
		
		assertEquals(nbProjet, departement.obtProjets().size());
	}
	
	@Test
	public void obtNomProjetsTest(){
		List<Projet> projets = new ArrayList<Projet>();
		
		int nbProjet = 5;
		
		for (int i = 0; i < nbProjet; i++){
			Projet projet = Mockito.mock(Projet.class);
			Mockito.when(projet.obtNom()).thenReturn(Integer.toString(i));
			projets.add(projet);
		}
		
		departement.setProjets(projets);
		
		assertEquals(nbProjet, departement.obtProjets().size());
	}
	
	@Test
	public void ajouterNomProjetTest(){
		int nbProjet = 1;
		
		Projet projet = Mockito.mock(Projet.class);

		departement.ajouterProjet(projet);
		
		assertEquals(nbProjet, departement.obtProjets().size());
	}
	
	@Test
	public void enleverNomProjetTest(){
		int nbProjet = 0;
		
		Projet projet = Mockito.mock(Projet.class);

		departement.ajouterProjet(projet);
		departement.enleverProjet(projet);
		
		assertEquals(nbProjet, departement.obtProjets().size());
	}
	
	@Test
	public void obtenirEmployeVideTest(){
		assertEquals(0, departement.obtEmployes().size());
	}
	
	@Test
	public void assigationEmployeTest(){
		List<String> employes = new ArrayList<String>();
		
		int nbEmploye = 5;
		
		for (int i = 0; i < nbEmploye; i++){
			employes.add(Integer.toString(i));
		}
		
		departement.setEmployes(employes);
		
		assertEquals(nbEmploye, departement.obtEmployes().size());
	}
	
	@Test
	public void ajouterEmployeTest(){		
		int nbEmploye = 1;
		
		departement.ajouterEmploye("employes");
		
		assertEquals(nbEmploye,departement.obtEmployes().size());
	}
	
	@Test
	public void enleverEmployeTest(){		
		int nbEmploye = 0;
		
		departement.ajouterEmploye("employes");
		departement.enleverEmploye("employes");
		
		assertEquals(nbEmploye, departement.obtEmployes().size());
	}
	
	@Test
	public void contientEmployeTest(){		
		String nom = "nom";
		
		departement.ajouterEmploye(nom);
		
		assertTrue(departement.containEmploye(nom));
	}
	
	@Test
	public void neContientPasEmployeTest(){		
		String nom = "nom";
		
		assertFalse(departement.containEmploye(nom));
	}
}
