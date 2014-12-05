package ca.ulaval.glo4003.projet_de_session.compte.departement;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.Departement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.FactoryDepartement;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.Projet;

public class FactoryDepartementTest {

	private static FactoryDepartement facto;
	
	@Before
	public void setUp() throws Exception {
		facto = new FactoryDepartement();
	}

	private String nom = "nom";
	
	private List<Projet> getProjets(){
		List<Projet> projets = new ArrayList<Projet>();
		
		int nbProjet = 5;
		
		for (int i = 0; i < nbProjet; i++){
			Projet projet = Mockito.mock(Projet.class);
			
			Mockito.when(projet.obtNom()).thenReturn(Integer.toString(i));
			
			projets.add(projet);
		}
		
		return projets;
	}
	
	private boolean estProjetValide(Departement departement){
		List<Projet> projetsDep =departement.obtProjets();
		List<Projet> projets = getProjets();
		
		boolean valide = projetsDep.size() == projets.size();
		
		for (int i = 0; i < projetsDep.size() ; i++){
			if (!valide)
				break;
			
			valide = projetsDep.get(i).obtNom().equals(projets.get(i).obtNom());
		}
		
		return valide;
	}

	@Test
	public void creeDepartementVideTest(){
		Departement departement = facto.creerDepartement(nom);
		
		assertTrue(departement.obtNomDepartement() == nom);
	}
	
	@Test
	public void creeDepartementAvecProjet(){
		Departement departement = facto.creerDepartement(nom,getProjets());
		
		assertTrue(departement.obtNomDepartement() == nom);
		assertTrue(estProjetValide(departement));
	}
	
}
