package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.core.services.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.old.IAccesModel;
import ca.ulaval.glo4003.projet_de_session.old.RepositoryEmployee;
import ca.ulaval.glo4003.projet_de_session.old.RepositoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.old.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.web.services.IServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.services.ServiceSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.BlocDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

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
	private RepositoryFeuilleDeTemps repositoryFeuilleDeTemps;
	
	private FeuilleDeTempsConverter feuilleDeTempsConverter;
	
	public ControllerPrincipal() {
		manageSession = new ServiceSession();
		repositoryFeuilleDeTemps = new RepositoryFeuilleDeTemps();
		feuilleDeTempsConverter = new FeuilleDeTempsConverter();		
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
	
	//Done
	@RequestMapping(value = "/creationEmployee", method = RequestMethod.POST)
	public String creerEmployee(HttpServletRequest request, Model model) 
	{  
		serviceEmploye.creerEmploye(request.getParameter("username"),
	    		request.getParameter("password"),
	    		request.getParameter("name"),
	    		request.getParameter("prenom"),
	    		"defaultEntreprise",
	    		request.getParameter("email"),
	    		request.getParameter("pays"),
	    		request.getParameter("province"),
	    		request.getParameter("ville"),
	    		request.getParameter("codepos"),
	    		Integer.valueOf( request.getParameter("BirthDay") ),
	    		Integer.valueOf( request.getParameter("BirthMonth") ),
	    		Integer.valueOf ( request.getParameter("BirthYear") ),
	    		request.getParameter("gender"),
	    		request.getParameter("phone"));
		
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	@RequestMapping("/gestionEmployee")
	public String accederGestionEmployee(HttpServletRequest request, Model model) {
		model.addAttribute( "employees", serviceEmploye.obtEmployesViewModel() );
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	@RequestMapping("/feuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {
		
		UtilisateurViewModel utilisateurCourant = manageSession.obtenirUtilisateurSession(request);
		
		FeuilleDeTempsViewModel feuilleDeTempsBidon = new FeuilleDeTempsViewModel();
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2014, 04, 01);
		
		feuilleDeTempsBidon.debutPeriode = cal.getTime();
		
		cal.set(2014, 04, 02);
		feuilleDeTempsBidon.finPeriode = cal.getTime();
		feuilleDeTempsBidon.employe = "David";
		feuilleDeTempsBidon.blocsDeTemps = new ArrayList<BlocDeTempsViewModel>();
		
		BlocDeTempsViewModel test = new BlocDeTempsViewModel();
		test.dateDuJour = "2014-04-01";
		test.nbHeures = 5;
		test.nomProjet = "KJHkjjhkjk";
		test.nomTache = "jhghjhgk";
		test.numProjet = "1234";
		test.numTache= "#1234-12";
		
		BlocDeTempsViewModel test1 = new BlocDeTempsViewModel();
		test1.dateDuJour = "2014-04-02";
		test1.nbHeures = 6;
		test1.nomProjet = "KJHkfsdfdsjhkjk";
		test1.nomTache = "jhgdsfsdgk";
		test1.numProjet = "1234";
		test1.numTache= "#1234-12";
		
		feuilleDeTempsBidon.blocsDeTemps.add(test);
		feuilleDeTempsBidon.blocsDeTemps.add(test1);
		
		
		FeuilleDeTempsViewModel viewModel = feuilleDeTempsBidon;//feuilleDeTempsConverter.convert(repositoryFeuilleDeTemps.obtenirParUtilisateur(utilisateurCourant.nomUsager));
		model.addAttribute("feuilleDeTemps", viewModel);
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
