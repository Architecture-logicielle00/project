package ca.ulaval.glo4003.projet_de_session.compte.employe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactoryEmployeTest {

	private static FactoryEmploye facto;

	@Before
	public void setUp() throws Exception {
		facto = new FactoryEmploye();
	}

	private String nomUtilisateur = "nomUtilisateur"; 
	private String nom = "nom";
	private String prenom = "prenom";
	private String email = "email";
	private String pays = "pays";
	private String province = "province";
	private String ville = "ville" ;
	private String codePostal = "codePostal";
	private String genre = "genre"; 
	private String numTelephone = "numTelephone"; 
	private boolean statutGestionnaire = true;
	
	private Boolean estValide(Employe emp)
	{
		return
				emp.obtNomUtilisateur() == nomUtilisateur &&
				emp.getInformationPersonelle().nom == nom &&
				emp.getInformationPersonelle().prenom == prenom &&
				emp.getInformationPersonelle().email == email &&
				emp.getInformationPersonelle().pays == pays &&
				emp.getInformationPersonelle().province == province &&
				emp.getInformationPersonelle().ville == ville &&
				emp.getInformationPersonelle().codePostal == codePostal &&
				emp.getInformationPersonelle().genre == genre &&
				emp.getInformationPersonelle().numTelephone == numTelephone && 
				emp.statutGestionnaire == statutGestionnaire;
	}
	
	@Test
	public void CreeEmployeTest()
	{
		Employe emp = facto.creerEmploye(nomUtilisateur, nom, prenom, email, pays, province, ville, codePostal, genre, numTelephone, statutGestionnaire);
		
		assertTrue(estValide(emp));
	}
}
