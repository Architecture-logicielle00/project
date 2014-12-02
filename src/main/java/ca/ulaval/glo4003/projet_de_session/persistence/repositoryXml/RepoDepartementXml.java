package ca.ulaval.glo4003.projet_de_session.persistence.repositoryXml;

import ca.ulaval.glo4003.projet_de_session.core.domain.Departement;
import ca.ulaval.glo4003.projet_de_session.exception.DepartementIntrouvableException;

public class RepoDepartementXml extends RepoGeneralXml<Departement> {

	public RepoDepartementXml() {
		super(Departement.class, "departement");
	}

	@Override
	public String ajouter(Departement departement) {
		String id = construireIdentifiant(departement);
		put(id, departement);
			
		return id;
	}
	
	public Departement obt(String identifiantUnique){
		Departement departement = super.obt(identifiantUnique);
		
		if (departement == null)
			throw new DepartementIntrouvableException();
		
		return departement; 
	}

	@Override
	public void modifier(Departement departement) {
		modifier(construireIdentifiant(departement),departement);
	}

	
	private String construireIdentifiant(Departement departement){
		return departement.obtNomDepartement() + departement.obtEntreprise() ;
		}
	

}
