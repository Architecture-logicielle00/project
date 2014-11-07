package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;

import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.controllers.ControllerPrincipal;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;

public class ControllerPrincipalTest {
	
	private ControllerPrincipal ObtenirControlleurTest()
	{
		return new ControllerPrincipal(new ServiceSession(),new ServiceEmploye());
	}
	
	@Test
	public void rendersLogin() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		assertEquals("login", ObtenirControlleurTest().login(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersIndex() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		Mockito.when(req.getParameter("nomUtilisateur")).thenReturn("JFGRA");
		Mockito.when(req.getParameter("mdp")).thenReturn("12345");

		assertEquals("index", ObtenirControlleurTest().connection(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersErreuLogin() {
		HttpServletRequest req = Mockito.mock(HttpServletRequest.class);
		Mockito.when(req.getParameter("nomUtilisateur")).thenReturn("MauvaisUser");
		Mockito.when(req.getParameter("mdp")).thenReturn("98765");
		
		assertEquals("erreur", ObtenirControlleurTest().connection(req,new ExtendedModelMap()));
	}
}