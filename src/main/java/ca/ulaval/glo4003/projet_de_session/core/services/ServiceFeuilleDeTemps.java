package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;



public class ServiceFeuilleDeTemps
{
	public ServiceFeuilleDeTemps()
	{
		factory = new FactoryFeuilleDeTemps();
		repo = new RepoFeuilleDeTemps();
		ec = new FeuilleDeTempsConverter();
		
		init();
	}
	
	public FeuilleDeTemps obtFeuilleDeTemps(Long id)
	{
		return repo.obtenir(id);
	}
	
	public void creerFeuilleDeTemps()
	{
		FeuilleDeTemps e = factory.creerFeuilleDeTemps();
		repo.ajouter(e);
	}
	
	public List<FeuilleDeTemps> obtFeuillesDeTemps()
	{
		return null; //TODO
	}
	
	
	public Collection<FeuilleDeTempsViewModel> obtFeuilleDeTempsViewModel()
	{
		return null;  //TODO
	}
	
	
	private void init()
	{
		repo.charger();
	}

	
	RepoFeuilleDeTemps repo;
	FactoryFeuilleDeTemps factory;
	FeuilleDeTempsConverter ec;
}
