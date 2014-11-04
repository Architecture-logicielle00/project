package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

public class DepenseDeplacementViewModel extends DepenseViewModel {

	public float distance;
	public float coutKm;

	public float obtDistance() {
		return distance;
	}

	public void defDistance(float distance) {
		this.distance = distance;
	}

	public float obtCoutKm() {
		return coutKm;
	}

	public void defCoutkm(float CoutKm) {
		this.coutKm = CoutKm;
	}

}
