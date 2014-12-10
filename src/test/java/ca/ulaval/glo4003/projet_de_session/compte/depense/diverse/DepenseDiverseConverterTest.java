package ca.ulaval.glo4003.projet_de_session.compte.depense.diverse;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverseConverter;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverseViewModel;

public class DepenseDiverseConverterTest {
	private static DepenseDiverseConverter depenseDiverseConverter;

	@Before
	public void setUp() throws Exception {
		depenseDiverseConverter = new DepenseDiverseConverter();
	}
	
	private String identifiant = "identifiant";
	private String date = "date";
	private String time = "time";
	private String description = "description";
	private int nbRepas = 3;
	private float coutRepas = (float)1.0;
	private float divers = (float)1.0;
	private float coucher = (float)1.0;
	
	public DepenseDiverse getDepenseDiverse1(){
		return new DepenseDiverse(identifiant, date, time,
				description, nbRepas, coutRepas, divers, coucher);
	}
	
	public DepenseDiverse getDepenseDiverse2(){
		return new DepenseDiverse("identifiant2", "date2", "time2",
				"description2", 2, 2.0f, 2.0f, 1.0f);
	}
	
	
	public DepenseDiverseViewModel getDepenseDiverseViewModel(){
		DepenseDiverseViewModel viewModel = new DepenseDiverseViewModel();
		viewModel.description = "description";
		viewModel.identifiant = "identifiant";
		viewModel.date = "date";
		viewModel.time = "time";
		viewModel.nbRepas = nbRepas;
		viewModel.coutRepas = coutRepas;
		viewModel.divers = divers;
		viewModel.coucher = coucher;
		
		return viewModel;
	}
	
	public boolean estValide(DepenseDiverse depense, DepenseDiverseViewModel viewModel){
		return 
				viewModel.description == depense.obtDescription() &&
				viewModel.identifiant == depense.obtSoumissionnaire() &&
				viewModel.date == depense.obtDate() &&
				viewModel.time == depense.obtTime() &&
				viewModel.nbRepas == depense.nbRepas &&
				viewModel.coutRepas == depense.coutRepas &&
				viewModel.divers == depense.divers &&
				viewModel.coucher == depense.coucher;
	}
	
	@Test
	public void convertDepenseCollection(){
		ArrayList<DepenseDiverse> collection = new ArrayList<DepenseDiverse>();
		collection.add(getDepenseDiverse1());
		collection.add(getDepenseDiverse2());
		
		ArrayList<DepenseDiverseViewModel> viewModelCollection = (ArrayList<DepenseDiverseViewModel>) depenseDiverseConverter.convert(collection);
		
		assertTrue(estValide(getDepenseDiverse1(), viewModelCollection.get(0)));
		assertTrue(estValide(getDepenseDiverse2(), viewModelCollection.get(1)));
	}
	
	@Test
	public void convertDepense(){
		DepenseDiverse depense = getDepenseDiverse1();
		
		DepenseDiverseViewModel viewModel = depenseDiverseConverter.convert(depense);
		
		assertTrue(estValide(depense, viewModel));
	}
	
	@Test
	public void convertDepenseViewModel(){
		DepenseDiverseViewModel viewModel = getDepenseDiverseViewModel();
		
		DepenseDiverse depense = depenseDiverseConverter.convert(viewModel);
		
		assertTrue(estValide(depense, viewModel));
	}
}
