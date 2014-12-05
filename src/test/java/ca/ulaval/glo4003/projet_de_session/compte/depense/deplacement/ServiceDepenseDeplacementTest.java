package ca.ulaval.glo4003.projet_de_session.compte.depense.deplacement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacementConverter;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacementViewModel;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.FactoryDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.ServiceDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

public class ServiceDepenseDeplacementTest {

	private ServiceDepenseDeplacement serviceDepenseDeplacement;
	
	@Mock
	private Repository<DepenseDeplacement> repo;
	@Mock
	private FactoryDepenseDeplacement factory;
	@Mock
	private DepenseDeplacementConverter conv;
	
	@Before
	public void setUp() throws Exception {
		
		serviceDepenseDeplacement = new ServiceDepenseDeplacement(repo,factory,conv);
	}
	
	private String identifiant = "identifiant";
	
	public DepenseDeplacementViewModel getDepenseDeplacementViewModel(){
		DepenseDeplacementViewModel viewModel = new DepenseDeplacementViewModel();
		viewModel.coutKm = (float)1.0;
		viewModel.distance = (float)1.0;
		viewModel.description = "description";
		viewModel.identifiant = identifiant;
		viewModel.date = "date";
		viewModel.time = "time";
		
		return viewModel;
	}
	
	@Test
	public void creeDepenseDeplacement(){
		
	}
}
