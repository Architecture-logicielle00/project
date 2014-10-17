package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoEmploye;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoEmployeXml implements RepoEmploye {
	
	public RepoEmployeXml()
	{
		employes = new HashMap<String, Employe>();
		xmlEmploye = new Xml<Employe>(Employe.class);
		
		charger();
	}

	
	@Override
	public void ajouter(Employe e)
	{
		if (obtenir( e.obtNomUtilisateur() ) == null)
		{
			employes.put(e.obtNomUtilisateur(), e);
			sauvegarder();
		}
	}
	
	@Override
	public Employe obtenir(String nomUtilisateur)
	{
		return employes.get(nomUtilisateur);
	}
	
	@Override
	public List<Employe> obtEmployes()
	{
		List<Employe> list = new ArrayList<Employe>(employes.values());
		return list;
	}
	

	@Override
	public void supprimer(String nomUtilisateur)
	{
		employes.remove(nomUtilisateur);
	}
	
	@Override
	public void charger()
	{
		employes.clear();
		ArrayList<Employe> eList = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
		for (Employe e : eList) {
			ajouter(e);
		}
	}
	
	public void modifier(Employe e)
	{
		if(obtenir( e.obtNomUtilisateur() ) != null)
		{
			employes.put(e.obtNomUtilisateur(), e);
		}
		sauvegarder();
		
	}
	
	@Override
	public void sauvegarder()
	{
		xmlEmploye.enregistrer(obtEmployes(), "xmlfiles/employes");
	}
	
	HashMap<String, Employe> employes;
	Xml<Employe> xmlEmploye;
}
