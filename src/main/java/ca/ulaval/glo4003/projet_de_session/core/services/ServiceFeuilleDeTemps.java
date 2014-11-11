package ca.ulaval.glo4003.projet_de_session.core.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;

@Service
public class ServiceFeuilleDeTemps {
	private Repository<FeuilleDeTemps> repository;
	private FactoryFeuilleDeTemps factory;
	private FeuilleDeTempsConverter converter;
	
	private final int dureePeriodeDePaieEnSemaines = 2;

	public ServiceFeuilleDeTemps() {
		factory = new FactoryFeuilleDeTemps();
		repository = FactoryRepository.cree(FeuilleDeTemps.class);
		converter = new FeuilleDeTempsConverter();
	}




	public String createFeuilleDeTemps(Employe _employe, Date _debut, Date _fin) {
		FeuilleDeTemps e = factory.creerFeuilleDeTemps(_employe, _debut, _fin);
		return repository.ajouter(e);
	}
	
	public String createFeuilleDeTempsCourante(Employe _employe)
	{
		DateTime aujourdhui = DateTime.now();
		DateTime debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY);
		DateTime finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY);
		DateTime finDelaPeriodeCourante = finDelaSemaineCourante.plusWeeks(dureePeriodeDePaieEnSemaines - 1);
		
		
		return createFeuilleDeTemps(_employe, debutDelasemaineCourante.toDate(), finDelaPeriodeCourante.toDate());
	}
	
	public FeuilleDeTempsViewModel getFeuilleDeTempsCourante(String utilisateur){
		List<FeuilleDeTemps> collectionSpecifique = getFeuillesDeTempsParUtilisateur(utilisateur);
		
		Date aujourdhui = new Date();
		
		for (FeuilleDeTemps feuilleDeTemps : collectionSpecifique) {
			if(feuilleDeTemps.estCourante(aujourdhui))
				return converter.convert(feuilleDeTemps);
		}
		
		throw new FeuilleDeTempsIntrouvableException();
		
		
	}
	
	public Collection<FeuilleDeTempsViewModel> getFeuillesDeTempsViewModel() {
		return converter.convert(getFeuillesDeTemps());
	}

	public FeuilleDeTempsViewModel getFeuilleDeTempsViewModel(String id) {
		return converter.convert(getFeuilleDeTemps(id));
	}
	
	public void deleteFeuilleDeTemps(String id) {
		repository.supprimer(id);
	}


	public void updateFeuilleDeTemps(FeuilleDeTempsViewModel feuilleDeTempsViewModel) {
		FeuilleDeTemps feuilleDeTemps = converter
				.convert(feuilleDeTempsViewModel);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String id = feuilleDeTemps.getIdentifiant() +
				simpleDateFormat.format(feuilleDeTemps.getDebut()) +
				simpleDateFormat.format(feuilleDeTemps.getFin());

		updateFeuilleDeTemps(id, feuilleDeTemps);
	}

	
	
//INTERN METHODS
	
	private FeuilleDeTemps getFeuilleDeTemps(String id) {
		return repository.obt(id);
	}
	
	private Map<String, FeuilleDeTemps> getFeuillesDeTemps() {
		return repository.obtMap();
	}
	
	private List<FeuilleDeTemps> getFeuillesDeTempsParUtilisateur(String utilisateur) {
		List<FeuilleDeTemps> collection = new ArrayList<FeuilleDeTemps>();
		
		for (FeuilleDeTemps feuilleDeTemps : repository.obtTout()) {
			if(feuilleDeTemps.getIdentifiant().equals(utilisateur)){
				collection.add(feuilleDeTemps);
			}
		}
		
		return collection;
		
		
	}
	
	private void updateFeuilleDeTemps(String id, FeuilleDeTemps feuilleDeTemps) {
		repository.modifier(id, feuilleDeTemps);
	}
}
