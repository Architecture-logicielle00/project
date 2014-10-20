
package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDeplacement;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoDepenseDeplacementXml implements RepoDepenseDeplacement {
	ArrayList<DepenseDeplacement> depenseDeplacement;
	Xml<DepenseDeplacement> xmlDepense;

	public RepoDepenseDeplacementXml() {

		xmlDepense = new Xml<DepenseDeplacement>(DepenseDeplacement.class);

	}

	private ArrayList<DepenseDeplacement> obtenirListe() {
		if (depenseDeplacement == null)
			charger();
		return depenseDeplacement;

	}

	public void ajouter(DepenseDeplacement depense) {
		depenseDeplacement.add(depense);
		sauvegarder();
	}

	public DepenseDeplacement obtenir(String identifiantDepense) {
		// for (DepenseDeplacement depenseDeplacement : depenseDeplacement) {
		// if (depenseDeplacement.obtIdentifant() == identifiantDepense)
		// return depenseDeplacement;
		// }

		return null;
	}

	public List<DepenseDeplacement> obtTout() {
		return depenseDeplacement;
	}

	public void supprimer(DepenseDeplacement depense) {
		depenseDeplacement.remove(depense);
		sauvegarder();
	}

	public void modifier(DepenseDeplacement depense) {

		sauvegarder();
	}

	private void charger() {
		depenseDeplacement.clear();
		depenseDeplacement = (ArrayList<DepenseDeplacement>) xmlDepense
				.charger("xmlfiles/depenses");
	}

	private void sauvegarder() {
		xmlDepense.enregistrer(depenseDeplacement, "xmlfiles/depenses");
	}
}

