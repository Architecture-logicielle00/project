package ca.ulaval.glo4003.projet_de_session.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.imodel.IGestionSession;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UserViewModel;

public class GestionSessionController implements IGestionSession 
{
	public Boolean ChargerUtilisateurInformation(HttpServletRequest request, Model model)
	{
		UserViewModel user = (UserViewModel)request.getSession().getAttribute("UtilisateurSession");
		
		Boolean utilisateurConnecter = user != null;
		
		if (utilisateurConnecter)
			model.addAttribute("utilisateur", user);
		
		return utilisateurConnecter;
	}
	
	public void SetUtilisateur(HttpServletRequest request, String _userName)
	{
		HttpSession session = ObtenirSessionUtilisateur(request);
		UserViewModel user = new UserViewModel(_userName);
		session.setAttribute("UtilisateurSession",user);
	}
	
	public void Logoff(HttpServletRequest request)
	{
		ObtenirSessionUtilisateur(request).invalidate();
	}

	
	private HttpSession ObtenirSessionUtilisateur(HttpServletRequest request)
	{
		return request.getSession();
	}
}
