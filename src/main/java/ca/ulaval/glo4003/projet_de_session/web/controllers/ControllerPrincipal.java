package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.ulaval.glo4003.projet_de_session.compte.ServiceUtilisateur;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;
import ca.ulaval.glo4003.projet_de_session.web.session.IServiceSession;

@Controller
public class ControllerPrincipal {
	@Autowired
	ServiceUtilisateur serviceUtilisateur;
	@Autowired
	ServiceEmploye serviceEmploye;
	@Autowired
	ServiceEntreprise serviceEntreprise;
	
	@Autowired
	private IServiceSession manageSession;

	public ControllerPrincipal() {
	}

	public ControllerPrincipal(IServiceSession _manageSession, ServiceEmploye _serviceEmploye) {
		manageSession = _manageSession;
	}

	@RequestMapping("/")
	public String login(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("index", request, model);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String connection(HttpServletRequest request, Model model) {
		String nomUtilisateur = request.getParameter("nomUtilisateur");
		String mdp = request.getParameter("mdp");

		if (serviceUtilisateur.verifierMotDePasse(nomUtilisateur, mdp)) {
			
			if(serviceUtilisateur.estUneEntreprise(nomUtilisateur)){
				manageSession.definirUtilisateur(request,serviceEntreprise.obtEntrepriseViewModel(nomUtilisateur));
				
				return chargerPageOuLogin("indexEntreprise", request, model);
			}
			else if(serviceUtilisateur.estUnEmploye(nomUtilisateur))
			{
				manageSession.definirUtilisateur(request,serviceEmploye.obtEmployeViewModel(nomUtilisateur));

				return chargerPageOuLogin("index", request, model);
			}
			else{
				return chargerPageOuLogin("erreurLogin", request, model);
			}
		} else
			return chargerPageOuLogin("erreurLogin", request, model);
	}

	@RequestMapping("/deconnection")
	public String logout(HttpServletRequest request, Model model) {
		manageSession.logoff(request);
		return chargerPageOuLogin("login", request, model);
	}
	
	@RequestMapping("/gestionTaches")
	public String obtenirGestionTaches(HttpServletRequest request, Model model) {
		return chargerPageOuLogin("gestionTaches", request, model);
	}
	
	private String chargerPageOuLogin(String _page, HttpServletRequest request,
			Model model) {
		if (manageSession.chargerUtilisateurInformation(request, model))
			return _page;
		else
			return "login";
	}
}
