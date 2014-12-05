package ca.ulaval.glo4003.projet_de_session.compte.employe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class EmployeeConverterTest {

	private static EmployeeConverter employeeConverter;

	@Before
	public void setUp() throws Exception {
		employeeConverter = new EmployeeConverter();
	}
	
	private EmployeeViewModel getViewModelTest()
	{
		EmployeeViewModel empView = new EmployeeViewModel();
		
		empView.nom = "nom";
		empView.prenom = "prenom";
		empView.email = "email";
		empView.pays = "pays";
		empView.province = "province";
		empView.ville = "ville";
		empView.codePostal = "codePostal";
		empView.sexe = "sexe";
		empView.telephone = "telephone";
		empView.statutGestionnaire = true;
		
		return empView;
	}
	
	private Employe getEmploye()
	{
		Employe emp = new Employe();
		
		emp.nom = "nom";
		emp.prenom = "prenom";
		emp.email = "email";
		emp.pays = "pays";
		emp.province = "province";
		emp.ville = "ville";
		emp.codePostal = "codePostal";
		emp.genre = "sexe";
		emp.numTelephone = "telephone";
		emp.statutGestionnaire = true;
		
		return emp;
	}
	
	private boolean estIdentique(Employe emp, EmployeeViewModel empView)
	{
		return 
				empView.nom == emp.nom &&
				empView.prenom == emp.prenom &&
				empView.email == emp.email &&
				empView.pays == emp.pays &&
				empView.province == emp.province &&
				empView.ville == emp.ville &&
				empView.codePostal == emp.codePostal &&
				empView.sexe == emp.genre &&
				empView.telephone == emp.numTelephone &&
				empView.statutGestionnaire == emp.statutGestionnaire;
	}
	
	@Test
	public void convertEmploye()
	{
		Employe emp = getEmploye();
		
		EmployeeViewModel empView = EmployeeConverter.convert(emp);
		
		assertTrue(estIdentique(emp,empView));
	}
	
	@Test
	public void convertViewTest()
	{
		EmployeeViewModel empView = getViewModelTest();
		
		Employe emp = employeeConverter.convert(empView);
		
		assertTrue(estIdentique(emp,empView));
	}
}
