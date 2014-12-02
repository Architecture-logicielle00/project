package ca.ulaval.glo4003.projet_de_session.web.session;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.compte.UtilisateurViewModel;


public interface IServiceSession {
	public Boolean chargerUtilisateurInformation(HttpServletRequest request, Model model);
	
	public void definirUtilisateur(HttpServletRequest request, UtilisateurViewModel _utilisateurSession);
	
	public void logoff(HttpServletRequest request);
	
	public String ObtenirNomUtilisateur(HttpServletRequest request);
}
