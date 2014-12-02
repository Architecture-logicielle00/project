package ca.ulaval.glo4003.projet_de_session.compte.entreprise.departement;

import java.util.ArrayList;


public class FactoryDepartement {
	public Departement creerDepartement(String _nomDepartement, String _nomEntreprise, ArrayList<String> _projets)
	{
		return new Departement(_nomDepartement, _nomEntreprise, _projets);
	}
}
