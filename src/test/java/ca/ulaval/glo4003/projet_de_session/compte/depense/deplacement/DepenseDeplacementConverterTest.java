package ca.ulaval.glo4003.projet_de_session.compte.depense.deplacement;

import static org.junit.Assert.*;
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
	
	public DepenseDeplacement getDepenseDeplacement(){
		return new DepenseDeplacement("identifiant", "date", "time",
				"description", (float)1.0, (float)1.0);
	}
	
	public DepenseDeplacementViewModel getDepenseDeplacementViewModel(){
		DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
		viewModel.coutKm = (float)1.0;
		viewModel.distance = (float)1.0;
		viewModel.description = "description";
		viewModel.identifiant = "identifiant";
		viewModel.date = "date";
		viewModel.time = "time";
		
		return viewModel;
	}
	
	public boolean estValide(DepenseDeplacement depense, DepenseDeplacementViewModel viewModel){
		return 
				viewModel.coutKm == depense.obtCoutKm() &&
				viewModel.distance == depense.obtDistance() &&
				viewModel.description == depense.obtDescription() &&
				viewModel.identifiant == depense.obtIdentifiant() &&
				viewModel.date == depense.obtDate() &&
				viewModel.time == depense.obtTime();
	}
	
	@Test
	public void convertDepense(){
		DepenseDeplacement depense = getDepenseDeplacement();
		
		DepenseDeplacementViewModel viewModel = depenseDeplacementConverter.convert(depense);
		
		assertTrue(estValide(depense, viewModel));
	}
	
	@Test
	public void convertDepenseViewModel(){
		DepenseDeplacementViewModel viewModel = getDepenseDeplacementViewModel();
		
		DepenseDeplacement depense = depenseDeplacementConverter.convert(viewModel);
		
		assertTrue(estValide(depense, viewModel));
	}
}
