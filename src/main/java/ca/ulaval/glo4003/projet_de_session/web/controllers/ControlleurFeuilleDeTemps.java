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
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@Controller
public class ControlleurFeuilleDeTemps {
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;
	@Autowired
	private IServiceSession manageSession;

	public ControlleurFeuilleDeTemps() {}

	public ControlleurFeuilleDeTemps(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}


	@RequestMapping("/feuilleDeTemps")
	public String accederPageFeuilleDeTemps(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("feuilleDeTemps", request, model);
	}
	
	@RequestMapping("{utilisateur}/feuilleDeTemps")
	public @ResponseBody FeuilleDeTempsViewModel accederFeuilleDeTempsUtilisateur(Model model, @PathVariable String utilisateur) {
		
		Employe employe = serviceEmploye.obtEmploye(utilisateur);

		try{
			return serviceFeuilleDeTemps.obtFeuilleDeTempsCourante(utilisateur);
		}
		catch(FeuilleDeTempsIntrouvableException e){
			String idFeuilleDeTempsCourante = serviceFeuilleDeTemps
					.createFeuilleDeTempsCourante(employe);
			employe.ajouterIdFeuilleDeTemps(idFeuilleDeTempsCourante);
			serviceEmploye.modifierEmploye(employe);
			
			return serviceFeuilleDeTemps.obtFeuilleDeTempsViewModel(idFeuilleDeTempsCourante);
		}


	}
	

	

	@RequestMapping(value = "{utilisateur}/feuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps(
			@RequestBody FeuilleDeTempsViewModel feuilleDeTempsViewModel,
			HttpServletRequest request, Model model) {
		serviceFeuilleDeTemps.updateFeuilleDeTemps(feuilleDeTempsViewModel);

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
