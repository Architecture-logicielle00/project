package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoFeuilleDeTempsXml implements RepoFeuilleDeTemps {
	
	public RepoFeuilleDeTempsXml()
	{
		feuilleDeTemps = new ArrayList<FeuilleDeTemps>();
		xmlFeuilleDeTemps = new Xml<FeuilleDeTemps>(FeuilleDeTemps.class);
	}

	
	@Override
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
	
	@Override
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
	
	@Override
	public List<FeuilleDeTemps> obtTout()
	{
		return feuilleDeTemps;
	}
	

	@Override
	public void supprimer(Long id)//vue l'utilisation de l'arg id j'ai cree un index dans le model feuille pour entamer les diff meths
	{
		for(FeuilleDeTemps c:feuilleDeTemps){
			if(c.obtIndex().equals(id)){
				feuilleDeTemps.remove(c);
				break;
			}
		}
	}
	
	
	 @Override
	public void modifier(FeuilleDeTemps c1) {
		for(FeuilleDeTemps c:feuilleDeTemps){
			if(c.obtIndex().equals(c1.obtIndex())){
				c.defNomEmploye(c1.obtNomEmploye());
				c.defDebut(c1.obtDebut());
				c.defFin(c1.obtFin());
				c.defTaches(c1.obtTaches());
				break;
			}	
		}
		
	}
	
	@Override
	public void charger()
	{
		feuilleDeTemps.clear();
		feuilleDeTemps = (ArrayList<FeuilleDeTemps>) xmlFeuilleDeTemps.charger("xmlfiles/feuillesDeTemps");
	}
	
	@Override
	public void sauvegarder()
	{
		xmlFeuilleDeTemps.enregistrer(feuilleDeTemps, "xmlfiles/feuillesDeTemps");
	}
	
	ArrayList<FeuilleDeTemps> feuilleDeTemps;
	Xml<FeuilleDeTemps> xmlFeuilleDeTemps;
}
