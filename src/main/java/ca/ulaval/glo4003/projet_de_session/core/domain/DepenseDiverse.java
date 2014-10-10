package ca.ulaval.glo4003.projet_de_session.core.domain;

public class DepenseDiverse extends Depense {

	private int nbRepas;

	public int getNbRepas() {
		return nbRepas;
	}

	public void setNbRepas(int nbRepas) {
		this.nbRepas = nbRepas;

	}

	private float coutRepas;

	public float getCoutRepas() {
		return coutRepas;
	}

	public void setValue(float coutRepas) {
		this.coutRepas = coutRepas;
	}

	private float divers;

	public float getDivers() {
		return divers;
	}

	public void setDivers(float divers) {
		this.divers = divers;
	}

	private float coucher;

	public float getCoucher() {
		return coucher;
	}

	public void setCoucher(float coucher) {
		this.coucher = coucher;
	}

}
