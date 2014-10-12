package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvaleException;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoFeuilleDeTempsXml implements RepoFeuilleDeTemps {

	private Map<String, FeuilleDeTemps> feuilleDeTemps;
	private Xml<FeuilleDeTemps> xmlFeuilleDeTemps;
	
	private SimpleDateFormat simpleDateFormat;

	public RepoFeuilleDeTempsXml() {
		feuilleDeTemps = new HashMap<String, FeuilleDeTemps>();
		xmlFeuilleDeTemps = new Xml<FeuilleDeTemps>(FeuilleDeTemps.class);
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		charger();

		ArrayList<String> test = new ArrayList<String>();
		test.add("promener le chien");
		test.add("faire les devoirs");
		test.add("sortir la poubelle");

		Date debut = new Date();
		Date fin = new Date();
		try {
			debut = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-16");
			fin = new SimpleDateFormat("yyyy-MM-dd").parse("2014-08-28");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ajouter(new FeuilleDeTemps("DASAU", debut, fin, test));
	}

	@Override
	public String ajouter(FeuilleDeTemps feuille) {
		String id = feuille.obtNomEmploye() + 
				simpleDateFormat.format(feuille.obtDebut()) +
				simpleDateFormat.format(feuille.obtFin());
		feuilleDeTemps.put(id, feuille);

		sauvegarder();

		return id;

	}

	@Override
	public FeuilleDeTemps obtenir(String id) {
		if (feuilleDeTemps.containsKey(id)) {
			return feuilleDeTemps.get(id);
		}
		throw new FeuilleDeTempsIntrouvaleException();

	}

	@Override
	public Map<String, FeuilleDeTemps> obtTout() {
		return feuilleDeTemps;
	}

	@Override
	public void supprimer(String id) {
		feuilleDeTemps.remove(id);
		sauvegarder();
	}

	@Override
	public void modifier(String id, FeuilleDeTemps feuille) {
		feuilleDeTemps.put(id, feuille);
		sauvegarder();

	}

	private void charger() {
		ArrayList<FeuilleDeTemps> listXml = (ArrayList<FeuilleDeTemps>) xmlFeuilleDeTemps
				.charger("xmlfiles/feuillesDeTemps");

		feuilleDeTemps.clear();

		for (FeuilleDeTemps feuille : listXml) {
			ajouter(feuille);
		}
	}

	private void sauvegarder() {
		ArrayList<FeuilleDeTemps> listXml = new ArrayList<FeuilleDeTemps>();

		for (String key : feuilleDeTemps.keySet()) {
			listXml.add(obtenir(key));
		}

		xmlFeuilleDeTemps.enregistrer(listXml, "xmlfiles/feuillesDeTemps");
	}

}
