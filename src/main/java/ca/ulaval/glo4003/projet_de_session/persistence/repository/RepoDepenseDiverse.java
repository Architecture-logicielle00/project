package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Depense;

public interface RepoDepenseDiverse {
	
	public abstract void ajouter(Depense depense);

	public abstract Depense obtenir(String numeroDepense);

	public abstract List<Depense> obtTout();

	public abstract void supprimer(String numeroDepense);

	public abstract void modifier(Depense c1);
}
