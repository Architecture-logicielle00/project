package ca.ulaval.glo4003.projet_de_session.depense.diverse;

import ca.ulaval.glo4003.projet_de_session.repository.xml.RepoGeneralXml;

public class RepoDepenseDiverseXml extends
		RepoGeneralXml<DepenseDiverse> {

	public RepoDepenseDiverseXml() {
		super(DepenseDiverse.class, "depensesdiverse");
	}

	public String ajouter(DepenseDiverse depense) {

		String id = depense.obtIdentifiant();

		put(id, depense);

		return id;
	}

	public void modifier(DepenseDiverse depense) {

		String id = depense.obtIdentifiant();

		if (obt(id) != null) {
			put(id, depense);
		}
	}
}
