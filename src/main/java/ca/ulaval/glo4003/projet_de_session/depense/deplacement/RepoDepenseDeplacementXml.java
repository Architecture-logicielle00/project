package ca.ulaval.glo4003.projet_de_session.depense.deplacement;

import java.text.SimpleDateFormat;

import ca.ulaval.glo4003.projet_de_session.repository.xml.RepoGeneralXml;

public class RepoDepenseDeplacementXml extends
		RepoGeneralXml<DepenseDeplacement> {

	private SimpleDateFormat dateFormatter;

	public RepoDepenseDeplacementXml() {
		super(DepenseDeplacement.class, "depensesDeplacement");
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	}

	public String ajouter(DepenseDeplacement depense) {

		String id = depense.obtIdentifiant() + depense.obtDate()
				+ depense.obtTime();

		put(id, depense);

		return id;
	}

	public void modifier(DepenseDeplacement depense) {

		String id = depense.obtIdentifiant() + depense.obtDate()
				+ depense.obtTime();

		if (obt(id) != null) {
			put(id, depense);
		}
	}
}
