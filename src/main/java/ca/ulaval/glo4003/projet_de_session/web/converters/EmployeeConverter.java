package ca.ulaval.glo4003.projet_de_session.web.converters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.projet_de_session.model.Employee;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeeViewModel;



public class EmployeeConverter {

	public Collection<EmployeeViewModel> convert(List<Utilisateur> entries) {
		Collection<EmployeeViewModel> viewModels = new LinkedList<EmployeeViewModel>();
		for (Utilisateur entry : entries) {
			EmployeeViewModel viewModel = convert((Employee)entry);
			viewModels.add(viewModel);
		}
		return viewModels;
	}
	
	public EmployeeViewModel convert(Employee entry) {
		EmployeeViewModel viewModel = new EmployeeViewModel();
		viewModel.nomUsager = entry.obtNomUtilisateur();
		viewModel.nom = entry.obtNom();
		viewModel.prenom = entry.obtPrenom();
		viewModel.email = entry.obtEmail();
		viewModel.pays = entry.obtPays();
		viewModel.province = entry.obtProvince();
		viewModel.ville = entry.obtVille();
		viewModel.codePostal = entry.obtCodePostal();
		viewModel.telephone = entry.obtNumTelephone();
		viewModel.jour = entry.obtJourDeNaissance();
		viewModel.mois = entry.obtMoisDeNaissance();
		viewModel.annee = entry.obtAnneeDeNaissance();
		viewModel.sexe= entry.obtGenre();

		return viewModel;
	}
}
