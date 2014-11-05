package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.utils.Reponse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

@Controller
public class ControlleurEmploye {

	ServiceEmploye serviceEmploye;

	private IServiceSession manageSession;

	public ControlleurEmploye() {
		manageSession = new ServiceSession();
		serviceEmploye = new ServiceEmploye();
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
	public @ResponseBody Reponse creerEmployee(
			@RequestBody EmployeeViewModel evm, HttpServletRequest request,
			Model model) {

		serviceEmploye.creerEmploye(evm);
		return new Reponse(true, "Creer un employe", "gestionEmployee");
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
