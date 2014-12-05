package ca.ulaval.glo4003.projet_de_session.compte.entreprise;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.FactoryDepartement;

public class EntrepriseTest {

	private String nomUtilisateur = "nomUtilisateur"; 
	private String mdp ="mdp" ;
	private String nom ="nom" ;
	
	private String nomDepartement = "nomDepartement";
	
	private Entreprise obtenirEntreprise(boolean vraiFactory)
	{
		if (vraiFactory)
			return new Entreprise(nomUtilisateur, mdp, nom);
		else
			return new Entreprise(nomUtilisateur, mdp, nom,  obtenirFactoryDepartement());
	}
	
	private FactoryDepartement obtenirFactoryDepartement()
	{
		FactoryDepartement factoryDepartement = Mockito.mock(FactoryDepartement.class);
		
		Mockito.when(factoryDepartement.creerDepartement(nomDepartement)).thenReturn(new Departement(nomDepartement));
		
		return factoryDepartement;
	}
	
	public boolean estValide(Departement dep1, Departement dep2)
	{
		return 
				nomDepartement == dep1.obtNomDepartement() &&
				dep1.obtNomDepartement() == dep1.obtNomDepartement();
	}
	
	@Test
	public void createObtenirDepartementTest()
	{
		Entreprise ent = obtenirEntreprise(false);
		
		Departement departementCree = ent.createDepartement(nomDepartement);
		
		Departement departementRetrouver = ent.getDepartement(nomDepartement);
		
		assertTrue(estValide(departementCree,departementRetrouver));
	}
	
	@Test
	public void createDeleteDepartementTest()
	{
		Entreprise ent = obtenirEntreprise(false);
		
		ent.createDepartement(nomDepartement);
		
		ent.deleteDepartement(nomDepartement);
		
		Departement departementRetrouver = ent.getDepartement(nomDepartement);
		
		assertTrue(departementRetrouver == null);
	}
	
	@Test
	public void listDepartementDepartementTest()
	{
		Entreprise ent = obtenirEntreprise(true);
		
		int nombreDepartement = 5;
		
		for (int i = 0; i < nombreDepartement; i++)
			ent.createDepartement(Integer.toString(i));
		
		List<Departement> departements = ent.getDepartements();
		
		assertTrue(departements.size() == nombreDepartement);
	}
	
}
