package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoEmployer;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoEmployeXml implements RepoEmployer {
	
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
		// Ajouter un lanc� d'exception si pr�sent
		
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
		for (Employe e : employes)
		{
			if (e.obtNomUtilisateur().equals(nomUtilisateur))
			{
				employes.remove(e);
				sauvegarder();
				return;
			}
		}
	}
	
	@Override
	public void charger()
	{
		employes.clear();
		employes = (ArrayList<Employe>) xmlEmploye.charger("xmlfiles/employes");
	}
	
	@Override
	public void sauvegarder()
	{
		xmlEmploye.enregistrer(employes, "xmlfiles/employes");
	}
	
	ArrayList<Employe> employes;
	Xml<Employe> xmlEmploye;
}
