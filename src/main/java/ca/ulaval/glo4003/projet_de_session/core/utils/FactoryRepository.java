package ca.ulaval.glo4003.projet_de_session.core.utils;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoDepenseDeplacementXml;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoDepenseDiverseXml;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoEmployeXml;
import ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml.RepoFeuilleDeTempsXml;

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
        
        // TODO throw and exception
        return null;
    }
}
