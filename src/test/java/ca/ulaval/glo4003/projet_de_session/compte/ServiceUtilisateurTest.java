package ca.ulaval.glo4003.projet_de_session.compte;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.Entreprise;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;

public class ServiceUtilisateurTest {
	private String nomTest = "NomTest";
	private String mdpTest = "MotsPasseTest";
	
	@InjectMocks
	private ServiceUtilisateur serviceUtilisateurTest;
	@Spy
	private ServiceEmploye serviceEmploye;
	@Spy
	private ServiceEntreprise serviceEntreprise;
	 
	@Before 
	public void initMocks(){
	       MockitoAnnotations.initMocks(this);
	}
	
/*	@Test
	public void obtenirEmploye() {
		Employe empTest = new Employe();
		empTest.nomUtilisateur = nomTest;
		Mockito.when(serviceEmploye.obtEmploye(nomTest)).thenReturn(empTest);
		
		Utilisateur empResultat = serviceUtilisateurTest.obtenirUtilisateur(nomTest);
		
		assertEquals(empTest.nomUtilisateur, empResultat.nomUtilisateur);
	}
	
	@Test
	public void obtenirEntreprise() {
		Entreprise entrepriseTest = new Entreprise(nomTest,"","");
		entrepriseTest.nomUtilisateur = nomTest;
		Mockito.when(serviceEmploye.obtEmploye(nomTest)).thenReturn(null);
		Mockito.when(serviceEntreprise.obtEntreprise(nomTest)).thenReturn(entrepriseTest);
		
		Utilisateur entrepriseResultat = serviceUtilisateurTest.obtenirUtilisateur(nomTest);
		
		assertEquals(entrepriseTest.nomUtilisateur, entrepriseResultat.nomUtilisateur);
	}
	
	@Test
	public void obtenirNull() {
		Mockito.when(serviceEmploye.obtEmploye(nomTest)).thenReturn(null);
		Mockito.when(serviceEntreprise.obtEntreprise(nomTest)).thenReturn(null);
		
		Utilisateur resultatNull = serviceUtilisateurTest.obtenirUtilisateur(nomTest);
		
		assertEquals(resultatNull, null);
	}*/
	
	@Test
	public void verifierBonMotDePasse() {
		Employe empTest = Mockito.mock(Employe.class);
		Mockito.when(empTest.motDePasseEstValide(mdpTest)).thenReturn(true);
		Mockito.when(serviceEmploye.obtEmploye(nomTest)).thenReturn(empTest);
		
		assertTrue(serviceUtilisateurTest.verifierMotDePasse(nomTest, mdpTest));
	}
	
	@Test
	public void verifierMauvaisMotDePasse() {
		Employe empTest = Mockito.mock(Employe.class);
		Mockito.when(empTest.motDePasseEstValide(mdpTest)).thenReturn(false);
		Mockito.when(serviceEmploye.obtEmploye(nomTest)).thenReturn(empTest);

		assertTrue(!serviceUtilisateurTest.verifierMotDePasse(nomTest, mdpTest));
	}
}
