package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDeplacement;

public interface RepoDepenseDeplacement {

	public abstract void ajouter(DepenseDeplacement depense);
	
	// Inutile...

	public abstract DepenseDeplacement obtenir(String identifiantDepense);

	public abstract List<DepenseDeplacement> obtTout();

	public abstract void supprimer(DepenseDeplacement depense);

	public abstract void modifier(DepenseDeplacement depense);
}
