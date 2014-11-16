package ca.ulaval.glo4003.projet_de_session.core.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.ulaval.glo4003.projet_de_session.core.domain.Employe;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryEmploye;
import ca.ulaval.glo4003.projet_de_session.core.utils.FactoryRepository;
import ca.ulaval.glo4003.projet_de_session.core.utils.converter.EmployeeConverter;
import ca.ulaval.glo4003.projet_de_session.persistence.repository.Repository;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;

@Service
public class ServiceEmploye
{
	
	Repository<Employe> repo;
	FactoryEmploye factory;
	EmployeeConverter ec;
	
	public ServiceEmploye()
	{
		factory = new FactoryEmploye();
		repo = FactoryRepository.cree(Employe.class);
		ec = new EmployeeConverter();
	}
	
	public Employe obtEmploye(String nomUtilisateur)
	{
		return repo.obt(nomUtilisateur);
	}
	
	public void creerEmploye(EmployeeViewModel evm)
	{
		Employe e = ec.convert(evm);
		repo.ajouter(e);
	}
	
	public void modifierEmploye(Employe employe)
	{
		repo.modifier(employe);
	}
	
	public List<Employe> obtEmployes()
	{
		return repo.obtTout();
	}
	
	public List<Employe> obtEmployesParEntreprise(String entreprise)
	{
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
	
	public void modifierEmployeExistant(EmployeeViewModel evm)
	{
		Employe e = obtEmploye(evm.nomUtilisateur);
		
		e.defCodePostal(evm.codePostal);
		e.defDateDeNaissance(new Date()); // Date fictive
		e.defEmail(evm.email);
		e.defGenre(evm.sexe);
		e.defNom(evm.nom);
		e.defNumTelephone(evm.telephone);
		e.defPays(evm.pays);
		e.defPrenom(evm.prenom);
		e.defProvince(evm.pays);
		e.defStatutGestionnaire(evm.statutGestionnaire);
		e.defVille(evm.ville);
	}
}
