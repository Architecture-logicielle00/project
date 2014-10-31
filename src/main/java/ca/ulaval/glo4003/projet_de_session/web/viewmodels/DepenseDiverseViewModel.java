package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class DepenseDiverseViewModel extends DepenseViewModel {

	public int nbRepas;
	public float coutRepas;

	public float divers;
	public float coucher;


	public int obtNbRepas() {
		return nbRepas;
	}

	public void defNbRepas(int nbRepas) {
		this.nbRepas = nbRepas;
	}

	public float obtCoutRepas() {
		return coutRepas;
	}

	public void defCoutRepas(float coutRepas) {
		this.coutRepas = coutRepas;
	}

	public float obtDivers() {
		return divers;
	}

	public void defDivers(float divers) {
		this.divers = divers;
	}

	public float obtCoucher() {
		return coucher;
	}

	public void defCoucher(float coucher) {
		this.coucher = coucher;
	}

}
