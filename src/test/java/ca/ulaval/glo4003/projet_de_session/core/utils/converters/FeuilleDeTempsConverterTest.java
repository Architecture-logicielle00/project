package ca.ulaval.glo4003.projet_de_session.core.utils.converters;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.domain.TempsParTache;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.TempsParTacheViewModel;

public class FeuilleDeTempsConverterTest {
	private static SimpleDateFormat simpleDateFormat;

	private static FeuilleDeTemps feuilleDeTemps;
	private static String idFeuilleDeTemps;

	private static FeuilleDeTemps feuilleDeTemps2;
	private static String idFeuilleDeTemps2;

	private static FeuilleDeTempsViewModel feuilleDeTempsViewModelTest;
	
	private static FeuilleDeTempsConverter feuilleDeTempsConverter;

	
	private static Date createDate(int annee, int mois, int jour){
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, annee);
	    cal.set(Calendar.MONTH, mois);
	    cal.set(Calendar.DAY_OF_MONTH, jour);
	    return cal.getTime();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		feuilleDeTempsConverter = new FeuilleDeTempsConverter();
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		feuilleDeTemps = Mockito.mock(FeuilleDeTemps.class);
		Mockito.when(feuilleDeTemps.obtDebut()).thenReturn(createDate(2014, 02, 17));
		Mockito.when(feuilleDeTemps.obtFin()).thenReturn(createDate(2014, 05, 17));
		Mockito.when(feuilleDeTemps.obtIdentifiant()).thenReturn("TEST1");

		ArrayList<TempsParTache> collectionTempsParTacheFeuille1 = new ArrayList<TempsParTache>();
		collectionTempsParTacheFeuille1.add(new TempsParTache("promener le chien", 1));
		collectionTempsParTacheFeuille1.add(new TempsParTache("dormir", 2));

		Mockito.when(feuilleDeTemps.obtTaches()).thenReturn(collectionTempsParTacheFeuille1);

		
		idFeuilleDeTemps = feuilleDeTemps.obtIdentifiant()
				+ simpleDateFormat.format(feuilleDeTemps.obtDebut())
				+ simpleDateFormat.format(feuilleDeTemps.obtFin());

		
		
		
		feuilleDeTemps2 = Mockito.mock(FeuilleDeTemps.class);
		Mockito.when(feuilleDeTemps2.obtDebut()).thenReturn(createDate(2014, 01, 27));
		Mockito.when(feuilleDeTemps2.obtFin()).thenReturn(createDate(2014, 01, 19));
		Mockito.when(feuilleDeTemps2.obtIdentifiant()).thenReturn("TEST2");

		ArrayList<TempsParTache> collectionTempsParTacheFeuille2 = new ArrayList<TempsParTache>();
		collectionTempsParTacheFeuille2.add(new TempsParTache("promener le chat", 1));
		collectionTempsParTacheFeuille2.add(new TempsParTache("se reveiller", 2));

		Mockito.when(feuilleDeTemps.obtTaches()).thenReturn(collectionTempsParTacheFeuille2);

		idFeuilleDeTemps2 = feuilleDeTemps2.obtIdentifiant()
				+ simpleDateFormat.format(feuilleDeTemps2.obtDebut())
				+ simpleDateFormat.format(feuilleDeTemps2.obtFin());
		
		
		feuilleDeTempsViewModelTest = Mockito.mock(FeuilleDeTempsViewModel.class);
		
		feuilleDeTempsViewModelTest.debutPeriode = "2014-02-17";
		feuilleDeTempsViewModelTest.finPeriode = "2014-05-17";
		feuilleDeTempsViewModelTest.employe = "TEST1";
		
		Mockito.when(feuilleDeTempsViewModelTest.obtDebutPeriode()).thenReturn("2014-02-17");
		Mockito.when(feuilleDeTempsViewModelTest.obtFinPeriode()).thenReturn("2014-05-17");
		Mockito.when(feuilleDeTempsViewModelTest.obtEmploye()).thenReturn("TEST1");

		ArrayList<TempsParTacheViewModel> collectionTempsParTacheViewModels = new ArrayList<TempsParTacheViewModel>();
		
		TempsParTacheViewModel tptvm1  = new TempsParTacheViewModel();
		tptvm1.defTache("promener le chien");
		TempsParTacheViewModel tptvm2  = new TempsParTacheViewModel();
		tptvm1.defTache("dormir");
		
		collectionTempsParTacheViewModels.add(tptvm1);
		collectionTempsParTacheViewModels.add(tptvm2);

		Mockito.when(feuilleDeTemps.obtTaches()).thenReturn(collectionTempsParTacheFeuille1);
	}

	@Test
	public void testConvertMapOfStringFeuilleDeTemps() {
		Map<String, FeuilleDeTemps> mapTest = new HashMap<String, FeuilleDeTemps>();
		mapTest.put(idFeuilleDeTemps, feuilleDeTemps);
		mapTest.put(idFeuilleDeTemps2, feuilleDeTemps2);

		Collection<FeuilleDeTempsViewModel> collectionFeuilleDeTempsViewModels = feuilleDeTempsConverter.convert(mapTest);

		Iterator<FeuilleDeTempsViewModel> iterator = collectionFeuilleDeTempsViewModels.iterator();
		FeuilleDeTempsViewModel feuilleDeTempsViewModel = (FeuilleDeTempsViewModel) iterator
				.next();

		assertEquals(simpleDateFormat.format(feuilleDeTemps2.obtDebut()),
				feuilleDeTempsViewModel.debutPeriode);
		assertEquals(simpleDateFormat.format(feuilleDeTemps2.obtFin()),
				feuilleDeTempsViewModel.finPeriode);
		assertEquals(feuilleDeTemps2.obtIdentifiant(),
				feuilleDeTempsViewModel.employe);

		for (int i = 0; i < feuilleDeTempsViewModel.taches.size() - 1; i++) {
			TempsParTache tempsParTache = feuilleDeTemps2.obtTaches().get(i);
			TempsParTacheViewModel tempsParTacheViewModel = feuilleDeTempsViewModel.taches
					.get(i);

			assertEquals(tempsParTache.obtNbHeuresParJours(),
					tempsParTacheViewModel.obtNbHeuresParJours());
			assertEquals(tempsParTache.obtTache(),
					tempsParTacheViewModel.obtTache());
		}

		feuilleDeTempsViewModel = (FeuilleDeTempsViewModel) iterator.next();

		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtDebut()),
				feuilleDeTempsViewModel.debutPeriode);
		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtFin()),
				feuilleDeTempsViewModel.finPeriode);
		assertEquals(feuilleDeTemps.obtIdentifiant(),
				feuilleDeTempsViewModel.employe);

		for (int i = 0; i < feuilleDeTempsViewModel.taches.size() - 1; i++) {
			TempsParTache tempsParTache = feuilleDeTemps.obtTaches().get(i);
			TempsParTacheViewModel tempsParTacheViewModel = feuilleDeTempsViewModel.taches
					.get(i);

			assertEquals(tempsParTache.obtNbHeuresParJours(),
					tempsParTacheViewModel.obtNbHeuresParJours());
			assertEquals(tempsParTache.obtTache(),
					tempsParTacheViewModel.obtTache());
		}

	}

	@Test
	public void testConvertFeuilleDeTemps() {

		FeuilleDeTempsViewModel feuilleDeTempsViewModel = feuilleDeTempsConverter
				.convert(feuilleDeTemps);

		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtDebut()),
				feuilleDeTempsViewModel.debutPeriode);
		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtFin()),
				feuilleDeTempsViewModel.finPeriode);
		assertEquals(feuilleDeTemps.obtIdentifiant(),
				feuilleDeTempsViewModel.employe);

		for (int i = 0; i < feuilleDeTempsViewModel.taches.size() - 1; i++) {
			TempsParTache tempsParTache = feuilleDeTemps.obtTaches().get(i);
			TempsParTacheViewModel tempsParTacheViewModel = feuilleDeTempsViewModel.taches
					.get(i);

			assertEquals(tempsParTache.obtNbHeuresParJours(),
					tempsParTacheViewModel.obtNbHeuresParJours());
			assertEquals(tempsParTache.obtTache(),
					tempsParTacheViewModel.obtTache());
		}

	}

	@Test
	public void testConvertFeuilleDeTempsViewModel() {
		FeuilleDeTemps feuilleDeTemps = feuilleDeTempsConverter.convert(feuilleDeTempsViewModelTest);

		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtDebut()),
				feuilleDeTempsViewModelTest.obtDebutPeriode());
		assertEquals(simpleDateFormat.format(feuilleDeTemps.obtFin()),
				feuilleDeTempsViewModelTest.obtFinPeriode());
		assertEquals(feuilleDeTemps.obtIdentifiant(),
				feuilleDeTempsViewModelTest.obtEmploye());

		for (int i = 0; i < feuilleDeTempsViewModelTest.obtTaches().size() - 1; i++) {
			TempsParTache tempsParTache = feuilleDeTemps.obtTaches().get(i);
			TempsParTacheViewModel tempsParTacheViewModel = feuilleDeTempsViewModelTest.taches
					.get(i);
			
			assertEquals(tempsParTache.obtTache(),
					tempsParTacheViewModel.obtTache());
		}
	}

}
