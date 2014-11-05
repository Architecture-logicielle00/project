package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@Controller
public class ControlleurFeuilleDeTemps {

	ServiceEmploye serviceEmploye;
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;

	private IServiceSession manageSession;

	public ControlleurFeuilleDeTemps() {
		manageSession = new ServiceSession();
		serviceEmploye = new ServiceEmploye();
		serviceFeuilleDeTemps = new ServiceFeuilleDeTemps();
	}

	public ControlleurFeuilleDeTemps(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}


	@RequestMapping("/feuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {

		String nomUtilisateurSession = manageSession
				.ObtenirNomUtilisateur(request);

		if (StringUtils.isEmpty(nomUtilisateurSession))
			return chargerPageOuLogin("feuilleDeTemps", request, model);;

		Employe employe = serviceEmploye.obtEmploye(nomUtilisateurSession);

		String idFeuilleDeTempsCourante;
		try {
			idFeuilleDeTempsCourante = employe.obtIDFeuilleDeTempsCourante();
		} catch (Exception e) {
			idFeuilleDeTempsCourante = serviceFeuilleDeTemps
					.creerFeuilleDeTempsCourante(employe);
			employe.ajouterIdFeuilleDeTemps(idFeuilleDeTempsCourante);
			serviceEmploye.modifierEmploye(employe);
		}

		FeuilleDeTempsViewModel feuilleDeTempsCourante = serviceFeuilleDeTemps
				.obtFeuilleDeTempsViewModel(idFeuilleDeTempsCourante);
		model.addAttribute("feuilleDeTemps", feuilleDeTempsCourante);

		return chargerPageOuLogin("feuilleDeTemps", request, model);
	}

	@RequestMapping(value = "/feuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps(
			@RequestBody FeuilleDeTempsViewModel feuilleDeTempsViewModel,
			HttpServletRequest request, Model model) {
		serviceFeuilleDeTemps.modifierFeuilleDeTemps(feuilleDeTempsViewModel);

		boolean sauvegardeEffectueAvecSucces = true;

		return sauvegardeEffectueAvecSucces;
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
}
