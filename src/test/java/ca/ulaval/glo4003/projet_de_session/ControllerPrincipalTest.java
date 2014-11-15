package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.controllers.ControllerPrincipal;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;

public class ControllerPrincipalTest {
	
	private ControllerPrincipal ObtenirControlleurTest(Boolean utilisateurExiste)
	{
		ServiceSession session = Mockito.mock(ServiceSession.class);
		Mockito.when(session.chargerUtilisateurInformation(Mockito.any(HttpServletRequest.class), Mockito.any(Model.class))).thenReturn(utilisateurExiste);
		return new ControllerPrincipal(session,new ServiceEmploye());
	}
	
	@Test
	public void rendersLogin() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		Mockito.when(req.getParameter("nomUtilisateur")).thenReturn("MauvaisUser");
		Mockito.when(req.getParameter("mdp")).thenReturn("98765");

		assertEquals("login", ObtenirControlleurTest(false).connection(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersIndex() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		Mockito.when(req.getParameter("nomUtilisateur")).thenReturn("JFGRA");
		Mockito.when(req.getParameter("mdp")).thenReturn("12345");

		assertEquals("index", ObtenirControlleurTest(true).login(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersErreuLogin() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		Mockito.when(req.getParameter("nomUtilisateur")).thenReturn("MauvaisUser");
		Mockito.when(req.getParameter("mdp")).thenReturn("98765");
		
		assertEquals("login", ObtenirControlleurTest(false).connection(req,new ExtendedModelMap()));
	}
}