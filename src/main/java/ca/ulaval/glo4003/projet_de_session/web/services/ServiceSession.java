package ca.ulaval.glo4003.projet_de_session.web.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

@Service
public class ServiceSession implements IServiceSession 
{
	public Boolean chargerUtilisateurInformation(HttpServletRequest request, Model model)
	{
		UtilisateurViewModel user = (UtilisateurViewModel)request.getSession().getAttribute("UtilisateurSession");
		
		Boolean utilisateurConnecter = user != null;
		
		if (utilisateurConnecter)
			model.addAttribute("utilisateur", user);
		
		return utilisateurConnecter;
	}
	
	public String ObtenirNomUtilisateur(HttpServletRequest request){
		UtilisateurViewModel utilisateur = obtenirUtilisateurSession(request);
		
		if (utilisateur == null)
			return "";
		
		return utilisateur.obtNomUtilisateur();
	}
	
	public void definirUtilisateur(HttpServletRequest request, UtilisateurViewModel _utilisateurSession)
	{
		HttpSession session = obtenirSessionUtilisateur(request);
		session.setAttribute("UtilisateurSession", _utilisateurSession);
	}
	
	public void logoff(HttpServletRequest request)
	{
		obtenirSessionUtilisateur(request).invalidate();
	}

	private UtilisateurViewModel obtenirUtilisateurSession(HttpServletRequest request){
		return (UtilisateurViewModel)obtenirSessionUtilisateur(request).getAttribute("UtilisateurSession");
	}
	
	private HttpSession obtenirSessionUtilisateur(HttpServletRequest request)
	{
		return request.getSession();
	}
}
