package ca.ulaval.glo4003.projet_de_session.compte.employe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.compte.entreprise.ServiceEntreprise;
import ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement.projet.tache.EmployeTachesViewModel;
import ca.ulaval.glo4003.projet_de_session.feuilleDeTemps.ServiceFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.repository.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.repository.Repository;

@Service
public class ServiceEmploye
{
	Repository<Employe> repo;
	FactoryEmploye factory;
	EmployeeConverter ec;
	
	@Autowired
	ServiceFeuilleDeTemps serviceFeuilleDeTemps;
	@Autowired
	ServiceEntreprise serviceEntreprise;
	
	public ServiceEmploye(Repository<Employe> _repo){
		repo = _repo;
		factory = new FactoryEmploye();
		ec = new EmployeeConverter();
	}
	
	public ServiceEmploye(){
		factory = new FactoryEmploye();
		repo = FactoryRepository.cree(Employe.class);
		ec = new EmployeeConverter();
		
		init();
	}
	
	public Employe obtEmploye(String nomUtilisateur){
		return repo.obt(nomUtilisateur);
	}
	
	public void creerEmploye(EmployeeViewModel evm, String nomGestionnaire){
		Employe gestionnaire = obtEmploye(nomGestionnaire);
		Employe employe = ec.convert(evm);
		
		employe.defEntreprise(gestionnaire.obtEntreprise());
		employe.defDepartement(gestionnaire.obtDepartement());
		
		repo.ajouter(employe);
		
		serviceEntreprise.ajouterEmploye(employe.obtNomUtilisateur());
	}
	
	public void modifierEmploye(Employe employe){
		repo.modifier(employe);
	}
	
	public List<Employe> obtEmployes(){
		return repo.obtTout();
	}
	
	public List<Employe> obtEmployesParEntreprise(String entreprise){
		List<Employe> repoList =  obtEmployes();
		List<Employe> entrepriseList = new ArrayList<Employe>();
		
		for (Employe e : repoList)
		{
			if ( e.estEmployeDe(entreprise) )
			{
				entrepriseList.add(e);
			}
		}
		return entrepriseList;
	}
	
	public void assignerTachesAEmployes(List<EmployeTachesViewModel> employeTachesViewModels)
	{
		for (EmployeTachesViewModel employeTVM: employeTachesViewModels)
		{
			Employe employe = obtEmploye(employeTVM.nomUtilisateur);
			employe.defTaches(employeTVM.taches);
			modifierEmploye(employe);
			
			serviceFeuilleDeTemps.assignerTachesAFeuilleCourrant(employeTVM.nomUtilisateur, employeTVM.taches);
		}
	}
	
	//TO REMOVE
	public boolean verifierMotDePasse(String nomUtilisateur, String motDePasse){
		Employe e = obtEmploye(nomUtilisateur);
		if(e != null) return e.motDePasseEstValide(motDePasse);
		return false;
	}
	
	public EmployeeViewModel obtEmployeViewModel(String nomUtilisateur){
		return ec.convert( obtEmploye(nomUtilisateur) );
	}
	
	public Collection<EmployeeViewModel> obtEmployesViewModel(){
		return ec.convert( obtEmployes() );
	}
	
	private void init()
	{
		Employe e = factory.creerEmploye("OLDU", "Dugas", "Olivier", "aa@aa.com", "Canada", "Quebec", "Quebec", "X0X0X0", "Homme", "(418)843-8888", true);
		e.defDepartement("Service personnel");
		e.defEntreprise("desj");
		repo.ajouter(e);
	}
}
