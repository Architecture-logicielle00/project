package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoFeuilleDeTemps {
	
	public RepoFeuilleDeTemps()
	{
		feuilleDeTemps = new ArrayList<FeuilleDeTemps>();
		xml = new Xml();
	}

	
	public void ajouter(FeuilleDeTemps e)
	{
		//TODO
		
	}
	
	public FeuilleDeTemps obtenir(int id)
	{
		return new FeuilleDeTemps(); //TODO
	}
	
	public List<FeuilleDeTemps> obtTout()
	{
		return feuilleDeTemps;
	}
	

	public void supprimer(int id)
	{
		//TODO
	}
	
	public void charger()
	{
		feuilleDeTemps.clear();
		feuilleDeTemps = (ArrayList<FeuilleDeTemps>) xml.chargerFeuilleDeTemps("xmlfiles/employes");
	}
	
	public void sauvegarder()
	{
		xml.enregistrerFeuilleDeTemps(feuilleDeTemps, "xmlfiles/employes");
	}
	
	ArrayList<FeuilleDeTemps> feuilleDeTemps;
	Xml xml;
}
