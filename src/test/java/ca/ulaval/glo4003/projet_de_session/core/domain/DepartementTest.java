package ca.ulaval.glo4003.projet_de_session.core.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.EmployeIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;

@RunWith(MockitoJUnitRunner.class)

public class DepartementTest {
/*
	public static Departement departement;
	public static Employe employe1;
	public static Employe employe2;
	public static Employe employe;
	public static String employeTraite="MOMEC10";
	public static String employeTraite1="MOMEC101";
	public static String employeTraite2="MOMEC102";
	public static String employeNonTrouve="Non Touve";
	private static ArrayList<Employe> employes;
	
	
@Before
	public void setUp() throws Exception {
	departement = new Departement();
	employes = new ArrayList<Employe>();

	employe1 = Mockito.spy(new Employe());
	employe2 = Mockito.spy(new Employe());
	employe = Mockito.spy(new Employe());
	Mockito.doReturn(employeTraite1).when(employe1).obtNomUtilisateur();
	Mockito.doReturn(employeTraite2).when(employe2).obtNomUtilisateur();
	Mockito.doReturn(employeTraite).when(employe).obtNomUtilisateur();
	employes.add(employe1);
	employes.add(employe2);
	departement.setEmployes(employes);
	
	}

@Test
	public void testAjouterEmploye() {	
	
	departement.ajouterEmploye(employe);
	employes.add(employe);
	assertEquals(employes,departement.obtEmployes());
	}

@Test
	public void testEnleverEmploye() {
	System.out.println(departement.obtEmploye(employeTraite2).obtNomUtilisateur());
	departement.enleverEmploye(employeTraite2);
	employes.remove(employe2);
	assertEquals(employes,departement.obtEmployes());
	}



@Test
	public void testobtEmploye() {	
	
	assertEquals(employe1,departement.obtEmploye(employeTraite1));
		}


@Test(expected=EmployeIntrouvableException.class)
	public void testObtUnEmployeIntrouvable() {
	departement.obtEmploye(employeNonTrouve);
}

*/
}
