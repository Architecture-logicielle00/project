package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public class BlocDeTemps {
	
	public BlocDeTemps(String _projet, String _tache, Date _jour, float _nbHeure)
	{
		projet = _projet;
		tache = _tache;
		jour = _jour;
		nbHeure = _nbHeure;
	}
	
	public String obtProjet() { return projet; }
	public String obtTache() { return tache; }
	public Date obtJour() { return jour; }
	public float obtNbHeure() { return nbHeure; }
	
	public void changerProjet(String _projet) { projet = _projet; }
	public void changerTache(String _tache) { tache = _tache; }
	public void changerJour(Date _jour) { jour = _jour; }
	public void changerNbHeure(float _nbHeure) { nbHeure = _nbHeure; }
	
	private String projet;
	private String tache;
	private Date jour;
	private float nbHeure;
}
