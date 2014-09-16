package ca.ulaval.glo4003.projet_de_session;

import static org.junit.Assert.*;
import org.junit.Test;
import ca.ulaval.glo4003.projet_de_session.web.controllers.HelloWorldController;

public class HelloWorldControllerTest {
	
	@Test
	public void rendersIndex() {
		assertEquals("index", new HelloWorldController().index());
	}

}

//Hello