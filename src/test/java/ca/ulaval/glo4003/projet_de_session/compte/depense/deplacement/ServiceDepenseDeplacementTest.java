package ca.ulaval.glo4003.projet_de_session.compte.depense.deplacement;

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

import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacementConverter;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.FactoryDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.RepoDepenseDeplacementXml;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.ServiceDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.repository.xml.Xml;

@RunWith(MockitoJUnitRunner.class)
public class ServiceDepenseDeplacementTest {

	private static DepenseDeplacement DepenseDeplacement1;

	private static Xml<DepenseDeplacement> xmlDepenseDeplacement;
	private static ArrayList<DepenseDeplacement> sauvegardeCollection;
	private static Repository<DepenseDeplacement> repoDepenseDeplacementXml;
	private static Float un;
	private static Float deux;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		xmlDepenseDeplacement = new Xml<DepenseDeplacement>(
				DepenseDeplacement.class);
		sauvegardeCollection = (ArrayList<DepenseDeplacement>) xmlDepenseDeplacement
				.charger("xmlfiles/depensesDeplacement");
		Mockito.when(DepenseDeplacement1.obtCoutKm()).thenReturn(un);
		Mockito.when(DepenseDeplacement1.obtDistance()).thenReturn(deux);
		Mockito.when(DepenseDeplacement1.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDeplacement1.obtDescription()).thenReturn("test");
		Mockito.when(DepenseDeplacement1.obtSoumissionnaire()).thenReturn(
				"ALSAM");
		Mockito.when(DepenseDeplacement1.obtTime()).thenReturn("123");
		Mockito.when(DepenseDeplacement1.obtIdentifiant()).thenReturn(
				"ALSAM2010-11-14123");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlDepenseDeplacement.enregistrer(sauvegardeCollection,
				"xmlfiles/depensesDeplacement");
	}
	@Before
	public void setUp() throws Exception {
		xmlDepenseDeplacement.enregistrer(new ArrayList<DepenseDeplacement>(),
				"xmlfiles/depensesDeplacement");
		repoDepenseDeplacementXml = new RepoDepenseDeplacementXml();

		assertEquals(new HashMap<String, DepenseDeplacement>(),
				repoDepenseDeplacementXml.obtMap());
	}

	@Test
	public void testObtDepense() {
		String id = DepenseDeplacement1.obtSoumissionnaire()
				+ DepenseDeplacement1.obtDate() + DepenseDeplacement1.obtTime();
		repoDepenseDeplacementXml.ajouter(DepenseDeplacement1);
		List<DepenseDeplacement> ColDepense = new ArrayList<DepenseDeplacement>();
		ColDepense.add(DepenseDeplacement1);
		ServiceDepenseDeplacement serviceDepense = new ServiceDepenseDeplacement(
				repoDepenseDeplacementXml);
		assertEquals(ColDepense, serviceDepense.obtParUtilisateur(id));
	}
}