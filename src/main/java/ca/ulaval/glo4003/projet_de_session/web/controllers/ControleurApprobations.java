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

import ca.ulaval.glo4003.projet_de_session.approbation.ApprobationViewModel;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.ServiceDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.DepenseDeplacementViewModel;

@Controller
public class ControleurApprobations {

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

	public ControleurApprobations() {

	}

	public ControleurApprobations(IServiceSession _manageSession) {
		manageSession = _manageSession;
	}

	@RequestMapping("/gestionapprobation")
	public String obtenirGestionApprobation(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("gestionApprobation", request, model);
	}
	
	@RequestMapping(value = "{departement}/approbations")
	public @ResponseBody List<ApprobationViewModel> obtenirApprobations(
			Model model, @PathVariable String departement) {
		//return serviceDepartement.getDepartementParNom(departement).getApprobationsEnAttente();
		// OU 
		//return SingleDepartement.getApprobationsEnAttente();
		
		return null;
	}
	
	@RequestMapping(value = "{departement}/approbations", method = RequestMethod.POST)
	public @ResponseBody Boolean reponseApprobation(
			Model model, 
			@PathVariable String utilisateur, 
			@RequestBody ApprobationViewModel ApprobationViewModel) {
		
		//return serviceDepartement.getDepartementParNom(departement).put(ApprobationViewModel);
		// OU 
		//return SingleDepartement.put(ApprobationViewModel);
		
		return true;
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
}
