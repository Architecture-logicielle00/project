package ca.ulaval.glo4003.projet_de_session.web.controllers;

import ca.ulaval.glo4003.projet_de_session.dao.RepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IAccesModel;
import ca.ulaval.glo4003.projet_de_session.imodel.IConverter;
import ca.ulaval.glo4003.projet_de_session.imodel.IIdentificateur;
import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryFeuilleDeTemps;
import ca.ulaval.glo4003.projet_de_session.imodel.IRepositoryUtilisateur;
import ca.ulaval.glo4003.projet_de_session.mock.FakeIdentificateur;
import ca.ulaval.glo4003.projet_de_session.model.Utilisateur;
import ca.ulaval.glo4003.projet_de_session.web.converters.Converter;
import ca.ulaval.glo4003.projet_de_session.web.converters.FeuilleDeTempsConverter;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.EmployeViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.FeuilleDeTempsViewModel;
import ca.ulaval.glo4003.projet_de_session.web.viewmodels.UtilisateurViewModel;

public class AccesModel implements IAccesModel {
	private IIdentificateur identificateur;
	private IRepositoryUtilisateur repoUtilisateur;
	private IConverter converter;
	private IRepositoryFeuilleDeTemps repoFeuilleDeTemps;
	
	public AccesModel() {
		identificateur = new FakeIdentificateur();
		repoUtilisateur = new RepositoryUtilisateur();
		converter = new Converter();
	}
	
	public Boolean identificationValide(String _nomUtilisateur, String _mdp)
	{
		return identificateur.connectionValide(_nomUtilisateur, _mdp);
	}
	
	public void creerUtilisateur(String _nomUtilisateurNouveauCompte, String _mdp)
	{
		repoUtilisateur.ajouterUtilisateur(_nomUtilisateurNouveauCompte, _mdp);
	}
	
	public void creerUtilisateur(EmployeViewModel _nouveauUtilisateur)
	{
		//repoUtilisateur.AjouterUtilisateur(_nomUtilisateurNouveauCompte, _mdp);
	}
	
	public void sauvegarderFeuilleDeTemps(String _nomUtilisateur, FeuilleDeTempsViewModel feuilleDeTemps)
	{
		//repoFeuilleDeTemps.AjouterFeuilleDeTemps(_nomUtilisateur, FeuilleDeTempsConverter.Convert(feuilleDeTemps));
	}
	
	public UtilisateurViewModel convert(Utilisateur utilisateur)
	{
		return converter.convert(utilisateur);
	}
}
