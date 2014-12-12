package ca.ulaval.glo4003.projet_de_session.compte.depense.diverse;

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
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.RepoDepenseDiverseXml;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.repository.xml.Xml;

@RunWith(MockitoJUnitRunner.class)
public class ServiceDepenseDiverseTest {
	private static DepenseDiverse DepenseDiverse1;
	private static Xml<DepenseDiverse> xmlDepenseDiverse;
	private static ArrayList<DepenseDiverse> sauvegardeCollection;
	private static Repository<DepenseDiverse> repoDepenseDiverseXml;
	private static Float un;
	private static Float deux;
	private static Float trois;
	private static Integer quatre;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		xmlDepenseDiverse = new Xml<DepenseDiverse>(DepenseDiverse.class);
		sauvegardeCollection = (ArrayList<DepenseDiverse>) xmlDepenseDiverse
				.charger("xmlfiles/depensesDiverse");
		DepenseDiverse1 = Mockito.mock(DepenseDiverse.class);
		Mockito.when(DepenseDiverse1.obtCoucher()).thenReturn(un);
		Mockito.when(DepenseDiverse1.obtCoutRepas()).thenReturn(deux);
		Mockito.when(DepenseDiverse1.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDiverse1.obtDescription()).thenReturn("test");
		Mockito.when(DepenseDiverse1.obtDivers()).thenReturn(trois);
		Mockito.when(DepenseDiverse1.obtSoumissionnaire()).thenReturn("ALSAM");
		Mockito.when(DepenseDiverse1.obtNbRepas()).thenReturn(quatre);
		Mockito.when(DepenseDiverse1.obtTime()).thenReturn("123");
		Mockito.when(DepenseDiverse1.obtIdentifiant()).thenReturn(
				"ALSAM2010-11-14123");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlDepenseDiverse.enregistrer(sauvegardeCollection, "xmlfiles/depensesDiverse");
	}
	@Before
	public void setUp() throws Exception {
		xmlDepenseDiverse.enregistrer(new ArrayList<DepenseDiverse>(), "xmlfiles/depensesDiverse");
		repoDepenseDiverseXml = new RepoDepenseDiverseXml();
		assertEquals(new HashMap<String,DepenseDiverse>(), repoDepenseDiverseXml.obtMap());
	}
	@Test
	public void testObtDepense() {
		String id = DepenseDiverse1.obtSoumissionnaire()
				+ DepenseDiverse1.obtDate() + DepenseDiverse1.obtTime();
		repoDepenseDiverseXml.ajouter(DepenseDiverse1);
		List<DepenseDiverse> ColDepense = new ArrayList<DepenseDiverse>();
		ColDepense.add(DepenseDiverse1);
		ServiceDepenseDiverse serviceDepense = new ServiceDepenseDiverse(
				repoDepenseDiverseXml);
		assertEquals(ColDepense, serviceDepense.obtParUtilisateur(id));
	}
}