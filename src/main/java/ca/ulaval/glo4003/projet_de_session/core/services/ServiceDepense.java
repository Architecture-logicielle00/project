package ca.ulaval.glo4003.projet_de_session.core.services;

import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoDepenseDiverseXml;

public class ServiceDepense {

	private RepoDepenseDiverse repoDepense;
	//private FactoryEmploye factory;
	//private EmployeeConverter ec;
	
	public ServiceDepense()
	{
		repoDepense = new RepoDepenseDiverseXml();
		
		//factory = new FactoryEmploye();
		//ec = new EmployeeConverter();
	}
	
}
