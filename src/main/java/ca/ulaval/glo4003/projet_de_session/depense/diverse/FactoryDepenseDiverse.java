package ca.ulaval.glo4003.projet_de_session.depense.diverse;

public class FactoryDepenseDiverse {
	public DepenseDiverse creer(String identifiant, String date, String time,
			String description, int nbRepas, float coutRepas, float divers,
			float coucher){
		return new DepenseDiverse(identifiant, date, time,
				description, nbRepas, coutRepas, divers, coucher);
		
	}

}