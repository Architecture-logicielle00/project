package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoEmploye;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoEmployeXml implements RepoEmploye {
	
	public RepoEmployeXml()
	{
		employes = new ArrayList<Employe>();
		xmlEmploye = new Xml<Employe>(Employe.class);
		
		charger();
	}

	
	@Override
	public void ajouter(Employe e)
	{
		if (obtenir( e.obtNomUtilisateur() ) == null)
		{
			employes.add(e);
			sauvegarder();
		}
	}
	
	@Override
	public Employe obtenir(String nomUtilisateur)
	{
		for (Employe e : employes)
		{
			if (e.obtNomUtilisateur().equals(nomUtilisateur))
			{
				return e;
			}
		}
		return null;
	}
	
	@Override
	public List<Employe> obtEmployes()
	{
		return employes;
	}
	

	@Override
	public void supprimer(String nomUtilisateur)
	{
		employes.remove(nomUtilisateur);
		sauvegarder();
	}
	

	@Override
	public void modifier(Employe employe)
	{
		sauvegarder();
	}
	
	private void charger()
	{
		employes.clear();
		ArrayList<Employe> eList = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
		employes = eList;
	}
	
	private void sauvegarder()
	{
		xmlEmploye.enregistrer(obtEmployes(), "xmlfiles/employes");
	}
	
	ArrayList<Employe> employes;
	Xml<Employe> xmlEmploye;
}
