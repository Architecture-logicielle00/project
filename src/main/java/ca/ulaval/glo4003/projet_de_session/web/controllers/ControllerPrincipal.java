package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;

@Controller
public class ControllerPrincipal {
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	private IServiceSession manageSession;

	public ControllerPrincipal() {
	}

	public ControllerPrincipal(IServiceSession _manageSession, ServiceEmploye _serviceEmploye) {
		manageSession = _manageSession;
		serviceEmploye = _serviceEmploye;
	}

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("index", request, model);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) {
		String nomUtilisateur = request.getParameter("nomUtilisateur");
		String mdp = request.getParameter("mdp");

		if (serviceEmploye.verifierMotDePasse(nomUtilisateur, mdp)) {
			manageSession.definirUtilisateur(request,
					serviceEmploye.obtEmployeViewModel(nomUtilisateur));

			return chargerPageOuLogin("index", request, model);
		} else
			return chargerPageOuLogin("erreurLogin", request, model);
	}

	@RequestMapping("/deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.logoff(request);
		return chargerPageOuLogin("login", request, model);
	}
	
	@RequestMapping("/gestionTaches")
	public String obtenirGestionTaches(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("gestionTaches", request, model);
	}
	
	@RequestMapping("/gestionapprobation")
	public String obtenirGestionApprobation(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("gestionApprobation", request, model);
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
}
