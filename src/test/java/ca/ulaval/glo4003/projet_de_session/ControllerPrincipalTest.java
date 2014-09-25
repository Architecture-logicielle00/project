package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import ca.ulaval.glo4003.projet_de_session.web.controllers.AccesModel;
import ca.ulaval.glo4003.projet_de_session.web.controllers.ControllerPrincipal;
import ca.ulaval.glo4003.projet_de_session.web.controllers.GestionSessionController;

public class ControllerPrincipalTest {
	
	private ControllerPrincipal ObtenirControlleurTest()
	{
		return new ControllerPrincipal(new AccesModel(),new GestionSessionController());
	}
	
	@Test
	public void rendersLogin() {
		HttpServletRequestTest req = new HttpServletRequestTest();
		assertEquals("login", ObtenirControlleurTest().login(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersIndex() {
		HttpServletRequestTest req = new HttpServletRequestTest();
		req.setAttribute("nomUtilisateur", "Jeff");
		req.setAttribute("mdp", "12345");
		
		assertEquals("index", ObtenirControlleurTest().connection(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersErreuLogin() {
		HttpServletRequestTest req = new HttpServletRequestTest();
		req.setAttribute("nomUtilisateur", "MauvaisUser");
		req.setAttribute("mdp", "98765");
		
		assertEquals("erreur", ObtenirControlleurTest().connection(req,new ExtendedModelMap()));
	}
}