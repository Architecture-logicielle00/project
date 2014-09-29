package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryEmploye;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.RepoEmploye;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

public class ServiceEmploye
{
	public ServiceEmploye()
	{
		factory = new FactoryEmploye();
		repo = new RepoEmploye(factory);
		ec = new EmployeeConverter();
		
		init();
	}
	
	public Employe obtEmploye(String nomUtilisateur)
	{
		return repo.obtenir(nomUtilisateur);
	}
	
	public void creerEmploye(String nomUtilisateur,
			String mdp,
			String nom,
			String prenom,
			String entreprise,
			String email,
			String pays,
			String province,
			String ville,
			String codePostal,
			Integer jour,
			Integer mois,
			Integer annee,
    		String genre,
    		String telephone)
	{
		Employe e = factory.creerEmploye(nomUtilisateur,mdp, nom, prenom, entreprise, email, pays, province,
				ville, codePostal, jour, mois, annee, genre, telephone);
		repo.ajouter(e);
	}
	
	public List<Employe> obtEmployes()
	{
		return repo.obtEmployes();
	}
	
	public List<Employe> obtEmployesParEntreprise(String entreprise)
	{
		List<Employe> repoList =  repo.obtEmployes();
		List<Employe> entrepriseList = new ArrayList<Employe>();
		
		for (Employe e : repoList)
		{
			if ( e.obtEntreprise().equals(entreprise) )
			{
				entrepriseList.add(e);
			}
		}
		return entrepriseList;
	}
	
	public boolean verifierMotDePasse(String nomUtilisateur, String motDePasse)
	{
		Employe e = obtEmploye(nomUtilisateur);
		if(e != null) return e.motDePasseValide(motDePasse);
		return false;
	}
	
	public EmployeeViewModel obtEmployeViewModel(String nomUtilisateur)
	{
		return ec.convert( obtEmploye(nomUtilisateur) );
	}
	
	public Collection<EmployeeViewModel> obtEmployesViewModel()
	{
		return ec.convert( obtEmployes() );
	}
	
	
	private void init()
	{
		/* Je le garde au cas ou on supprime le fichier xml par erreur et qu'on vu le refaire
		 * 
		String mdp = "12345";
		
		creerEmploye("JFGRA", mdp,  "Gravel", "Jean-François", "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("ALSAM", mdp, "Samson","Alexandra",  "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("DASAU", mdp, "Sauvé", "David", "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("JPDEL", mdp, "Delisle","Jean-Phillipe", "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("MOMEC", mdp, "Mechqrane","Mounir", "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("WAHJK", mdp, "Maksoud","Walid", "", "", "", "", "", "", 0, 0, 0, "", "");
		creerEmploye("LAHOL", mdp, "Holy","Laurianne", "", "", "", "", "", "", 0, 0, 0, "", "");
		
		creerEmploye("OLDU", mdp, "Dugas", "Olivier", "", "", "", "", "", "", 0, 0, 0, "", "");
		obtEmploye("OLDU").changerStatutGestionnaire(true);
		
		repo.sauvegarder();
		*/
		repo.charger();
	}

	
	RepoEmploye repo;
	FactoryEmploye factory;
	EmployeeConverter ec;
}
