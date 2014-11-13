package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.text.SimpleDateFormat;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;

public class RepoFeuilleDeTempsXml extends RepoGeneralXml<FeuilleDeTemps> {

	private SimpleDateFormat simpleDateFormatLazy;
	
	private SimpleDateFormat obtSimpleDateFormat(){
		if (simpleDateFormatLazy == null)
			simpleDateFormatLazy = new SimpleDateFormat("yyyy-MM-dd");
		
		return simpleDateFormatLazy;
	}

	public RepoFeuilleDeTempsXml() {
		super(FeuilleDeTemps.class,"feuillesDeTemps");
	}

	public String ajouter(FeuilleDeTemps feuille) {
		String id = construireIdentifiant(feuille);
		put(id, feuille);
			
		return id;
	}
	
	public FeuilleDeTemps obt(String identifiantUnique){
		FeuilleDeTemps feuille = super.obt(identifiantUnique);
		
		if (feuille == null)
			throw new FeuilleDeTempsIntrouvableException();
		
		return feuille; 
	}

	@Override
	public void modifier(FeuilleDeTemps feuilleDeTemps) {
		modifier(construireIdentifiant(feuilleDeTemps),feuilleDeTemps);
		
	}

	private String construireIdentifiant(FeuilleDeTemps feuille){
		return feuille.obtIdentifiant() + 
				obtSimpleDateFormat().format(feuille.obtDebut()) +
				obtSimpleDateFormat().format(feuille.obtFin());
	}
}
