package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import ca.ulaval.glo4003.projet_de_session.core.domain.Entreprise;

public class RepoEntrepriseXml extends RepoGeneralXml<Entreprise> {

	public RepoEntrepriseXml()
	{
		super(Entreprise.class,"entreprise");
	}

	@Override
	public String ajouter(Entreprise e) {
		if (obt( e.obtNomUtilisateur() ) == null)
		{
			put(e.obtNomUtilisateur(), e);
		}
		
		return e.obtNomUtilisateur();
	}

	@Override
	public void modifier(Entreprise e) {
		if(obt( e.obtNomUtilisateur() ) != null)
		{
			put(e.obtNomUtilisateur(), e);
		}
	}
}
