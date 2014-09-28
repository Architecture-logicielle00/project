package ca.ulaval.glo4003.projet_de_session.imodel;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;


public interface IGestionSession {
	public Boolean chargerUtilisateurInformation(HttpServletRequest request, Model model);
	
	public UtilisateurViewModel obtenirUtilisateurSession(HttpServletRequest request);
	
	public void definirUtilisateur(HttpServletRequest request, UtilisateurViewModel _utilisateurSession);
	
	public void logoff(HttpServletRequest request);
}
