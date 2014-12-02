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
import ca.ulaval.glo4003.projet_de_session.depense.diverse.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDiverseViewModel;

@Controller
public class ControleurDiverse {
	private static class Page {
		public static final String CONNECTION = "login";
		public static final String DEPENSEDIVERSE = "diverseForm";
	}

	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;
	@Autowired
	ServiceDepenseDiverse serviceDepenseDiverse;
	@Autowired
	private IServiceSession manageSession;

	public ControleurDiverse() {

	}

	public ControleurDiverse(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}

	@RequestMapping("/diverseForm")
	public String depenseDiverse(HttpServletRequest request, Model model) {

		return chargerPageOuLogin(Page.DEPENSEDIVERSE, request, model);
	}

	@RequestMapping(value = "/depensediverse", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderDepenseDiverse(
			@RequestBody DepenseDiverseViewModel depenseDiverseViewModel,
			HttpServletRequest request, Model model) {
		serviceDepenseDiverse.creer(depenseDiverseViewModel);
		return true;
	}
	
	
	@RequestMapping(value = "{utilisateur}/depensediverse")
	public @ResponseBody List<DepenseDiverseViewModel> obtenirDiverse(
			Model model, @PathVariable String utilisateur) {
		return serviceDepenseDiverse.obtParUtilisateur(utilisateur);
	}
	
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.CONNECTION;
	}

}
