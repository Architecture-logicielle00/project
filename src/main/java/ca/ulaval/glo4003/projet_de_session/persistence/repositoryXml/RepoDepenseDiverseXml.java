package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import java.util.ArrayList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;
import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoDepenseDiverse;
import ca.ulaval.glo4003.projet_de_session.persistence.utils.Xml;

public class RepoDepenseDiverseXml implements RepoDepenseDiverse {
	ArrayList<Depense> depenses;
	Xml<Depense> xml;
	
	@Override
	public void ajouter(Depense depense) {
		depenses.add(depense);
	}

	@Override
	public Depense obtenir(String numeroDepense) {
		
		
		// TODO Auto-generated method stub
		return null;
		
		
	}

	@Override
	public List<Depense> obtTout() {
		return depenses;
	}

	@Override
	public void supprimer(String numeroDepense) {
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public void modifier(Depense c1) {
		// TODO Auto-generated method stub

	}

	private void charger() {
		// TODO Auto-generated method stub

	}

	private void sauvegarder() {
		// TODO Auto-generated method stub

	}

}
