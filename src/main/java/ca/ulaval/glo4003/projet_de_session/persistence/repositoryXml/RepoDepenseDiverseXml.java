package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.text.SimpleDateFormat;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;

public class RepoDepenseDiverseXml extends
		RepoGeneralXml<DepenseDiverse> {

	private SimpleDateFormat dateFormatter;

	public RepoDepenseDiverseXml() {
		super(DepenseDiverse.class, "depensesdiverse");
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	}

	public String ajouter(DepenseDiverse depense) {

		String id = depense.getIdentifant() + depense.getDate()
				+ depense.getTime();

		put(id, depense);

		return id;
	}

	public void modifier(DepenseDiverse depense) {

		String id = depense.getIdentifant() + depense.getDate()
				+ depense.getTime();

		if (obt(id) != null) {
			put(id, depense);
		}
	}
}
