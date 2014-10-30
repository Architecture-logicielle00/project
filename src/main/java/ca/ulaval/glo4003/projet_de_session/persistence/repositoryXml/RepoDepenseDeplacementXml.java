
package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;

public class RepoDepenseDeplacementXml extends RepoGeneralXml<DepenseDeplacement> {
	public RepoDepenseDeplacementXml() {
		super(DepenseDeplacement.class,"depensesDeplacement");
	}


	public String ajouter(DepenseDeplacement depense) {
		put(depense.obtIdentifant(),depense);
		
		return depense.obtIdentifant();
	}

	public void modifier(DepenseDeplacement depense) {
		if(obt( depense.obtIdentifant() ) != null)
		{
			put(depense.obtIdentifant(), depense);
		}
	}
}

