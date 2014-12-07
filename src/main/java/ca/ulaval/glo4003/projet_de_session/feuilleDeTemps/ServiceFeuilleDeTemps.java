package ca.ulaval.glo4003.projet_de_session.feuilleDeTemps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.ServiceEmploye;
import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceFeuilleDeTemps {
	private Repository<FeuilleDeTemps> repository;
	private FactoryFeuilleDeTemps factory;
	private FeuilleDeTempsConverter converter;
	
	@Autowired
	ServiceEmploye serviceEmploye;
	
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
	
	public FeuilleDeTempsViewModel obtFeuilleDeTempsCouranteViewModel(String utilisateur){
		List<FeuilleDeTemps> collectionSpecifique = obtFeuillesDeTempsParUtilisateur(utilisateur);
		
		Date aujourdhui = new Date();
		
		for (FeuilleDeTemps feuilleDeTemps : collectionSpecifique) {
			if(feuilleDeTemps.estCourante(aujourdhui))
				return converter.convert(feuilleDeTemps);
		}
		
		throw new FeuilleDeTempsIntrouvableException();
	}
	
	public FeuilleDeTemps obtFeuilleDeTempsCourante(String utilisateur){
		List<FeuilleDeTemps> collectionSpecifique = obtFeuillesDeTempsParUtilisateur(utilisateur);
		
		Date aujourdhui = new Date();
		
		for (FeuilleDeTemps feuilleDeTemps : collectionSpecifique) {
			if(feuilleDeTemps.estCourante(aujourdhui))
				return feuilleDeTemps;
		}
		
		throw new FeuilleDeTempsIntrouvableException();
	}
	
	public Collection<FeuilleDeTempsViewModel> obtFeuillesDeTempsViewModel() {
		return converter.convert(obtFeuillesDeTemps());
	}

	public FeuilleDeTempsViewModel obtFeuilleDeTempsViewModel(String id) {
		return converter.convert(obtFeuilleDeTemps(id));
	}
	
	public void deleteFeuilleDeTemps(String id) {
		repository.supprimer(id);
	}

	public void updateFeuilleDeTemps(FeuilleDeTempsViewModel feuilleDeTempsViewModel) {
		FeuilleDeTemps feuilleDeTemps = converter
				.convert(feuilleDeTempsViewModel);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String id = feuilleDeTemps.obtIdentifiant() +
				simpleDateFormat.format(feuilleDeTemps.obtDebut()) +
				simpleDateFormat.format(feuilleDeTemps.obtFin());

		updateFeuilleDeTemps(id, feuilleDeTemps);
	}
	
	public void assignerTachesAFeuilleCourrant(String nomUtilisateur, List<String> taches){
		
		FeuilleDeTemps feuilleDeTemps;
		
		try{
			feuilleDeTemps = obtFeuilleDeTempsCourante(nomUtilisateur);
		}catch(FeuilleDeTempsIntrouvableException feuilleDeTempsIntrouvableException){
			createFeuilleDeTempsCourante(serviceEmploye.obtEmploye(nomUtilisateur));
			feuilleDeTemps = obtFeuilleDeTempsCourante(nomUtilisateur);
		}

		feuilleDeTemps.setTaches(taches);
		
		repository.modifier(feuilleDeTemps);
	}

//INTERN METHODS
	
	private FeuilleDeTemps obtFeuilleDeTemps(String id) {
		return repository.obt(id);
	}
	
	private Map<String, FeuilleDeTemps> obtFeuillesDeTemps() {
		return repository.obtMap();
	}
	
	private List<FeuilleDeTemps> obtFeuillesDeTempsParUtilisateur(String utilisateur) {
		List<FeuilleDeTemps> collection = new ArrayList<FeuilleDeTemps>();
		
		for (FeuilleDeTemps feuilleDeTemps : repository.obtTout()) {
			if(feuilleDeTemps.appartientA(utilisateur)){
				collection.add(feuilleDeTemps);
			}
		}
		
		return collection;
	}
	
	private void updateFeuilleDeTemps(String id, FeuilleDeTemps feuilleDeTemps) {
		repository.modifier(id, feuilleDeTemps);
	}
}
