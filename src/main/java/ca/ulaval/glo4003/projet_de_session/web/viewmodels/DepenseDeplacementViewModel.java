package ca.ulaval.glo4003.projet_de_session.web.viewmodels;

import java.util.Date;

public class DepenseDeplacementViewModel {

	// Déclarations de variables
		public String indentifiant;
		public Date date;
		public float distance;
		public float coutkm;
		public int nbRepas;
		public float coutRepas;
		public float divers;
		public float coucher;
		public float sousTotal;
		public String description;
		public float total;

		public String obtIdentifant() {
			return indentifiant;
		}

		public void defIdentifiant(String indentifiant) {
			this.indentifiant = indentifiant;

		}

		public Date obtDate() {
			return date;
		}

		public void defDate(Date date) {
			this.date = date;

		}

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


		public float obtSoutTotal() {
			return sousTotal;
		}

		public void defSousTotal(float sousTotal) {
			this.sousTotal = sousTotal;
		}
		
		public String obtDescription() {
			return description;
		}

		public void defDescription(String description) {
			this.description = description;

		}

		public float obtTotalDepense() {
			return total;
		}
}
