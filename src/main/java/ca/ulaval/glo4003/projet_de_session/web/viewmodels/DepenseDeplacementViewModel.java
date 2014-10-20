package ca.ulaval.glo4003.projet_de_session.web.viewmodels;


public class DepenseDeplacementViewModel extends  DepenseViewModel {

	public float distance;
	public float coutkm;
	public int nbRepas;
	public float coutRepas;
	public float divers;
	public float coucher;
	public float sousTotal;
	public String description;
	public float total;

	public float obtDistance() {
		return distance;
	}

	public void defDistance(float distance) {
		this.distance = distance;
	}

	public float obtCoutKm() {
		return coutkm;
	}

	public void defCoutkm(float CoutKm) {
		this.coutkm = CoutKm;
	}

}
