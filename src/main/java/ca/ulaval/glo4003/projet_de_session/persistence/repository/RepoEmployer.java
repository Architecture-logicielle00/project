package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;

public interface RepoEmployer {

	public abstract void ajouter(Employe e);

	public abstract Employe obtenir(String nomUtilisateur);

	public abstract List<Employe> obtEmployes();

	public abstract void supprimer(String nomUtilisateur);

	public abstract void charger();

	public abstract void sauvegarder();

}