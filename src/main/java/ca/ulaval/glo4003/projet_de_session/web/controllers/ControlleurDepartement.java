package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.ServiceDepartement;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.utils.Reponse;

@Controller

public class ControlleurDepartement {
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	ServiceDepartement serviceDepartement;
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