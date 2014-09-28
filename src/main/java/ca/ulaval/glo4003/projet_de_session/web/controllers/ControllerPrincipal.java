package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryEmployee;
import ca.ulaval.glo4003.projet_de_session.dao.RepositoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IAccesModel;
import ca.ulaval.glo4003.projet_de_session.imodel.IGestionSession;
import ca.ulaval.glo4003.projet_de_session.model.Employee;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.converters.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.web.converters.FeuilleDeTempsConverter;
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
	
	private IGestionSession manageSession;
	
	private RepositoryEmployee repositoryEmployee;
	private RepositoryFeuilleDeTemps repositoryFeuilleDeTemps;
	
	private FeuilleDeTempsConverter feuilleDeTempsConverter;
	private EmployeeConverter employeeConverter;
	
	public ControllerPrincipal() {
		manageSession = new GestionSessionController();
		
		repositoryEmployee = new RepositoryEmployee();
		repositoryFeuilleDeTemps = new RepositoryFeuilleDeTemps();
		feuilleDeTempsConverter = new FeuilleDeTempsConverter();
		employeeConverter = new EmployeeConverter() ;
	}
	
	public ControllerPrincipal(IAccesModel _accesModel, IGestionSession _manageSession) {
		manageSession = _manageSession; 
	}

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) 
	{
		return chargerPageOuLogin(Page.INDEX,request,model);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) 
	{
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
		
	    
	    Utilisateur utilisateur = repositoryEmployee.obtenirParNom(nomUtilisateur);
		boolean connectionValide = utilisateur.motDePasseValide(mdp);

		if (connectionValide)
		{
			EmployeeViewModel utilisateurSession = employeeConverter.convert((Employee)utilisateur);
			manageSession.definirUtilisateur(request,utilisateurSession);
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
	
	
	@RequestMapping(value = "/creationEmployee", method = RequestMethod.POST)
	public String creerEmployee(HttpServletRequest request, Model model) 
	{  
	    String name = request.getParameter("name");
	    String prenom= request.getParameter("prenom");
	    String email = request.getParameter("email");
	    String username = request.getParameter("username");
	    String pays = request.getParameter("pays");
	    String province = request.getParameter("province");
	    String ville = request.getParameter("ville");
	    String codePostal = request.getParameter("codepos");
	    String motDePasse = request.getParameter("password");
	    String moisDenaissance = request.getParameter("BirthMonth");
	    String jourDeNaissance = request.getParameter("BirthDay");
	    String anneeDeNaissance = request.getParameter("BirthYear");
	    String genre = request.getParameter("gender");
	    String numTelephone = request.getParameter("phone");
	    
	    Employee nouvelEmployee = new Employee(username,
	    		motDePasse,
	    		name,
	    		prenom,
	    		email,
	    		pays,
	    		province,
	    		ville,
	    		codePostal,
	    		moisDenaissance,
	    		jourDeNaissance,
	    		anneeDeNaissance,
	    		genre,
	    		numTelephone);
	    repositoryEmployee.ajouter(nouvelEmployee);
	    
		return chargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	
	@RequestMapping("/gestionEmployee")
	public String accederGestionEmployee(HttpServletRequest request, Model model) {
		
		model.addAttribute("employees", employeeConverter.convert(repositoryEmployee.obtenirTout()));
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

	
	private String chargerPageOuLogin(String _page, HttpServletRequest request, Model model)
	{
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.LOGIN;
	}
}
