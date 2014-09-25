package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.imodel.IAccesModel;
import ca.ulaval.glo4003.projet_de_session.imodel.IGestionSession;
import ca.ulaval.glo4003.projet_de_session.model.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

@Controller
public class ControllerPrincipal 
{
	private IAccesModel accesModel;
	private IGestionSession manageSession;
	
	public ControllerPrincipal() {
		this(new AccesModel(),new GestionSessionController());
	}
	
	public ControllerPrincipal(IAccesModel _accesModel, IGestionSession _manageSession) {
		accesModel = _accesModel;
		manageSession = _manageSession; 
	}
	
	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) 
	{
		if (manageSession.ChargerUtilisateurInformation(request, model))
			return "index";
		else
			return "login";
	}
	
	@RequestMapping("/Deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.Logoff(request);
		return "login";
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
			manageSession.ChargerUtilisateurInformation(request, model);
			return "index";
		}
		else
			return "erreur";
	}
	
	@RequestMapping(value = "/obtenirUserSession", method = RequestMethod.GET)
	public @ResponseBody UserViewModel obtenirUserSession(HttpServletRequest res) {
			UserViewModel user = new UserViewModel("NomUtilisateurTest");
			return user;
	  }
	
	@RequestMapping("/CreeUtilisateur")
	public String creeUtilisateur(HttpServletRequest request, Model model) {
		LoadSession(request,model);
		return "creeUtilisateur";
	}
	
	@RequestMapping(value = "/CreeUtilisateur", method = RequestMethod.POST)
	public String creeUtilisateurConfirmation(HttpServletRequest request, Model model) 
	{
		LoadSession(request,model);
		
		String nomUtilisateurNouveauCompte = request.getParameter("nomUtilisateurNouveauCompte");
	    String mdp = request.getParameter("mdp");
	    
	    model.addAttribute("nouveauCompte", nomUtilisateurNouveauCompte);
	    
	    accesModel.CreerUtilisateur(nomUtilisateurNouveauCompte, mdp);
		
	    model.addAttribute("nomUtilisateur", "");
	    
		return "employeeManagement";
	}
	
	@RequestMapping("/FeuilleDeTemps")
	public String accederFeuilleDeTemps(HttpServletRequest request, Model model) {
		LoadSession(request,model);
		return "timeSheet";
	}
	
	@RequestMapping("/EmployeeManagement")
	public String getEmployeeManagement(HttpServletRequest request, Model model) {
		LoadSession(request,model);
		return "employeeManagement";
	}
	
	@RequestMapping(value="FeuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps( @RequestBody final  FeuilleDeTempsViewModel feuilleDeTemps)
	{
		// Valider la feuilleDeTemps / Sa validité
		
		// Sauvegarder la feuille de temps
		
		boolean sauvegardeEffectueAvecSucces = true;
		
		return sauvegardeEffectueAvecSucces;
	}
	
	@RequestMapping(value="obtenirFeuilleDeTemps", method = RequestMethod.GET)
	public @ResponseBody FeuilleDeTemps obtenirFeuilleDeTemps(HttpServletRequest request, Model model)
	{
		// Récupèré la feuille de temps de l'employé en cours
		FeuilleDeTemps feuilleDeTemps = new FeuilleDeTemps();
		
		// Retournier la feuille de temps
		return feuilleDeTemps;
	}
	
	private void LoadSession(HttpServletRequest request, Model model)
	{
		manageSession.ChargerUtilisateurInformation(request, model);
	}
}
