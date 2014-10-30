
package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;

public class RepoDepenseDiverseXml extends RepoGeneralXml<DepenseDiverse> {

	public RepoDepenseDiverseXml() {
		super(DepenseDiverse.class,"depensesDiverse");
	}

	public String ajouter(DepenseDiverse depense) {
		put(depense.obtIdentifant(),depense);
		
		return depense.obtIdentifant();
	}

	public void modifier(DepenseDiverse depense) {
		if(obt( depense.obtIdentifant() ) != null)
		{
			put(depense.obtIdentifant(), depense);
		}
	}
}
