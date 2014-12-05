package ca.ulaval.glo4003.projet_de_session.compte.employe;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.RepoEmployeXml;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.repository.xml.Xml;

@RunWith(MockitoJUnitRunner.class)
public class ServiceEmployeTest {

	private static Employe employe1; 
	private static Employe employe2; 
	private static Employe employe3; 
	
	private static Xml<Employe> xmlEmploye;
	private static ArrayList<Employe> sauvegardeCollection;
	private static Repository<Employe> repoEmployeXml;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xmlEmploye = new Xml<Employe>(Employe.class);
		sauvegardeCollection = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
		
		employe1 = Mockito.mock(Employe.class);
		Mockito.when(employe1.obtNomUtilisateur()).thenReturn("nomUtilisateur1");
		Mockito.when(employe1.motDePasseValide("mdp")).thenReturn(true);
		Mockito.when(employe1.obtEntreprise()).thenReturn("entreprise2");
		Mockito.when(employe1.estEmployeDe("entreprise2")).thenReturn(true);
		
		employe2 = Mockito.mock(Employe.class);
		Mockito.when(employe2.obtNomUtilisateur()).thenReturn("nomUtilisateur2");
		Mockito.when(employe2.obtEntreprise()).thenReturn("entreprise1");
		Mockito.when(employe2.estEmployeDe("entreprise1")).thenReturn(true);
		
		employe3 = Mockito.mock(Employe.class);
		Mockito.when(employe3.obtNomUtilisateur()).thenReturn("nomUtilisateur3");
		Mockito.when(employe3.obtEntreprise()).thenReturn("entreprise3");
		Mockito.when(employe3.estEmployeDe("entreprise3")).thenReturn(true);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlEmploye.enregistrer(sauvegardeCollection, "xmlfiles/employes");
	}

	@Before
	public void setUp() throws Exception {
		xmlEmploye.enregistrer(new ArrayList<Employe>(), "xmlfiles/employes");
		repoEmployeXml = new RepoEmployeXml();
		
		assertEquals(new HashMap<String,Employe>(), repoEmployeXml.obtMap());
	}

	@Test
	public void testObtEmployesParEntreprise() {
		repoEmployeXml.ajouter(employe1);
		repoEmployeXml.ajouter(employe2);
		repoEmployeXml.ajouter(employe3);
		
		List<Employe> entreprise1 = new ArrayList<Employe>();
		entreprise1.add(employe2);
		ServiceEmploye serviceEmployeTest = new ServiceEmploye(repoEmployeXml);
		
		assertEquals(entreprise1, serviceEmployeTest.obtEmployesParEntreprise("entreprise1"));
	}
}