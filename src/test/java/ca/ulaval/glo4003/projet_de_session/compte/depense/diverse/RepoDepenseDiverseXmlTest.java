package ca.ulaval.glo4003.projet_de_session.compte.depense.diverse;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.RepoDepenseDiverseXml;
import ca.ulaval.glo4003.projet_de_session.repository.xml.Xml;

public class RepoDepenseDiverseXmlTest {

	private static DepenseDiverse DepenseDiverse1;
	private static DepenseDiverse DepenseDiverse2;
	private static Xml<DepenseDiverse> xmlDepenseDiverse;
	private static ArrayList<DepenseDiverse> sauvegardeCollection;
	private static RepoDepenseDiverseXml repoDepenseDiverseXml;
	private static final float un = (float) 15.0;
	private static final float deux = (float) 16.8;
	private static final float trois = (float) 20.9;
	private static final Integer quatre = (Integer) 3;
	private static final float cinq = (float) 20.0;
	private static final float six = (float) 22.8;
	private static final float sept = (float) 234.9;
	private static final Integer huit = (Integer) 4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		xmlDepenseDiverse = new Xml<DepenseDiverse>(DepenseDiverse.class);

		sauvegardeCollection = (ArrayList<DepenseDiverse>) xmlDepenseDiverse
				.charger("xmlfiles/depensesDiverse");

		repoDepenseDiverseXml = new RepoDepenseDiverseXml();
		DepenseDiverse1 = Mockito.mock(DepenseDiverse.class);
		Mockito.when(DepenseDiverse1.obtCoucher()).thenReturn(un);
		Mockito.when(DepenseDiverse1.obtCoutRepas()).thenReturn(deux);
		Mockito.when(DepenseDiverse1.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDiverse1.obtDescription()).thenReturn("test");
		Mockito.when(DepenseDiverse1.obtDivers()).thenReturn(trois);
		Mockito.when(DepenseDiverse1.obtSoumissionnaire()).thenReturn("ALSAM");
		Mockito.when(DepenseDiverse1.obtNbRepas()).thenReturn(quatre);
		Mockito.when(DepenseDiverse1.obtTime()).thenReturn("123");

		repoDepenseDiverseXml = new RepoDepenseDiverseXml();
		DepenseDiverse2 = Mockito.mock(DepenseDiverse.class);
		Mockito.when(DepenseDiverse2.obtCoucher()).thenReturn(cinq);
		Mockito.when(DepenseDiverse2.obtCoutRepas()).thenReturn(six);
		Mockito.when(DepenseDiverse2.obtDate()).thenReturn("2010-11-14");
		Mockito.when(DepenseDiverse2.obtDescription()).thenReturn("oooo");
		Mockito.when(DepenseDiverse2.obtDivers()).thenReturn(sept);
		Mockito.when(DepenseDiverse2.obtSoumissionnaire()).thenReturn("ALSAM");
		Mockito.when(DepenseDiverse2.obtNbRepas()).thenReturn(huit);
		Mockito.when(DepenseDiverse2.obtTime()).thenReturn("123");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		xmlDepenseDiverse.enregistrer(sauvegardeCollection,
				"xmlfiles/depensesDiverse");
	}

	@Before
	public void setUp() throws Exception {
		xmlDepenseDiverse.enregistrer(new ArrayList<DepenseDiverse>(),
				"xmlfiles/depensesDiverse");
		repoDepenseDiverseXml = new RepoDepenseDiverseXml();
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void AjouterDepenseDiverseTest() {
		String id = DepenseDiverse1.obtSoumissionnaire()
				+ DepenseDiverse1.obtDate() + DepenseDiverse1.obtTime();
		repoDepenseDiverseXml.ajouter(DepenseDiverse1);
		assertEquals(repoDepenseDiverseXml.obt(id), DepenseDiverse1);
	}

	@Test
	public void ModifierDepenseDiverseTest() {
		repoDepenseDiverseXml.ajouter(DepenseDiverse1);
		String id = DepenseDiverse2.obtSoumissionnaire()
				+ DepenseDiverse2.obtDate() + DepenseDiverse2.obtTime();
		repoDepenseDiverseXml.modifier(DepenseDiverse2);
		assertEquals(DepenseDiverse2, repoDepenseDiverseXml.obt(id));
	}

	@Test
	public void ObtDepenseDiverseTest() {
		String id = DepenseDiverse1.obtSoumissionnaire()
				+ DepenseDiverse1.obtDate() + DepenseDiverse1.obtTime();
		repoDepenseDiverseXml.ajouter(DepenseDiverse1);
		assertEquals(DepenseDiverse1, repoDepenseDiverseXml.obt(id));
	}

	@Test
	public void PutDepenseDiverseTest() {
		String id = DepenseDiverse1.obtSoumissionnaire()
				+ DepenseDiverse1.obtDate() + DepenseDiverse1.obtTime();
		String iddeux = DepenseDiverse2.obtSoumissionnaire()
				+ DepenseDiverse2.obtDate() + DepenseDiverse2.obtTime();
		repoDepenseDiverseXml.ajouter(DepenseDiverse1);
		repoDepenseDiverseXml.ajouter(DepenseDiverse2);
		HashMap<String, DepenseDiverse> ColDepenseDiverse = new HashMap<String, DepenseDiverse>();
		ColDepenseDiverse.put(id, DepenseDiverse1);
		ColDepenseDiverse.put(iddeux, DepenseDiverse2);
		assertEquals(ColDepenseDiverse, repoDepenseDiverseXml.obtMap());
	}

}
