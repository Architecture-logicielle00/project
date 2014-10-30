package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoEmployeXmlTest {

	private static RepoEmployeXml repoEmployeXml;
	
	private static Employe employe1; 
	private static Employe employe2; 
	
	private static Xml<Employe> xmlEmploye;
	private static ArrayList<Employe> sauvegardeCollection;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xmlEmploye = new Xml<Employe>(Employe.class);
		
		sauvegardeCollection = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
		
		repoEmployeXml = new RepoEmployeXml();
		
		
		employe1 = Mockito.mock(Employe.class);
		Mockito.when(employe1.obtNomUtilisateur()).thenReturn("nomUtilisateurTest1");
		Mockito.when(employe1.obtCodePostal()).thenReturn("codePostalTest1");
		Mockito.when(employe1.obtEmail()).thenReturn("emailTest1");
		Mockito.when(employe1.obtEntreprise()).thenReturn("entrepriseTest1");
		Mockito.when(employe1.obtGenre()).thenReturn("genreTest1");
		Mockito.when(employe1.obtNom()).thenReturn("nomTest1");
		
		employe2 = Mockito.mock(Employe.class);
		Mockito.when(employe2.obtNomUtilisateur()).thenReturn("nomUtilisateurTest2");
		Mockito.when(employe2.obtCodePostal()).thenReturn("codePostalTest2");
		Mockito.when(employe2.obtEmail()).thenReturn("emailTest2");
		Mockito.when(employe2.obtEntreprise()).thenReturn("entrepriseTest2");
		Mockito.when(employe2.obtGenre()).thenReturn("genreTest2");
		Mockito.when(employe2.obtNom()).thenReturn("nomTest2");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlEmploye.enregistrer(sauvegardeCollection, "xmlfiles/employes");
	}

	@Before
	public void setUp() throws Exception {
		xmlEmploye.enregistrer(new ArrayList<Employe>(), "xmlfiles/employes");
		repoEmployeXml = new RepoEmployeXml();
		
		assertEquals(new ArrayList<Employe>(), repoEmployeXml.obtMap());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAjouter() {
		repoEmployeXml.ajouter(employe1);
		
		assertEquals(employe1, repoEmployeXml.obt("nomUtilisateurTest1"));
	}

	@Test
	public void testObtenir() {
		repoEmployeXml.ajouter(employe1);
		
		assertEquals(employe1, repoEmployeXml.obt("nomUtilisateurTest1"));
	}

	@Test
	public void testObtEmployes() {
		repoEmployeXml.ajouter(employe1);
		repoEmployeXml.ajouter(employe2);
		
		ArrayList<Employe> employes= new ArrayList<Employe>();
		employes.add(employe1);
		employes.add(employe2);
		
		assertEquals(employes, repoEmployeXml.obtMap());
	}

	@Test
	public void testSupprimer() {
		repoEmployeXml.ajouter(employe1);
		repoEmployeXml.ajouter(employe2);
		
		ArrayList<Employe> employes1= new ArrayList<Employe>();
		employes1.add(employe1);
		employes1.add(employe2);
		
		assertEquals(employes1, repoEmployeXml.obtMap());
		
		repoEmployeXml.supprimer("nomUtilisateurTest2");
		
		ArrayList<Employe> employes2= new ArrayList<Employe>();
		employes2.add(employe1);
		
		assertEquals(employes2, repoEmployeXml.obtMap());

	}

	@Test
	public void testModifier() {
		repoEmployeXml.ajouter(employe1);
		
		Employe employe3 = Mockito.mock(Employe.class);
		Mockito.when(employe3.obtNomUtilisateur()).thenReturn("nomUtilisateurTest1");
		Mockito.when(employe3.obtEmail()).thenReturn("emailTestModifie");
		
		repoEmployeXml.modifier(employe3);
		
		assertEquals("emailTestModifie", repoEmployeXml.obt("nomUtilisateurTest1").obtEmail());

		
		
		
		
	}

}
