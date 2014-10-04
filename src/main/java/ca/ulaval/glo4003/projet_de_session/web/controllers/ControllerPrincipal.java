package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;


@Controller
public class ControllerPrincipal
{
	private static class Page
	{
		public static final String INDEX = "index";
		public static final String ERREUR = "erreurLogin";
		public static final String LOGIN = "login";
		public static final String CREEUTILISATEUR = "creationEmployeeForm";
		public static final String EMPLOYEEMANAGEMENT = "gestionEmployee";
		public static final String TIMESHEET = "feuilleDeTemps";
		
	} 
	
	ServiceEmploye serviceEmploye;
	
	private IServiceSession manageSession;
	
	
	public ControllerPrincipal() {
		manageSession = new ServiceSession();	
		serviceEmploye = new ServiceEmploye();
	}
	
	public ControllerPrincipal(IServiceSession _manageSession) {
		manageSession = _manageSession; 
	}

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) 
	{
		return chargerPageOuLogin(Page.INDEX,request,model);
	}
	
	//Changer pour method dans ServiceEmploye
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) 
	{
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
	    
	    if(serviceEmploye.verifierMotDePasse(nomUtilisateur, mdp))
	    {
	    	manageSession.definirUtilisateur(request, serviceEmploye.obtEmployeViewModel(nomUtilisateur));
			return chargerPageOuLogin(Page.INDEX,request,model);
	    }
	    else
			return Page.ERREUR;
	}
	
	@RequestMapping("/deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.logoff(request);
		return chargerPageOuLogin(Page.LOGIN,request,model);
	}
	
	@RequestMapping("/creationEmployee")
	public String obtenirPageCreationEmployee(HttpServletRequest request, Model model){  
		return chargerPageOuLogin(Page.CREEUTILISATEUR,request,model);
	}

	@RequestMapping(value = "/creationEmployee", method = RequestMethod.POST)
	public String creerEmployee(HttpServletRequest request, Model model) 
	{ 		
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	@RequestMapping("/gestionEmployee")
	public String accederGestionEmployee(HttpServletRequest request, Model model) {
		model.addAttribute( "employees", serviceEmploye.obtEmployesViewModel() );
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	@RequestMapping("/feuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {
		
		return chargerPageOuLogin(Page.TIMESHEET,request,model);
	}
	
	@RequestMapping(value="feuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps(@RequestBody final  FeuilleDeTempsViewModel feuilleDeTemps)
	{
		// Valider la feuilleDeTemps / Sa validit�
		
		// Sauvegarder la feuille de temps
		
		boolean sauvegardeEffectueAvecSucces = true;
		
		return sauvegardeEffectueAvecSucces;
	}

	//Done
	private String chargerPageOuLogin(String _page, HttpServletRequest request, Model model)
	{
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.LOGIN;
	}
}
