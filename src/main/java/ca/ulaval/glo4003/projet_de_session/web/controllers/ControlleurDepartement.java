package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;

@Controller

public class ControlleurDepartement {
	@Autowired
	ServiceEmploye serviceEmploye;
	/*
	@Autowired
	ServiceDepartement serviceDepartement;
	*/
	@Autowired
	private IServiceSession manageSession;

	public ControlleurDepartement() {}

	public ControlleurDepartement(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}
	@RequestMapping("/creationDepartement")
	public String obtenirPageCreationDepartement(HttpServletRequest request,
			Model model) {
		return chargerPageOuLogin("creationDepartementForm", request, model);
	}
	
	@RequestMapping("/gestionTachesDepartement")
	public String accederPageDepartement(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("gestionTaches", request, model);
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
	
}
