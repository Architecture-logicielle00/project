package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class EntrepriseTest {

	Entreprise entreprise;

	private String nomUtilisateur = "nomUtilisateur";
	private String mdp = "mdp";
	private String nom = "nom";

	private Departement departement1;
	private Departement departement2;

	List<Projet> listProjetDep1;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		entreprise = new Entreprise(nomUtilisateur, mdp, nom);

		List<String> listEmployeDep1 = new ArrayList<String>();
		listEmployeDep1.add("Archi");
		listEmployeDep1.add("tecture");

		List<String> listEmployeDep2 = new ArrayList<String>();
		listEmployeDep2.add("EmployeDep2_1");
		listEmployeDep2.add("EmployeDep2_2");

		listProjetDep1 = new ArrayList<Projet>();
		Projet projet1 = Mockito.mock(Projet.class);
		Projet projet2 = Mockito.mock(Projet.class);
		listProjetDep1.add(projet1);
		listProjetDep1.add(projet2);

		departement1 = Mockito.mock(Departement.class);
		Mockito.when(departement1.obtNomDepartement()).thenReturn("dep1");
		Mockito.doReturn(listEmployeDep1).when(departement1).obtEmployes();
		Mockito.doReturn(listProjetDep1).when(departement1).obtProjets();

		departement2 = Mockito.mock(Departement.class);
		Mockito.when(departement2.obtNomDepartement()).thenReturn("dep2");
		Mockito.doReturn(listEmployeDep2).when(departement2).obtEmployes();

	}

	@Test
	public void getDepartementParEmployeTest() {
		entreprise.addDepartement(departement1);
		entreprise.addDepartement(departement2);

		assertEquals(departement1, entreprise.getDepartementParEmploye("Archi"));
		assertNotEquals(departement1,
				entreprise.getDepartementParEmploye("EmployeDep2_1"));
		assertEquals(null,
				entreprise.getDepartementParEmploye("employeExistePas"));
	}

	@Test
	public void getDepartementsTest() {
		entreprise.addDepartement(departement1);
		entreprise.addDepartement(departement2);

		List<Departement> departements = new ArrayList<Departement>();
		departements.add(departement1);
		departements.add(departement2);

		assertEquals(departements, entreprise.getDepartements());
	}

	@Test
	public void getProjetsParDepartementTest() {
		entreprise.addDepartement(departement1);
		entreprise.addDepartement(departement2);

		assertEquals(listProjetDep1,
				entreprise.getProjetsParDepartement("dep1"));
		assertEquals(new ArrayList<Projet>(),
				entreprise.getProjetsParDepartement("departementExistePas"));
	}

	@Test
	public void deleteDepartementTest() {
		entreprise.createDepartement("DepTest1");
		Departement departementTest2 = entreprise.createDepartement("DepTest2");
		entreprise.deleteDepartement("DepTest1");

		ArrayList<Departement> listeDepartementAttendue = new ArrayList<Departement>();
		listeDepartementAttendue.add(departementTest2);

		assertEquals(listeDepartementAttendue, entreprise.getDepartements());
	}

	@Test
	public void getDepartementTest() {
		entreprise.createDepartement("DepTest1");
		Departement departementTest2 = entreprise.createDepartement("DepTest2");

		assertEquals(departementTest2, entreprise.getDepartement("DepTest2"));
	}

}
