package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementViewModel;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverseViewModel;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;


@Controller
public class ControllerAssignation {
	@Autowired
	ServiceEntreprise serviceEntreprise;
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	IServiceSession manageSession;
	
	ControllerAssignation(){}
	
	@RequestMapping("/departement/projets")
	public @ResponseBody DepartementViewModel obtenirProjetsDepartements(HttpServletRequest request, Model model) {

		return getViewModel();
	}
	
	@RequestMapping(value = "/departement/projets" , method = RequestMethod.POST)
	public @ResponseBody boolean setProjetsDepartements(
			@RequestBody DepartementViewModel departementViewModel,
			HttpServletRequest request,
			Model model) {
		assignerTaches(departementViewModel);
		return true;
	}
	
	
	private void assignerTaches(DepartementViewModel departementViewModel)
	{
			serviceEmploye.assignerTachesAEmployes(departementViewModel.employesTachesViewModels);
	}
	
	private DepartementViewModel getViewModel()
	{
		return serviceEntreprise.getDepartementViewModelParEmploye("OLDU");
	}
}
