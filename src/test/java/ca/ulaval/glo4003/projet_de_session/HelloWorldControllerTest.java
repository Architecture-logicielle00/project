package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import ca.ulaval.glo4003.projet_de_session.web.controllers.HelloWorldController;

public class HelloWorldControllerTest {
	
	@Test
	public void rendersLogin() {
		assertEquals("login", new HelloWorldController().login());
	}
	
	@Test
	public void rendersIndex() {
		HttpServletRequestTest req = new HttpServletRequestTest();
		req.setAttribute("nomUtilisateur", "Jeff");
		req.setAttribute("mdp", "12345");
		
		assertEquals("index", new HelloWorldController().connection(req,new ExtendedModelMap()));
	}
	
	@Test
	public void rendersErreuLogin() {
		HttpServletRequestTest req = new HttpServletRequestTest();
		req.setAttribute("nomUtilisateur", "MauvaisUser");
		req.setAttribute("mdp", "98765");
		
		assertEquals("erreur", new HelloWorldController().connection(req,new ExtendedModelMap()));
	}
}