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
		
		 if(feuilleDeTemps.size()==0){
		e.defIndex(new Long(feuilleDeTemps.size()+1));
		}
		else
		{
			FeuilleDeTemps c1=feuilleDeTemps.get(feuilleDeTemps.size()-1);
			e.defIndex(new Long(c1.obtIndex()+1));
		}
		feuilleDeTemps.add(e);
	}
	
	public FeuilleDeTemps obtenir(Long id)
	{
		
		FeuilleDeTemps fDeTemps=null;
		for(FeuilleDeTemps c:feuilleDeTemps){
			if(c.obtIndex().equals(id)){
				fDeTemps=c;
			}	
		}
	
	
		return  fDeTemps; 
	}
	
	public List<FeuilleDeTemps> obtTout()
	{
		return feuilleDeTemps;
	}
	

	public void supprimer(Long id)//vue l'utilisation de l'arg id j'ai cree un index dans le model feuille pour entamer les diff meths
	{
		for(FeuilleDeTemps c:feuilleDeTemps){
			if(c.obtIndex().equals(id)){
				feuilleDeTemps.remove(c);
				break;
			}
		}
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
