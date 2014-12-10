package ca.ulaval.glo4003.projet_de_session.compte.employe;

import static org.junit.Assert.*;

import java.util.Date;

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
		
		emp.setInformationPersonelle(new InformationPersonnelle(
				"nom",
				"prenom",
				"email",
				"pays",
				"province",
				"ville",
				"codePostal",
				new Date(), //TODO: gros smell de la mort
				"sexe",
				"telephone")
		);
		emp.statutGestionnaire = true;
		
		return emp;
	}
	
	private boolean estIdentique(Employe emp, EmployeeViewModel empView)
	{
		return 
				empView.nom == emp.getInformationPersonelle().nom &&
				empView.prenom == emp.getInformationPersonelle().prenom &&
				empView.email == emp.getInformationPersonelle().email &&
				empView.pays == emp.getInformationPersonelle().pays &&
				empView.province == emp.getInformationPersonelle().province &&
				empView.ville == emp.getInformationPersonelle().ville &&
				empView.codePostal == emp.getInformationPersonelle().codePostal &&
				empView.sexe == emp.getInformationPersonelle().genre &&
				empView.telephone == emp.getInformationPersonelle().numTelephone &&
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
