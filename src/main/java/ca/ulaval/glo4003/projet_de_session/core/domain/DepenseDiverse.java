package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public class DepenseDiverse extends Depense {

	public DepenseDiverse(String _identifiant, Date _date, String _time, String _description, int _nbRepas,
			float _coutRepas, float _divers, float _coucher) {
		super(_identifiant, _date, _time, _description);

		nbRepas = _nbRepas;
		coutRepas = _coutRepas;
		divers = _divers;
		coucher = _coucher;

	}

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
