package ca.ulaval.glo4003.projet_de_session.compte.employe;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.compte.Utilisateur;

public class EmployeeConverter {

	public static Collection<EmployeeViewModel> convert(List<Employe> entries) {
		Collection<EmployeeViewModel> viewModels = new LinkedList<EmployeeViewModel>();
		for (Utilisateur entry : entries) {
			EmployeeViewModel viewModel = convert((Employe)entry);
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public static EmployeeViewModel convert(Employe entry) {
		EmployeeViewModel viewModel = new EmployeeViewModel();
		viewModel.nomUtilisateur = entry.obtNomUtilisateur();
		
		viewModel.nom = entry.getInformationPersonelle().nom;
		viewModel.prenom = entry.getInformationPersonelle().prenom;
		viewModel.email = entry.getInformationPersonelle().email;
		viewModel.pays = entry.getInformationPersonelle().pays;
		viewModel.province = entry.getInformationPersonelle().province;
		viewModel.ville = entry.getInformationPersonelle().ville;
		viewModel.codePostal = entry.getInformationPersonelle().codePostal;
		viewModel.telephone = entry.getInformationPersonelle().numTelephone;
		viewModel.sexe = entry.getInformationPersonelle().genre;
		viewModel.statutGestionnaire = entry.estGestionnaire();

		return viewModel;
	}
	
	public Employe convert(EmployeeViewModel evm)
	{
		return (new FactoryEmploye()).creerEmploye(evm.nomUtilisateur, evm.nom, evm.prenom,
				evm.email, evm.pays, evm.province, evm.ville, evm.codePostal, evm.sexe,
				evm.telephone, evm.statutGestionnaire);
	}
}
