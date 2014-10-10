package ca.ulaval.glo4003.projet_de_session.core.domain;

public class DepenseDeplacement extends Depense {

	private float distance;

	public float obtDistance() {
		return distance;
	}

	public void defDistance(float distance) {
		this.distance = distance;

	}

	private float coutkm;

	public float obtCoutKm() {
		return coutkm;
	}

	public void defValue(float coutkm) {
		this.coutkm = coutkm;
	}

}
