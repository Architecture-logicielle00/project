package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;

@Controller
public class ControlleurEmploye {
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	private IServiceSession manageSession;

	public ControlleurEmploye() {
	}

	public ControlleurEmploye(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}

	@RequestMapping("/creationEmployee")
	public String obtenirPageCreationEmployee(HttpServletRequest request,
			Model model) {
		return chargerPageOuLogin("creationEmployeeForm", request, model);
	}

	@RequestMapping(value = "/creationEmployee", method = RequestMethod.POST)
	public boolean creerEmployee(
			@RequestBody EmployeViewModel evm, HttpServletRequest request,
			Model model) {

		serviceEmploye.creerEmploye(evm, manageSession.ObtenirNomUtilisateur(request));
		return true;
	}

	@RequestMapping("/gestionEmployee")
	public String accederGestionEmployee(HttpServletRequest request, Model model) {
		model.addAttribute("employees", serviceEmploye.obtEmployesViewModel());
		return chargerPageOuLogin("gestionEmployee", request, model);
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
	
}
