package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import ca.ulaval.glo4003.projet_de_session.mock.FakeIdentificateur;
import ca.ulaval.glo4003.projet_de_session.web.controllers.HelloWorldController;
import ca.ulval.glo4003.projet_de_session.imodel.IIdentificateur;

public class HelloWorldControllerTest {
	
	private HelloWorldController ObtenirControlleurTest()
	{
		return new HelloWorldController(new FakeIdentificateur());
	}
	
	@Test
	public void rendersLogin() {
		assertEquals("login", ObtenirControlleurTest().login());
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