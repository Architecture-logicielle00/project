package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.DepenseDiverse;

public interface RepoDepenseDiverse {
	
	public abstract void ajouter(DepenseDiverse depense);

	public abstract DepenseDiverse obtenir(String identifiantDepense);

	public abstract List<DepenseDiverse> obtTout();

	public abstract void supprimer(DepenseDiverse depense);

	public abstract void modifier(DepenseDiverse depense);
}
