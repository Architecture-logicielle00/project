package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.domain.TempsParTache;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

@RunWith(MockitoJUnitRunner.class)
public class RepoFeuilleDeTempsXmlTest {

	private static RepoFeuilleDeTempsXml repoFeuilleDeTempsXml;
	private static SimpleDateFormat simpleDateFormat;
	
	private static FeuilleDeTemps feuilleDeTemps; 
	private static String idFeuilleDeTemps;
	
	private static FeuilleDeTemps feuilleDeTemps2; 
	private static String idFeuilleDeTemps2;
	
	private static Xml<FeuilleDeTemps> xmlFeuilleDeTemps;
	private static ArrayList<FeuilleDeTemps> sauvegardeCollection;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		xmlFeuilleDeTemps = new Xml<FeuilleDeTemps>(FeuilleDeTemps.class);
		
		sauvegardeCollection = (ArrayList<FeuilleDeTemps>) xmlFeuilleDeTemps
				.charger("xmlfiles/feuillesDeTemps");
		
		
		repoFeuilleDeTempsXml = new RepoFeuilleDeTempsXml();
				
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		feuilleDeTemps = Mockito.mock(FeuilleDeTemps.class);
		Mockito.when(feuilleDeTemps.obtDebut()).thenReturn(new Date(2014, 02, 17));
		Mockito.when(feuilleDeTemps.obtFin()).thenReturn(new Date(2014, 05, 17));
		Mockito.when(feuilleDeTemps.obtNomEmploye()).thenReturn("TEST1");
		
		idFeuilleDeTemps = 
					feuilleDeTemps.obtNomEmploye() + 
					simpleDateFormat.format(feuilleDeTemps.obtDebut()) +
					simpleDateFormat.format(feuilleDeTemps.obtFin());
		
		feuilleDeTemps2 = Mockito.mock(FeuilleDeTemps.class);
		Mockito.when(feuilleDeTemps2.obtDebut()).thenReturn(new Date(2014, 02, 17));
		Mockito.when(feuilleDeTemps2.obtFin()).thenReturn(new Date(2014, 05, 17));
		Mockito.when(feuilleDeTemps2.obtNomEmploye()).thenReturn("TEST2");
		
		idFeuilleDeTemps2 = 
					feuilleDeTemps2.obtNomEmploye() + 
					simpleDateFormat.format(feuilleDeTemps2.obtDebut()) +
					simpleDateFormat.format(feuilleDeTemps2.obtFin());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlFeuilleDeTemps.enregistrer(sauvegardeCollection, "xmlfiles/feuillesDeTemps");	
	}

	@Before
	public void setUp() throws Exception {
		xmlFeuilleDeTemps.enregistrer(new ArrayList<FeuilleDeTemps>(), "xmlfiles/feuillesDeTemps");
		repoFeuilleDeTempsXml = new RepoFeuilleDeTempsXml();		
	}

	@After
	public void tearDown() throws Exception {
		
	}


	@Test
	public void testAjouter() {
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps);
		
		assertEquals(
				repoFeuilleDeTempsXml.obtenir(idFeuilleDeTemps),
				feuilleDeTemps);
	}

	@Test
	public void testObtenir() {
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps);
		
		assertEquals(feuilleDeTemps, repoFeuilleDeTempsXml.obtenir(idFeuilleDeTemps));
	}

	@Test(expected=FeuilleDeTempsIntrouvableException.class)
	public void testObtenirFeuilleDeTempsIntrouvable(){
		repoFeuilleDeTempsXml.obtenir("idIntrouvable");
	}
	
	@Test
	public void testObtTout() {
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps);
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps2);
		
		Map<String, FeuilleDeTemps> mapFeuilleDeTempsTest = new HashMap<String, FeuilleDeTemps>();
		
		mapFeuilleDeTempsTest.put(idFeuilleDeTemps, feuilleDeTemps);
		
		mapFeuilleDeTempsTest.put(idFeuilleDeTemps2, feuilleDeTemps2);
		
		Map<String, FeuilleDeTemps> collection = repoFeuilleDeTempsXml.obtTout();
		
		for (String key : collection.keySet()) {
			assertEquals(mapFeuilleDeTempsTest.get(key), collection.get(key));
		}		
	}

	@Test
	public void testSupprimer() {

		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps);
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps2);
		
		repoFeuilleDeTempsXml.supprimer(idFeuilleDeTemps2);
		
		Map<String, FeuilleDeTemps> mapFeuilleDeTempsTest = new HashMap<String, FeuilleDeTemps>();
		
		mapFeuilleDeTempsTest.put(idFeuilleDeTemps, feuilleDeTemps);
		
		Map<String, FeuilleDeTemps> collection = repoFeuilleDeTempsXml.obtTout();
		
		for (String key : collection.keySet()) {
			assertEquals(mapFeuilleDeTempsTest.get(key), collection.get(key));
		}
	}

	@Test
	public void testModifier() {

		Mockito.when(feuilleDeTemps.obtUneTache("tache1")).thenReturn(new TempsParTache("une tache", 1));
		Mockito.when(feuilleDeTemps2.obtUneTache("tache1")).thenReturn(new TempsParTache("une autre tache", 1));	
		
		
		
		repoFeuilleDeTempsXml.ajouter(feuilleDeTemps);
		
		String idFeuilleDeTemps = 
				feuilleDeTemps.obtNomEmploye() + 
				simpleDateFormat.format(feuilleDeTemps.obtDebut()) +
				simpleDateFormat.format(feuilleDeTemps.obtFin());
		
		repoFeuilleDeTempsXml.modifier(idFeuilleDeTemps, feuilleDeTemps2);
				
		assertEquals(feuilleDeTemps2, repoFeuilleDeTempsXml.obtenir(idFeuilleDeTemps));
	}

}
