package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.exception.FeuilleDeTempsIntrouvaleException;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoFeuilleDeTempsXml implements RepoFeuilleDeTemps {
		
	private Map<String, FeuilleDeTemps> feuilleDeTemps;
	private Xml<FeuilleDeTemps> xmlFeuilleDeTemps;
	
	public RepoFeuilleDeTempsXml()
	{
		feuilleDeTemps = new HashMap<String, FeuilleDeTemps>();
		xmlFeuilleDeTemps = new Xml<FeuilleDeTemps>(FeuilleDeTemps.class);
	}

	
	@Override
	public String ajouter(FeuilleDeTemps feuille)
	{
		String id = feuille.obtNomEmploye() + feuille.obtDebut().toString() + feuille.obtFin().toString();
		feuilleDeTemps.put(id, feuille);
		return id;
	}
	
	@Override
	public FeuilleDeTemps obtenir(String id)
	{
		if(feuilleDeTemps.containsKey(id)) {
			return feuilleDeTemps.get(id);
		}
		throw new FeuilleDeTempsIntrouvaleException();
		
	}
	
	@Override
	public Map<String, FeuilleDeTemps> obtTout()
	{
		return feuilleDeTemps;
	}
	

	@Override
	public void supprimer(String id)
	{
		feuilleDeTemps.remove(id);
	}
	
	
	 @Override
	public void modifier(String id, FeuilleDeTemps feuille) {
		 feuilleDeTemps.put(id, feuille);
		
	}
	
	@Override
	public void charger()
	{
		ArrayList<FeuilleDeTemps> listXml = (ArrayList<FeuilleDeTemps>) xmlFeuilleDeTemps.charger("xmlfiles/feuillesDeTemps");
		
		feuilleDeTemps.clear();
		
		for (FeuilleDeTemps feuille : listXml) {
			ajouter(feuille);
		}
	}
	
	@Override
	public void sauvegarder()
	{
		ArrayList<FeuilleDeTemps> listXml = new ArrayList<FeuilleDeTemps>();
		
		for (Iterator iterator = listXml.iterator(); iterator.hasNext();) {
			FeuilleDeTemps feuilleDeTemps = (FeuilleDeTemps) iterator.next();
			listXml.add(feuilleDeTemps);
		}
		
		xmlFeuilleDeTemps.enregistrer(listXml, "xmlfiles/feuillesDeTemps");
	}

}
