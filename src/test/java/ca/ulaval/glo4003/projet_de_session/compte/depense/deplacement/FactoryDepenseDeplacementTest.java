package ca.ulaval.glo4003.projet_de_session.compte.depense.deplacement;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.FactoryDepenseDeplacement;

public class FactoryDepenseDeplacementTest {
	
private static FactoryDepenseDeplacement facto;
	
	private float coutKm = (float)1.0;
	private float distance = (float)1.0;
	private String description = "description";
	private String identifiant = "identifiant";
	private String date = "date";
	private String time = "time";
	
	@Before
	public void setUp() throws Exception {
		facto = new FactoryDepenseDeplacement();
	}
	
	public boolean estValide(DepenseDeplacement depense){
		return 
				coutKm == depense.obtCoutKm() &&
				distance == depense.obtDistance() &&
				description == depense.obtDescription() &&
				identifiant == depense.obtIdentifiant() &&
				date == depense.obtDate() &&
				time == depense.obtTime();
	}
	
	@Test
	public void creeTest(){
		DepenseDeplacement depense = facto.creer(identifiant, date, time, description, distance, coutKm);
		
		assertTrue(estValide(depense));
	}
}
