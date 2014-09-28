package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.imodel.IGestionSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

public class GestionSessionController implements IGestionSession 
{
	public Boolean chargerUtilisateurInformation(HttpServletRequest request, Model model)
	{
		UtilisateurViewModel user = (UtilisateurViewModel)request.getSession().getAttribute("UtilisateurSession");
		
		Boolean utilisateurConnecter = user != null;
		
		if (utilisateurConnecter)
			model.addAttribute("utilisateur", user);
		
		return utilisateurConnecter;
	}
	
	public UtilisateurViewModel obtenirUtilisateurSession(HttpServletRequest request){
		return (UtilisateurViewModel)obtenirSessionUtilisateur(request).getAttribute("UtilisateurSession");
	}
	
	public void definirUtilisateur(HttpServletRequest request, String _userName)
	{
		HttpSession session = obtenirSessionUtilisateur(request);
		UtilisateurViewModel user = new UtilisateurViewModel(_userName);
		session.setAttribute("UtilisateurSession",user);
	}
	
	public void logoff(HttpServletRequest request)
	{
		obtenirSessionUtilisateur(request).invalidate();
	}

	
	private HttpSession obtenirSessionUtilisateur(HttpServletRequest request)
	{
		return request.getSession();
	}
}
