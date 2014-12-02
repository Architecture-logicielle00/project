package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.ServiceDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

@Controller
public class ControleurDeplacement {
	private static class Page {
		public static final String CONNECTION = "login";
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
	@Autowired
	private IServiceSession manageSession;

	public ControleurDeplacement() {

	}

	public ControleurDeplacement(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}

	@RequestMapping("/deplacementForm")
	public String depenseDeplacement(HttpServletRequest request, Model model) {

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
	public @ResponseBody List<DepenseDeplacementViewModel> obtenirDeplacements(
			Model model, @PathVariable String utilisateur) {
		return serviceDepenseDeplacement.obtParUtilisateur(utilisateur);
	}

	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.CONNECTION;
	}

}
