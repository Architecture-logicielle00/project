package ca.ulaval.glo4003.projet_de_session.depense.diverse;

import java.text.SimpleDateFormat;

import ca.ulaval.glo4003.projet_de_session.repository.xml.RepoGeneralXml;

public class RepoDepenseDiverseXml extends
		RepoGeneralXml<DepenseDiverse> {

	private SimpleDateFormat dateFormatter;

	public RepoDepenseDiverseXml() {
		super(DepenseDiverse.class, "depensesdiverse");
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	}

	public String ajouter(DepenseDiverse depense) {

		String id = depense.obtIdentifiant() + depense.obtDate()
				+ depense.obtTime();

		put(id, depense);

		return id;
	}

	public void modifier(DepenseDiverse depense) {

		String id = depense.obtIdentifiant() + depense.obtDate()
				+ depense.obtTime();

		if (obt(id) != null) {
			put(id, depense);
		}
	}
}
