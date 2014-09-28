package ca.ulaval.glo4003.projet_de_session.imodel;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;


public interface IGestionSession {
	public Boolean ChargerUtilisateurInformation(HttpServletRequest request, Model model);
	
	public UtilisateurViewModel ObtenirUtilisateurSession(HttpServletRequest request);
	
	public void SetUtilisateur(HttpServletRequest request, String _userName);
	
	public void Logoff(HttpServletRequest request);
}
