package ca.ulaval.glo4003.projet_de_session.depense.deplacement;

import ca.ulaval.glo4003.projet_de_session.repository.xml.RepoGeneralXml;

public class RepoDepenseDeplacementXml extends
		RepoGeneralXml<DepenseDeplacement> {

	public RepoDepenseDeplacementXml() {
		super(DepenseDeplacement.class, "depensesDeplacement");
	}

	public String ajouter(DepenseDeplacement depense) {
		String id = depense.obtIdentifiant();
		
		put(id, depense);

		return id;
	}

	public void modifier(DepenseDeplacement depense) {
		
		String id = depense.obtIdentifiant();
		
		if (obt(id) != null) {
			put(id, depense);
		}
	}
}
