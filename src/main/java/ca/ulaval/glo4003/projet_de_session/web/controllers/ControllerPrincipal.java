package ca.ulaval.glo4003.projet_de_session.web.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IAccesModel;
import ca.ulaval.glo4003.projet_de_session.imodel.IGestionSession;
import ca.ulaval.glo4003.projet_de_session.web.converters.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

@Controller
public class ControllerPrincipal 
{
	private static class Page
	{
		public static final String INDEX = "index";
		public static final String ERREUR = "erreur";
		public static final String LOGIN = "login";
		public static final String CREEUTILISATEUR = "creeUtilisateur";
		public static final String EMPLOYEEMANAGEMENT = "employeeManagement";
		public static final String TIMESHEET = "timeSheet";
		
	} 
	
	private IAccesModel accesModel;
	private IGestionSession manageSession;
	
	
	
	private RepositoryUtilisateur repositoryUtilisateur;
	private RepositoryFeuilleDeTemps repositoryFeuilleDeTemps;
	
	private FeuilleDeTempsConverter feuilleDeTempsConverter;
	
	public ControllerPrincipal() {
		accesModel = new AccesModel();
		manageSession = new GestionSessionController();
		
		repositoryUtilisateur = new RepositoryUtilisateur();
		repositoryFeuilleDeTemps = new RepositoryFeuilleDeTemps();
		feuilleDeTempsConverter = new FeuilleDeTempsConverter();
	}
	
	public ControllerPrincipal(IAccesModel _accesModel, IGestionSession _manageSession) {
		accesModel = _accesModel;
		manageSession = _manageSession; 
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) 
	{
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
		
		boolean connectionValide = accesModel.IdentificationValide(nomUtilisateur, mdp);

		if (connectionValide)
		{
			manageSession.SetUtilisateur(request,nomUtilisateur);
			return ChargerPageOuLogin(Page.INDEX,request,model);
		}
		else
			return Page.ERREUR;
	}
	
	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) 
	{
		return ChargerPageOuLogin(Page.INDEX,request,model);
	}
	
	@RequestMapping("/Deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.Logoff(request);
		return ChargerPageOuLogin(Page.LOGIN,request,model);
	}
	
	
	@RequestMapping(value = "/obtenirUserSession", method = RequestMethod.GET)
	public @ResponseBody UtilisateurViewModel obtenirUserSession(HttpServletRequest res) {
			UtilisateurViewModel user = new UtilisateurViewModel("NomUtilisateurTestRetourner");
			return user;
	  }
	
	@RequestMapping("/CreeUtilisateur")
	public String creeUtilisateur(HttpServletRequest request, Model model) {
		return ChargerPageOuLogin(Page.CREEUTILISATEUR,request,model);
	}
	
	/*@RequestMapping(value = "/CreeUtilisateur", method = RequestMethod.POST)
	public String creeUtilisateurConfirmation(HttpServletRequest request, Model model) 
	{
		String nomUtilisateurNouveauCompte = request.getParameter("nomUtilisateurNouveauCompte");
	    String mdp = request.getParameter("mdp");
	    
	    model.addAttribute("nouveauCompte", nomUtilisateurNouveauCompte);
	    
	    accesModel.CreerUtilisateur(nomUtilisateurNouveauCompte, mdp);
		
	    model.addAttribute("nomUtilisateur", "");
	    
		return ChargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}*/
	
	/*@RequestMapping(value = "/CreeUtilisateur", method = RequestMethod.POST)
	public String creeUtilisateurConfirmation(HttpServletRequest request, Model model, @RequestBody final EmployeViewModel nouvelleUtilisateur) 
	{
		String nomUtilisateurNouveauCompte = request.getParameter("nomUtilisateurNouveauCompte");
	    String mdp = request.getParameter("mdp");
	    
	    model.addAttribute("nouveauCompte", nomUtilisateurNouveauCompte);
	    
	    accesModel.CreerUtilisateur(nomUtilisateurNouveauCompte, mdp);
		
	    model.addAttribute("nomUtilisateur", "");
	    
		return ChargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}*/
	
	@RequestMapping(value="/ajax/CreeUtilisateur",method=RequestMethod.POST)
	public  @ResponseBody String  getSearchUserProfiles(@RequestBody EmployeViewModel nouvelleUtilisateur, HttpServletRequest request, Model model) {
	       String nomUtilisateurNouveauCompte = nouvelleUtilisateur.nomUsager;
	       String mdp = nouvelleUtilisateur.mdp;

	       model.addAttribute("nouveauCompte", nomUtilisateurNouveauCompte);
		    
		   accesModel.CreerUtilisateur(nomUtilisateurNouveauCompte, mdp);
			
		   model.addAttribute("nomUtilisateur", "");
		    
		   return ChargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	   }
	
	@RequestMapping("/EmployeeManagement")
	public String getEmployeeManagement(HttpServletRequest request, Model model) {
		return ChargerPageOuLogin(Page.EMPLOYEEMANAGEMENT,request,model);
	}
	
	@RequestMapping("/FeuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {
		
		UtilisateurViewModel utilisateurCourant = manageSession.ObtenirUtilisateurSession(request);
/*		
		FeuilleDeTempsViewModel feuilleDeTempsBidon = new FeuilleDeTempsViewModel();
		feuilleDeTempsBidon.debutPeriode = new Date("2014-04-01");
		feuilleDeTempsBidon.finPeriode = new Date("2014-04-8");
		feuilleDeTempsBidon.employe = "David";
		feuilleDeTempsBidon.blocsDeTemps = new */
		
		
		FeuilleDeTempsViewModel viewModel = feuilleDeTempsConverter.convert(repositoryFeuilleDeTemps.obtenirParUtilisateur(utilisateurCourant.nomUsager));
		model.addAttribute("feuilleDeTemps", viewModel);
		return ChargerPageOuLogin(Page.TIMESHEET,request,model);
	}
	
	@RequestMapping(value="FeuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps(@RequestBody final  FeuilleDeTempsViewModel feuilleDeTemps)
	{
		// Valider la feuilleDeTemps / Sa validit�
		
		// Sauvegarder la feuille de temps
		
		boolean sauvegardeEffectueAvecSucces = true;
		
		return sauvegardeEffectueAvecSucces;
	}

	
	private String ChargerPageOuLogin(String _page, HttpServletRequest request, Model model)
	{
		if (manageSession.ChargerUtilisateurInformation(request, model))
			return _page;
		else
			return Page.LOGIN;
	}
}
