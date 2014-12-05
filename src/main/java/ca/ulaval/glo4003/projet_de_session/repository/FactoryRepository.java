package ca.ulaval.glo4003.projet_de_session.repository;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.compte.employe.RepoEmployeXml;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.Entreprise;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.RepoEntrepriseXml;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.depense.deplacement.RepoDepenseDeplacementXml;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.depense.diverse.RepoDepenseDiverseXml;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.RepoFeuilleDeTempsXml;

public class FactoryRepository {
	@SuppressWarnings("unchecked")
	public static <T> Repository<T> cree(Class<T> type){
		String className = type.getName();	

        if (className == Employe.class.getName()) 
        	return (Repository<T>)new RepoEmployeXml();
        else if (className == DepenseDeplacement.class.getName()) 
		    return (Repository<T>)new RepoDepenseDeplacementXml();
        else if (className == DepenseDiverse.class.getName())  
		   	return (Repository<T>)new RepoDepenseDiverseXml();
        else if (className == FeuilleDeTemps.class.getName())  
   		    return (Repository<T>)new RepoFeuilleDeTempsXml();
        else if (className == Entreprise.class.getName())
        	return (Repository<T>) new RepoEntrepriseXml();
        
        throw new FactoryInnexistanteExeption();
    }
}
