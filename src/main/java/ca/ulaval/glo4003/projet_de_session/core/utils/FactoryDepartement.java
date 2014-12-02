package ca.ulaval.glo4003.projet_de_session.core.utils;

import java.util.ArrayList;

import ca.ulaval.glo4003.projet_de_session.core.domain.Departement;


public class FactoryDepartement {
	public Departement creerDepartement(String _nomDepartement, String _nomEntreprise, ArrayList<String> _projets)
	{
		return new Departement(_nomDepartement, _nomEntreprise, _projets);
	}
}
