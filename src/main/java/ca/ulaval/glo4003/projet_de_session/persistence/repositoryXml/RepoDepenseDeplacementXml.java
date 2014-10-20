
package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoDepenseDeplacementXml implements RepoDepenseDeplacement {
	ArrayList<DepenseDeplacement> depensesDeplacement;
	Xml<DepenseDeplacement> xmlDepense;

	public RepoDepenseDeplacementXml() {

		xmlDepense = new Xml<DepenseDeplacement>(DepenseDeplacement.class);

	}

	private ArrayList<DepenseDeplacement> obtenirListe() {
		if (depensesDeplacement == null)
			charger();
		return depensesDeplacement;

	}

	public void ajouter(DepenseDeplacement depense) {
		depensesDeplacement.add(depense);
		sauvegarder();
	}
	@Override
	public DepenseDeplacement obtenir(String identifiantDepense) {
		for (DepenseDeplacement depenseDeplacement : depensesDeplacement) {
			if (depenseDeplacement.obtIdentifant() == identifiantDepense)
				return depenseDeplacement;
		}

		// TODO Lancer une exeption
		return null;
	}

	public List<DepenseDeplacement> obtTout() {
		return depensesDeplacement;
	}

	public void supprimer(DepenseDeplacement depense) {
		depensesDeplacement.remove(depense);
		sauvegarder();
	}

	public void modifier(DepenseDeplacement depense) {

		sauvegarder();
	}

	private void charger() {
		depensesDeplacement.clear();
		depensesDeplacement = (ArrayList<DepenseDeplacement>) xmlDepense
				.charger("xmlfiles/depenses");
	}

	private void sauvegarder() {
		xmlDepense.enregistrer(depensesDeplacement, "xmlfiles/depenses");
	}
}

