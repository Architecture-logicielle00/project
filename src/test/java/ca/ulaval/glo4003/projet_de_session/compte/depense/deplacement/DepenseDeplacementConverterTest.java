package ca.ulaval.glo4003.projet_de_session.compte.depense.deplacement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacementConverter;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacementViewModel;

public class DepenseDeplacementConverterTest {
	private static DepenseDeplacementConverter depenseDeplacementConverter;

	@Before
	public void setUp() throws Exception {
		depenseDeplacementConverter = new DepenseDeplacementConverter();
	}
	
	public DepenseDeplacement getDepenseDeplacement1(){
		return new DepenseDeplacement("identifiant1", "date1", "time1",
				"description1", (float)1.0, (float)1.0);
	}
	
	public DepenseDeplacement getDepenseDeplacement2(){
		return new DepenseDeplacement("identifiant2", "date2", "time2",
				"description2", (float)2.0, (float)2.0);
	}
	
	public DepenseDeplacementViewModel getDepenseDeplacementViewModel1(){
		DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
		viewModel.coutKm = (float)2.0;
		viewModel.distance = (float)2.0;
		viewModel.description = "description1";
		viewModel.identifiant = "identifiant1";
		viewModel.date = "date1";
		viewModel.time = "time1";
		
		return viewModel;
	}
	
	public DepenseDeplacementViewModel getDepenseDeplacementViewModel2(){
		DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
		viewModel.coutKm = (float)2.0;
		viewModel.distance = (float)2.0;
		viewModel.description = "description2";
		viewModel.identifiant = "identifiant2";
		viewModel.date = "date2";
		viewModel.time = "time2";
		
		return viewModel;
	}
	
	public boolean estValide(DepenseDeplacement depense, DepenseDeplacementViewModel viewModel){
		return 
				viewModel.coutKm == depense.obtCoutKm() &&
				viewModel.distance == depense.obtDistance() &&
				viewModel.description == depense.obtDescription() &&
				viewModel.identifiant == depense.obtSoumissionnaire() &&
				viewModel.date == depense.obtDate() &&
				viewModel.time == depense.obtTime();
	}
	
	@Test
	public void convertDepenseCollection(){
		ArrayList<DepenseDeplacement> collection = new ArrayList<DepenseDeplacement>();
		collection.add(getDepenseDeplacement1());
		collection.add(getDepenseDeplacement2());
		
		ArrayList<DepenseDeplacementViewModel> viewModelCollection = (ArrayList<DepenseDeplacementViewModel>) depenseDeplacementConverter.convert(collection);
		
		assertTrue(estValide(getDepenseDeplacement1(), viewModelCollection.get(0)));
		assertTrue(estValide(getDepenseDeplacement2(), viewModelCollection.get(1)));
	}
	
	@Test
	public void convertDepense(){
		DepenseDeplacement depense = getDepenseDeplacement1();
		
		DepenseDeplacementViewModel viewModel = depenseDeplacementConverter.convert(depense);
		
		assertTrue(estValide(depense, viewModel));
	}
	
	@Test
	public void convertDepenseViewModel(){
		DepenseDeplacementViewModel viewModel = getDepenseDeplacementViewModel1();
		
		DepenseDeplacement depense = depenseDeplacementConverter.convert(viewModel);
		
		assertTrue(estValide(depense, viewModel));
	}
}
