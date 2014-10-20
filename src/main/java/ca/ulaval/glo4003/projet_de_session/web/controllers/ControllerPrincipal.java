package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.utils.Reponse;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@Controller
public class ControllerPrincipal {
	private static class Page {
		public static final String INDEX = "index";
		public static final String ERREUR = "erreurLogin";
		public static final String CONNECTION = "login";
		public static final String CREEUTILISATEUR = "creationEmployeeForm";
		public static final String EMPLOYEEMANAGEMENT = "gestionEmployee";
		public static final String FEUILLEDETEMPS = "feuilleDeTemps";
		public static final String DEPENSEDEPLACEMENT = "deplacementForm";
	}

	ServiceEmploye serviceEmploye;
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;


	private IServiceSession manageSession;

	public ControllerPrincipal() {
		manageSession = new ServiceSession();
		serviceEmploye = new ServiceEmploye();
		serviceFeuilleDeTemps = new ServiceFeuilleDeTemps();
	
	}

	public ControllerPrincipal(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		return chargerPageOuLogin(Page.INDEX, request, model);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) {
		String nomUtilisateur = request.getParameter("nomUtilisateur");
		String mdp = request.getParameter("mdp");

		if (serviceEmploye.verifierMotDePasse(nomUtilisateur, mdp)) {
			manageSession.definirUtilisateur(request,
					serviceEmploye.obtEmployeViewModel(nomUtilisateur));

			return chargerPageOuLogin(Page.INDEX, request, model);
		} else
		{
			model.addAttribute("nomUtilisateur", nomUtilisateur);
			return Page.ERREUR;
		}
	}

	@RequestMapping("/deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.logoff(request);
		return chargerPageOuLogin(Page.CONNECTION, request, model);
	}

	@RequestMapping("/creationEmployee")
	public String obtenirPageCreationEmployee(HttpServletRequest request,
			Model model) {
		return chargerPageOuLogin(Page.CREEUTILISATEUR, request, model);
	}
	
	@RequestMapping(value = "/creationEmployee", method = RequestMethod.POST)
	public @ResponseBody Reponse creerEmployee(
			@RequestBody EmployeeViewModel evm,
			HttpServletRequest request, Model model) {
		
		serviceEmploye.creerEmploye(evm);
		return new Reponse(true, "Creer un employe", chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT, request, model) );
	}

	@RequestMapping("/gestionEmployee")
	public String accederGestionEmployee(HttpServletRequest request, Model model) {
		model.addAttribute("employees", serviceEmploye.obtEmployesViewModel());
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT, request, model);
	}

	@RequestMapping("/feuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {
		
		String nomUtilisateurSession = manageSession.ObtenirNomUtilisateur(
				request);

		if (StringUtils.isEmpty(nomUtilisateurSession))
			return chargerPageOuLogin(Page.FEUILLEDETEMPS, request, model);
			
		Employe employe = serviceEmploye.obtEmploye(nomUtilisateurSession);
		
		String idFeuilleDeTempsCourante;
		try{
			idFeuilleDeTempsCourante = employe.obtIDFeuilleDeTempsCourante();
		}
		catch(Exception e)
		{
			idFeuilleDeTempsCourante = serviceFeuilleDeTemps
					.creerFeuilleDeTempsCourante(employe);
			employe.ajouterIdFeuilleDeTemps(idFeuilleDeTempsCourante);
			serviceEmploye.modifierEmploye(employe);
		}


		FeuilleDeTempsViewModel feuilleDeTempsCourante = serviceFeuilleDeTemps
				.obtFeuilleDeTempsViewModel(idFeuilleDeTempsCourante);
		model.addAttribute("feuilleDeTemps", feuilleDeTempsCourante);

		return chargerPageOuLogin(Page.FEUILLEDETEMPS, request, model);
	}

	@RequestMapping(value = "/feuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps(
			@RequestBody FeuilleDeTempsViewModel feuilleDeTempsViewModel,
			HttpServletRequest request, Model model) {
		serviceFeuilleDeTemps.modifierFeuilleDeTemps(feuilleDeTempsViewModel);

		boolean sauvegardeEffectueAvecSucces = true;

		return sauvegardeEffectueAvecSucces;
	}

	@RequestMapping("/deplacementForm")
	public String depenseDeplacement(HttpServletRequest request, Model model) {
		
		//model.addAttribute("formulaire", feuilleDeTempsCourante);
		return chargerPageOuLogin(Page.DEPENSEDEPLACEMENT, request, model);
	}

	@RequestMapping(value = "/deplacementFormDeplacement", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderDepenseDeplacement(
			@RequestBody DepenseDeplacement depenseDeplacement,
			HttpServletRequest request, Model model) {
		//en attendant passage de depensediverse et depensedeplacement
		return true;
	}
	
	@RequestMapping(value = "/deplacementFormDiverse", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderDepenseDeplacement(
			@RequestBody DepenseDiverse depenseDiverse,
			HttpServletRequest request, Model model) {
		//en attendant passage de depensediverse et depensedeplacement
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
