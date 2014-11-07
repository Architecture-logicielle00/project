package ca.ulaval.glo4003.projet_de_session.core.services;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.FeuilleDeTempsConverter;
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

	public FeuilleDeTemps obtFeuilleDeTemps(String id) {
		return repository.obt(id);
	}

	public void suppFeuilleDeTemps(String id) {
		repository.supprimer(id);
	}

	public String creerFeuilleDeTemps(Employe _employe, Date _debut, Date _fin) {
		FeuilleDeTemps e = factory.creerFeuilleDeTemps(_employe, _debut, _fin);
		return repository.ajouter(e);
	}
	
	public String creerFeuilleDeTempsCourante(Employe _employe)
	{
		DateTime aujourdhui = DateTime.now();
		DateTime debutDelasemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.MONDAY);
		DateTime finDelaSemaineCourante = aujourdhui.withDayOfWeek(DateTimeConstants.SUNDAY);
		DateTime finDelaPeriodeCourante = finDelaSemaineCourante.plusWeeks(dureePeriodeDePaieEnSemaines - 1);
		
		
		return creerFeuilleDeTemps(_employe, debutDelasemaineCourante.toDate(), finDelaPeriodeCourante.toDate());
	}

	public void modifierFeuilleDeTemps(String id, FeuilleDeTemps feuilleDeTemps) {
		repository.modifier(id, feuilleDeTemps);
	}

	public void modifierFeuilleDeTemps(FeuilleDeTempsViewModel feuilleDeTempsViewModel) {
		FeuilleDeTemps feuilleDeTemps = converter
				.convert(feuilleDeTempsViewModel);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String id = feuilleDeTemps.getIdentifiant() +
				simpleDateFormat.format(feuilleDeTemps.getDebut()) +
				simpleDateFormat.format(feuilleDeTemps.getFin());

		repository.modifier(id, feuilleDeTemps);
	}

	public Map<String, FeuilleDeTemps> obtFeuillesDeTemps() {
		return repository.obtMap();
	}

	public Collection<FeuilleDeTempsViewModel> obtFeuillesDeTempsViewModel() {
		return converter.convert(obtFeuillesDeTemps());
	}

	public FeuilleDeTempsViewModel obtFeuilleDeTempsViewModel(String id) {
		return converter.convert(obtFeuilleDeTemps(id));
	}
}
