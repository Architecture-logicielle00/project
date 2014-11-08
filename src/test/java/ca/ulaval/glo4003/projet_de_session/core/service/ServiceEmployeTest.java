package ca.ulaval.glo4003.projet_de_session.core.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoEmployeXml;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

@RunWith(MockitoJUnitRunner.class)
public class ServiceEmployeTest {

	private static ServiceEmploye serviceEmploye;
	private static Employe employe1; 
	private static Employe employe2; 
	private static Employe employe3; 
	
	private static Xml<Employe> xmlEmploye;
	private static ArrayList<Employe> sauvegardeCollection;
	private static RepoEmployeXml repoEmployeXml;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceEmploye = new ServiceEmploye();
		
		xmlEmploye = new Xml<Employe>(Employe.class);
		sauvegardeCollection = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
		
		
		employe1 = Mockito.mock(Employe.class);
		Mockito.when(employe1.obtNomUtilisateur()).thenReturn("nomUtilisateur1");
		Mockito.when(employe1.motDePasseValide("mdp")).thenReturn(true);
		Mockito.when(employe1.obtEntreprise()).thenReturn("entreprise2");

		
		employe2 = Mockito.mock(Employe.class);
		Mockito.when(employe2.obtNomUtilisateur()).thenReturn("nomUtilisateur2");
		Mockito.when(employe2.obtEntreprise()).thenReturn("entreprise1");

		employe3 = Mockito.mock(Employe.class);
		Mockito.when(employe3.obtNomUtilisateur()).thenReturn("nomUtilisateur3");
		Mockito.when(employe3.obtEntreprise()).thenReturn("entreprise3");		
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
	public void testObtEmployesParEntreprise() {
		repoEmployeXml.ajouter(employe1);
		repoEmployeXml.ajouter(employe2);
		repoEmployeXml.ajouter(employe3);
		
		List<Employe> entreprise1 = new ArrayList<Employe>();
		entreprise1.add(employe1);
		entreprise1.add(employe2);
		assertEquals(entreprise1, serviceEmploye.obtEmployesParEntreprise("entreprise1"));
	}

	
	@Test
	public void testVerifierMotDePasse() {
		assertFalse(serviceEmploye.obtEmploye("nomUtilisateur1") == null);
		assertEquals(serviceEmploye.obtEmploye("nomUtilisateur1").motDePasseValide("mdp"),serviceEmploye.verifierMotDePasse("nomUtilisateur1","mdp"));
		assertFalse(serviceEmploye.verifierMotDePasse("nomUtilisateur5","mdp"));
	}

}