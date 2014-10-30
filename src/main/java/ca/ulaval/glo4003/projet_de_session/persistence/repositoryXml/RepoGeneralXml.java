package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public abstract class RepoGeneralXml<T> implements Repository<T> {
	
	private Map<String, T> liste;
	private Xml<T> xml;
	private String nomFichierXml;
	
	public RepoGeneralXml(Class<T> type, String _nomFichierXml)
	{
		liste = new HashMap<String, T>();
		xml = new Xml<T>(type);
		nomFichierXml = _nomFichierXml;
		
		charger();
	}
	
	public abstract String ajouter(T objetAAjouter);
	public abstract void modifier(T objetAModifier);
	
	public void modifier(String identification,T objetAModifier){
		put(identification, objetAModifier);
		sauvegarder();
	}

	protected void put(String cle, T objet){
		liste.put(cle, objet);
		sauvegarder();
	}
	
	@Override
	public List<T> obtTout()
	{
		List<T> list = new ArrayList<T>(liste.values());
		return list;
	}
	
	@Override
	public Map<String, T> obtMap(){
		return liste;
	}
	
	@Override
	public void supprimer(T objetAAupprimer)
	{
		liste.remove(objetAAupprimer);
		sauvegarder();
	}

	@Override
	public T obt(String identifiantUnique)
	{
		return liste.get(identifiantUnique);
	}
	
	@Override
	public void supprimer(String identifiantUnique)
	{
		liste.remove(identifiantUnique);
		sauvegarder();
	}
	
	private  void charger(){
		ArrayList<T> eList = (ArrayList<T>) xml.charger("xmlfiles/" + nomFichierXml);
		
		liste.clear();
		
		for (T e : eList) {
			ajouter(e);
		}
	}
	
	private void sauvegarder()
	{
		xml.enregistrer(obtTout(), "xmlfiles/" + nomFichierXml);
	}
	
	
}
