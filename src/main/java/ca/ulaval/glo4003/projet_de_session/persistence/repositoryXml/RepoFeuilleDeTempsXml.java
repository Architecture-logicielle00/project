package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvableException;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoFeuilleDeTempsXml implements RepoFeuilleDeTemps {

	private Map<String, FeuilleDeTemps> feuillesDeTemps;
	private Xml<FeuilleDeTemps> xmlFeuilleDeTemps;
	
	private SimpleDateFormat simpleDateFormat;

	public RepoFeuilleDeTempsXml() {
		feuillesDeTemps = new HashMap<String, FeuilleDeTemps>();
		xmlFeuilleDeTemps = new Xml<FeuilleDeTemps>(FeuilleDeTemps.class);
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		charger();
	}

	@Override
	public String ajouter(FeuilleDeTemps feuille) {
		String id = feuille.obtNomEmploye() + 
				simpleDateFormat.format(feuille.obtDebut()) +
				simpleDateFormat.format(feuille.obtFin());
		feuillesDeTemps.put(id, feuille);

		sauvegarder();

		return id;

	}

	@Override
	public FeuilleDeTemps obtenir(String id) {
		if (feuillesDeTemps.containsKey(id)) {
			return feuillesDeTemps.get(id);
		}
		throw new FeuilleDeTempsIntrouvableException();

	}

	@Override
	public Map<String, FeuilleDeTemps> obtTout() {
		return feuillesDeTemps;
	}

	@Override
	public void supprimer(String id) {
		feuillesDeTemps.remove(id);
		sauvegarder();
	}

	@Override
	public void modifier(String id, FeuilleDeTemps feuille) {
		feuillesDeTemps.put(id, feuille);
		sauvegarder();

	}

	private void charger() {
		ArrayList<FeuilleDeTemps> listXml = (ArrayList<FeuilleDeTemps>) xmlFeuilleDeTemps
				.charger("xmlfiles/feuillesDeTemps");

		feuillesDeTemps.clear();

		for (FeuilleDeTemps feuille : listXml) {
			ajouter(feuille);
		}
	}

	private void sauvegarder() {
		ArrayList<FeuilleDeTemps> listXml = new ArrayList<FeuilleDeTemps>();

		for (String key : feuillesDeTemps.keySet()) {
			listXml.add(obtenir(key));
		}

		xmlFeuilleDeTemps.enregistrer(listXml, "xmlfiles/feuillesDeTemps");
	}

}
