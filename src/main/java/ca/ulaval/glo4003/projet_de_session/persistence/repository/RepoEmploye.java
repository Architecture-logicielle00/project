package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryEmploye;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoEmploye {
	
	public RepoEmploye()
	{
		employes = new ArrayList<Employe>();
		xml = new Xml();
	}

	
	public void ajouter(Employe e)
	{
		if (obtenir( e.obtNomUtilisateur() ) == null)
		{
			employes.add(e);
		}
		// Ajouter un lanc� d'exception si pr�sent
		
	}
	
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
	
	public List<Employe> obtEmployes()
	{
		return employes;
	}
	

	public void supprimer(String nomUtilisateur)
	{
		for (Employe e : employes)
		{
			if (e.obtNomUtilisateur().equals(nomUtilisateur))
			{
				employes.remove(e);
				return;
			}
		}
	}
	
	public void charger()
	{
		employes.clear();
		employes = (ArrayList<Employe>) xml.chargerEmployes("xmlfiles/employes");
	}
	
	public void sauvegarder()
	{
		xml.enregistrerEmployes(employes, "xmlfiles/employes");
	}
	
	ArrayList<Employe> employes;
	Xml xml;
}
