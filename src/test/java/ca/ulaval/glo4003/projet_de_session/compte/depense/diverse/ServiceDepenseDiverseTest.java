package ca.ulaval.glo4003.projet_de_session.compte.depense.diverse;

import org.junit.Before;
import org.mockito.Mock;

import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverseConverter;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.FactoryDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.ServiceDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

public class ServiceDepenseDiverseTest {

	private ServiceDepenseDiverse serviceDepenseDiverse;
	
	@Mock
	private Repository<DepenseDiverse> repo;
	@Mock
	private FactoryDepenseDiverse factory;
	@Mock
	private DepenseDiverseConverter conv;
	
	@Before
	public void setUp() throws Exception {
		
		serviceDepenseDiverse = new ServiceDepenseDiverse(repo,factory,conv);
	}
	
}
