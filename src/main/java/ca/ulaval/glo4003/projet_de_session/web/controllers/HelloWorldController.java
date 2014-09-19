package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.ulaval.glo4003.projet_de_session.mock.FakeIdentificateur;
import ca.ulval.glo4003.projet_de_session.imodel.IIdentificateur;

@Controller
public class HelloWorldController 
{
	private IIdentificateur identificateur;
	
	public HelloWorldController() {
		identificateur = new FakeIdentificateur();
	}
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) 
	{
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
		
		boolean connectionValide = identificateur.ConnectionValide(nomUtilisateur, mdp);
		
		model.addAttribute("nomUtilisateur", nomUtilisateur);
		
		if (connectionValide)
			return "index";
		else
			return "erreur";
	}
}
