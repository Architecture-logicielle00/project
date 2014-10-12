package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.Map;

import ca.ulaval.glo4003.projet_de_session.core.domain.FeuilleDeTemps;

public interface RepoFeuilleDeTemps {

	public abstract String ajouter(FeuilleDeTemps e);

	public abstract FeuilleDeTemps obtenir(String id);

	public abstract Map<String, FeuilleDeTemps> obtTout();

	public abstract void supprimer(String id);

	public abstract void modifier(String id, FeuilleDeTemps feuille);

	public abstract void charger();

	public abstract void sauvegarder();

}