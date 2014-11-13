//package ca.ulaval.glo4003.projet_de_session.core.service;
//
//import static org.junit.Assert.*;
//
//import java.util.Date;
//import java.util.HashMap;
//
//import org.joda.time.DateTime;
//import org.joda.time.DateTimeConstants;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
//import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
//import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
//import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ServiceFeuilleDeTempsTest {
//	ServiceFeuilleDeTemps serviceFeuilleDeTemps = Mockito.mock(ServiceFeuilleDeTemps.class);
//	FeuilleDeTemps feuille=Mockito.mock(FeuilleDeTemps.class);
//	FeuilleDeTempsViewModel feuille1=Mockito.mock(FeuilleDeTempsViewModel.class);
//
//	Employe employe=Mockito.mock(Employe.class);
//	String IDchercher ="bonne feuille";
//	String IDcreer;
//	HashMap<String, FeuilleDeTemps> feuilles=null;
//	
//	@Before
//	public void setUp() throws Exception {
//		 MockitoAnnotations.initMocks(this);
//	}
//
///*	@Test
//	public void testObtFeuilleDeTemps() {
//		Mockito.when(serviceFeuilleDeTemps.getFeuilleDeTemps(IDchercher)).thenReturn(feuille);
//	}
//
//	@Test
//	public void testSuppFeuilleDeTemps() {
//		DateTime aujourdhui = DateTime.now();
//		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
//		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
//		IDcreer=serviceFeuilleDeTemps.createFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);
//		serviceFeuilleDeTemps.deleteFeuilleDeTemps(IDcreer);
//		assertEquals(serviceFeuilleDeTemps.getFeuilleDeTemps(IDcreer),feuilles);
//	}
//
//	@Test
//	public void testCreerFeuilleDeTemps() {
//		DateTime aujourdhui = DateTime.now();
//		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
//		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
//		String id=serviceFeuilleDeTemps.createFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);
//		assertTrue(serviceFeuilleDeTemps.getFeuilleDeTemps(id)!=feuille);
//		}
//
//	@Test
//	public void testCreerFeuilleDeTempsCourante() {
//		DateTime aujourdhui = DateTime.now();
//		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
//		DateTime finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY);
//		DateTime finDelaPeriodeCourante = finDelaSemaineCourante.plusWeeks(1);
//		Date finDelaPeriodeCourante1=finDelaPeriodeCourante.toDate();
//		String id=serviceFeuilleDeTemps.createFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaPeriodeCourante1);
//		assertTrue(serviceFeuilleDeTemps.getFeuilleDeTemps(id)!=feuille);	}
//
//	@Test
//	public void testModifierFeuilleDeTemps() {
//		String id=serviceFeuilleDeTemps.createFeuilleDeTempsCourante(employe);
//
//		serviceFeuilleDeTemps.updateFeuilleDeTemps(id, feuille);
//		assertTrue(serviceFeuilleDeTemps.getFeuilleDeTemps(id)!=feuille);
//	}
//
//	
//	@Test
//	public void testModifierFeuilleDeTempsFeuilleDeTempsViewModel() {
//		DateTime aujourdhui = DateTime.now();
//		Date debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY).toDate();
//		Date finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY).toDate();
//		String id=serviceFeuilleDeTemps.createFeuilleDeTemps(employe,debutDelasemaineCourante,finDelaSemaineCourante);
//
//		serviceFeuilleDeTemps.updateFeuilleDeTemps(feuille1);
//		assertTrue(serviceFeuilleDeTemps.getFeuilleDeTemps(id)!=feuille);
//		}*/
//	
//
//
//}
