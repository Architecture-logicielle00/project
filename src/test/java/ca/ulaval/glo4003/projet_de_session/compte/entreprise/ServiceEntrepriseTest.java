package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

public class ServiceEntrepriseTest {

	@InjectMocks
	private ServiceEntreprise serviceEntrepriseTest;
	@Spy
	private ServiceEmploye serviceEmploye;
	@Mock
	private Repository<Entreprise> repo;
	@Mock
	private FactoryEntreprise factory;
	
	@Before 
	public void initMocks(){
			serviceEntrepriseTest = new ServiceEntreprise(repo,factory);
			MockitoAnnotations.initMocks(this);
	}
}
