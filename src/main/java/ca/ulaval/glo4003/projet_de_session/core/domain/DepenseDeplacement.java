package ca.ulaval.glo4003.projet_de_session.core.domain;

import java.util.Date;

public class DepenseDeplacement extends Depense {

	public DepenseDeplacement(String _identifiant, String _date, String _time, String _description, float _distance,float _coutkm) {
		super(_identifiant, _date, _time, _description);
		
		distance = _distance;
		coutkm = _coutkm;
		
	}

	public DepenseDeplacement() {
		// TODO Auto-generated constructor stub
	}

	private float distance;

	private float coutkm;

	public float obtDistance() {
		return distance;
	}

	public void defDistance(float distance) {
		this.distance = distance;
	}

	public float obtCoutKm() {
		return coutkm;
	}

	public void defCoutKm(float coutkm) {
		this.coutkm = coutkm;
	}

}
