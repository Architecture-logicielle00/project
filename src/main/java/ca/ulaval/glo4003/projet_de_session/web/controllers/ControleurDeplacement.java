package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.utils.Reponse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@Controller
public class ControleurDeplacement {
	private static class Page {
		public static final String INDEX = "index";
		public static final String ERREUR = "erreurLogin";
		public static final String CONNECTION = "login";
		public static final String CREEUTILISATEUR = "creationEmployeeForm";
		public static final String EMPLOYEEMANAGEMENT = "gestionEmployee";
		public static final String FEUILLEDETEMPS = "feuilleDeTemps";
		public static final String DEPENSEDEPLACEMENT = "deplacementForm";
	}
	
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;
	@Autowired
	ServiceDepenseDeplacement serviceDepenseDeplacement;
	@Autowired
	ServiceDepenseDiverse serviceDepenseDiverse;

	private IServiceSession manageSession;

	public ControleurDeplacement() {
		
	}

	public ControleurDeplacement(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}


	@RequestMapping("/deplacementForm")
	public String depenseDeplacement(HttpServletRequest request, Model model) {

		//model.addAttribute("formulaire", feuilleDeTempsCourante);
		return chargerPageOuLogin(Page.DEPENSEDEPLACEMENT, request, model);
	}

	@RequestMapping(value = "/deplacementFormDeplacement", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderDepenseDeplacement(
			@RequestBody DepenseDeplacementViewModel depenseDeplacementViewModel,
			HttpServletRequest request, Model model) {
		serviceDepenseDeplacement.creer(depenseDeplacementViewModel);
		return true;
	}
	
	@RequestMapping(value = "{utilisateur}/deplacements")
	public @ResponseBody List<DepenseDeplacementViewModel> obtenirDeplacements(Model model, @PathVariable String utilisateur) {
		return serviceDepenseDeplacement.obtParUtilisateur(utilisateur);
	}

	@RequestMapping(value = "/deplacementFormDiverse", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderDepenseDeplacement(
			@RequestBody DepenseDiverseViewModel depenseDiverseViewModel,
			HttpServletRequest request, Model model) {
		serviceDepenseDiverse.Creer(depenseDiverseViewModel);
		return true;
	}

	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.CONNECTION;
	}
	
}
