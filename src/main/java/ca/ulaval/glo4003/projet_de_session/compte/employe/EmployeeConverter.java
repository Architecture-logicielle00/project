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
		viewModel.nom = entry.obtNom();
		viewModel.prenom = entry.obtPrenom();
		viewModel.email = entry.obtEmail();
		viewModel.pays = entry.obtPays();
		viewModel.province = entry.obtProvince();
		viewModel.ville = entry.obtVille();
		viewModel.codePostal = entry.obtCodePostal();
		viewModel.telephone = entry.obtNumTelephone();
		viewModel.sexe = entry.obtGenre();
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
