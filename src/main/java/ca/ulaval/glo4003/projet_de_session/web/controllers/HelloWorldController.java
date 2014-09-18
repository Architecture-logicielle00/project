package ca.ulaval.glo4003.projet_de_session.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController 
{
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postFoos() {
		// TODO plugger class confirmant le loggin
		
		boolean connectionValide = true;
		
		if (connectionValide)
			return "index";
		else
			return "erreur";
	}
}
