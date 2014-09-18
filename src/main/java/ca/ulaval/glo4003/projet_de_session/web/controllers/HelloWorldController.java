package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

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
	public String connection(HttpServletRequest request) {
		// TODO plugger class confirmant le loggin
		
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
		
		boolean connectionValide = nomUtilisateur.equals("Jeff") && mdp.equals("12345");
		
		if (connectionValide)
			return "index";
		else
			return "erreur";
	}
}
