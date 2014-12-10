package ca.ulaval.glo4003.projet_de_session.compte.depense.diverse;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.FactoryDepenseDiverse;

public class FactoryDepenseDiverseTest {

	private FactoryDepenseDiverse facto;
	
	private String identifiant = "identifiant";
	private String date = "date";
	private String time = "time";
	private String description = "description";
	private int nbRepas = 3;
	private float coutRepas = (float)1.0;
	private float divers = (float)1.0;
	private float coucher = (float)1.0;
	
	@Before
	public void setUp() throws Exception {
		facto = new FactoryDepenseDiverse();
	}
	
	public boolean estValide(DepenseDiverse depense){
		return 
				description == depense.obtDescription() &&
				identifiant == depense.obtSoumissionnaire() &&
				date == depense.obtDate() &&
				time == depense.obtTime() &&
				nbRepas == depense.nbRepas &&
				coutRepas == depense.coutRepas &&
				divers == depense.divers &&
				coucher == depense.coucher;
	}
	
	@Test
	public void creeTest(){
		DepenseDiverse depense = facto.creer(identifiant, date, time,
				description, nbRepas, coutRepas, divers,
				coucher);
		
		assertTrue(estValide(depense));
	}
	
}
