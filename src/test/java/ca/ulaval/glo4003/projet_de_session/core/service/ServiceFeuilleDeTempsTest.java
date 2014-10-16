package ca.ulaval.glo4003.projet_de_session.core.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@RunWith(MockitoJUnitRunner.class)
public class ServiceFeuilleDeTempsTest {
	ServiceFeuilleDeTemps serviceFeuilleDeTemps = Mockito.mock(ServiceFeuilleDeTemps.class);
	FeuilleDeTemps feuille=Mockito.mock(FeuilleDeTemps.class);
	FeuilleDeTempsViewModel feuille1=Mockito.mock(FeuilleDeTempsViewModel.class);

	Employe employe=Mockito.mock(Employe.class);
	String IDchercher ="bonne feuille";
	String IDcreer;
	HashMap<String, FeuilleDeTemps> feuilles=null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);//initialisation des trois mocks, c'est le travail du ServiceFeuilleDeTemps
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testServiceFeuilleDeTemps() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testObtFeuilleDeTemps() {
		Mockito.when(serviceFeuilleDeTemps.obtFeuilleDeTemps(IDchercher)).thenReturn(feuille);
	}

	@Test
	public void testSuppFeuilleDeTemps() {
		DateTime aujourdhui = DateTime.now();
		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		IDcreer=serviceFeuilleDeTemps.creerFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);
		serviceFeuilleDeTemps.suppFeuilleDeTemps(IDcreer);
		assertEquals(serviceFeuilleDeTemps.obtFeuilleDeTemps(IDcreer),feuilles);
	}

	@Test
	public void testCreerFeuilleDeTemps() {
		DateTime aujourdhui = DateTime.now();
		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		String id=serviceFeuilleDeTemps.creerFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);
		assertTrue(serviceFeuilleDeTemps.obtFeuilleDeTemps(id)!=feuille);
		}

	@Test
	public void testCreerFeuilleDeTempsCourante() {
		DateTime aujourdhui = DateTime.now();
		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		DateTime finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY);
		DateTime finDelaPeriodeCourante = finDelaSemaineCourante.plusWeeks(1);
		Date finDelaPeriodeCourante1=finDelaPeriodeCourante.toDate();
		String id=serviceFeuilleDeTemps.creerFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaPeriodeCourante1);
		assertTrue(serviceFeuilleDeTemps.obtFeuilleDeTemps(id)!=feuille);	}

	@Test
	public void testModifierFeuilleDeTemps() {
		DateTime aujourdhui = DateTime.now();
		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		String id=serviceFeuilleDeTemps.creerFeuilleDeTempsCourante(employe);

		serviceFeuilleDeTemps.modifierFeuilleDeTemps(id, feuille);
		assertTrue(serviceFeuilleDeTemps.obtFeuilleDeTemps(id)!=feuille);
	}

	
	@Test
	public void testModifierFeuilleDeTempsFeuilleDeTempsViewModel() {
		DateTime aujourdhui = DateTime.now();
		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
		String id=serviceFeuilleDeTemps.creerFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);

		serviceFeuilleDeTemps.modifierFeuilleDeTemps(feuille1);
		assertTrue(serviceFeuilleDeTemps.obtFeuilleDeTemps(id)!=feuille);
		}
	


}
