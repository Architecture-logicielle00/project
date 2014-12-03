package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTempsViewModel;

public class FeuilleDeTempsViewModelTest {
	
	private static FeuilleDeTempsViewModel feuilleDeTempsViewModel;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		feuilleDeTempsViewModel = new FeuilleDeTempsViewModel();
		feuilleDeTempsViewModel.debutPeriode = "2014-01-01";
		feuilleDeTempsViewModel.finPeriode = "2014-01-15";
	}

	@Test
	public void testObtListeJoursPeriode() {
		ArrayList<String> listeDatePeriode = new ArrayList<String>();
		
		listeDatePeriode.add("2014-01-01");
		listeDatePeriode.add("2014-01-02");
		listeDatePeriode.add("2014-01-03");
		listeDatePeriode.add("2014-01-04");
		listeDatePeriode.add("2014-01-05");
		listeDatePeriode.add("2014-01-06");
		listeDatePeriode.add("2014-01-07");
		listeDatePeriode.add("2014-01-08");
		listeDatePeriode.add("2014-01-09");
		listeDatePeriode.add("2014-01-10");
		listeDatePeriode.add("2014-01-11");
		listeDatePeriode.add("2014-01-12");
		listeDatePeriode.add("2014-01-13");
		listeDatePeriode.add("2014-01-14");
		listeDatePeriode.add("2014-01-15");
		
		assertEquals(listeDatePeriode, feuilleDeTempsViewModel.obtListeJoursPeriode());
	}

}
