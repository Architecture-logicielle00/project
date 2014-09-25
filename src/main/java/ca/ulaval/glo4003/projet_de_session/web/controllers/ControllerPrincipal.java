package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IIdentificateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.mock.FakeIdentificateur;
import ca.ulaval.glo4003.projet_de_session.model.FeuilleDeTemps;

@Controller
public class ControllerPrincipal 
{
	private IIdentificateur identificateur;
	private IRepositoryUtilisateur repoUtilisateur;
	
	public ControllerPrincipal() {
		this(new FakeIdentificateur());
	}
	
	public ControllerPrincipal(IIdentificateur _identificateur) {
		identificateur = _identificateur;
		repoUtilisateur = new RepositoryUtilisateur();
	}
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) 
	{
		String nomUtilisateur = request.getParameter("nomUtilisateur");
	    String mdp = request.getParameter("mdp");
		
		boolean connectionValide = identificateur.ConnectionValide(nomUtilisateur, mdp);
		
		model.addAttribute("nomUtilisateur", nomUtilisateur);
		
		if (connectionValide)
			return "index";
		else
			return "erreur";
	}
	
	@RequestMapping("/CreeUtilisateur")
	public String creeUtilisateur() {
		return "creeUtilisateur";
	}
	
	@RequestMapping(value = "/CreeUtilisateur", method = RequestMethod.POST)
	public String creeUtilisateurConfirmation(HttpServletRequest request, Model model) 
	{
		String nomUtilisateurNouveauCompte = request.getParameter("nomUtilisateurNouveauCompte");
	    String mdp = request.getParameter("mdp");
	    
	    model.addAttribute("nouveauCompte", nomUtilisateurNouveauCompte);
	    
	    repoUtilisateur.AjouterUtilisateur(nomUtilisateurNouveauCompte, mdp);
		
	    model.addAttribute("nomUtilisateur", "");
	    
		return "employeeManagement";
	}
	
	@RequestMapping("/FeuilleDeTemps")
	public String accederFeuilleDeTemps() {
		return "timeSheet";
	}
	
	@RequestMapping(value="FeuilleDeTemps", method = RequestMethod.POST)
	public @ResponseBody Boolean sauvegarderFeuilleDeTemps( @RequestBody final  FeuilleDeTemps feuilleDeTemps)
	{
		// Valider la feuilleDeTemps / Sa validité
		
		// Sauvegarder la feuille de temps
		
		boolean sauvegardeEffectueAvecSucces = true;
		
		return sauvegardeEffectueAvecSucces;
	}
	
	@RequestMapping("/EmployeeManagement")
	public String getEmployeeManagement() {
		return "employeeManagement";
	}
}
