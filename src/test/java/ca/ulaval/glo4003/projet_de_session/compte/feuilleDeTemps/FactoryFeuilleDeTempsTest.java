package ca.ulaval.glo4003.projet_de_session.compte.feuilleDeTemps;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import ca.ulaval.glo4003.projet_de_session.compte.employe.Employe;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FactoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.FeuilleDeTemps;

public class FactoryFeuilleDeTempsTest {

	private FactoryFeuilleDeTemps facto;
	
	private String employeID = "employeID";
	private Employe _employe;
	private Date _debut; 
	private Date _fin;

	private static Date createDate(int annee, int mois, int jour){
		Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, annee);
	    cal.set(Calendar.MONTH, mois);
	    cal.set(Calendar.DAY_OF_MONTH, jour);
	    return cal.getTime();
	}
	
	@Before
	public void setUp() throws Exception {
		_employe = new Employe(employeID,"","","","","","","","",createDate(1991, 04, 17),"","");
		
		_debut = createDate(2012, 12, 12);
		_fin = createDate(2018, 12, 12);
		
		facto = new FactoryFeuilleDeTemps();
	}
	
	private boolean estValide(FeuilleDeTemps feuille){
		return
				feuille.obtDebut() == _debut &&
				feuille.obtFin() == _fin &&
				feuille.obtIdentifiant().equals(employeID);
	}
	
	@Test
	public void creeFeuilleAvecEmploye(){
		FeuilleDeTemps feuille = facto.creerFeuilleDeTemps(_employe, _debut, _fin);
		
		assertTrue(estValide(feuille));
	}
	
	@Test
	public void creeFeuilleAvecEmployeId(){
		FeuilleDeTemps feuille = facto.creerFeuilleDeTemps(employeID, _debut, _fin);
		
		assertTrue(estValide(feuille));
	}
}
