package ca.ulaval.glo4003.projet_de_session.core.domain;

public class DepenseDiverse extends Depense {

	private int nbRepas;

	public int obtNbRepas() {
		return nbRepas;
	}

	public void defNbRepas(int nbRepas) {
		this.nbRepas = nbRepas;

	}

	private float coutRepas;

	public float obtCoutRepas() {
		return coutRepas;
	}

	public void defValue(float coutRepas) {
		this.coutRepas = coutRepas;
	}

	private float divers;

	public float obtDivers() {
		return divers;
	}

	public void defDivers(float divers) {
		this.divers = divers;
	}

	private float coucher;

	public float obtCoucher() {
		return coucher;
	}

	public void defCoucher(float coucher) {
		this.coucher = coucher;
	}

}
