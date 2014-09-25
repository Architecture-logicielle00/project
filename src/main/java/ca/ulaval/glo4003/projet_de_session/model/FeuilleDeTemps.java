package ca.ulaval.glo4003.projet_de_session.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FeuilleDeTemps {
	private List<BlocDeTemps> BlocsDeTemps = new ArrayList<BlocDeTemps>();
	private Date dateDebut;
	private Date dateFin;
	
	public Date obtDebut(){ return dateDebut; }
	public Date obtFin(){ return dateFin; }
	
}
