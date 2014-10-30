package ca.ulaval.glo4003.projet_de_session.persistence.repository;

import java.util.List;
import java.util.Map;

public interface Repository<T> {

	public abstract String ajouter(T objetAAjouter);
	
	public void modifier(T objetAModifier);
	
	public void modifier(String identification,T objetAModifier);

	public abstract List<T> obtTout();

	public abstract Map<String, T> obtMap();

	public abstract void supprimer(T objetAAupprimer);

	public abstract T obt(String identifiantUnique);

	public abstract void supprimer(String identifiantUnique);
}