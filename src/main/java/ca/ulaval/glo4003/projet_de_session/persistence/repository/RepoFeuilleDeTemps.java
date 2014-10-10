package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;

public interface RepoFeuilleDeTemps {

	public abstract void ajouter(FeuilleDeTemps e);

	public abstract FeuilleDeTemps obtenir(Long id);

	public abstract List<FeuilleDeTemps> obtTout();

	public abstract void supprimer(Long id);

	public abstract void modifier(FeuilleDeTemps c1);

	public abstract void charger();

	public abstract void sauvegarder();

}