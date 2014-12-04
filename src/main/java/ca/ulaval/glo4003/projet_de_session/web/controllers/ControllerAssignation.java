package ca.ulaval.glo4003.projet_de_session.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.DepartementViewModel;
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
	
	void getViewModel()
	{
		DepartementViewModel departementViewModel = serviceEntreprise.getDepartementViewModelParEmploye("OLDU");
	}
	
	void assignerTaches(DepartementViewModel departementViewModel)
	{
		serviceEmploye.assignerTachesAEmployes(departementViewModel.employesTachesViewModels);
	}
	
}
