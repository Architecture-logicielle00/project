<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap.css.map" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap-theme.css.map" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/css/layout.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/deplacementForm.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">

		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper">
			<button id="ajouter-nouvelle-ligne">ajouter ligne</button>
			<button id="supprimer-nouvelle-ligne">supprimer ligne</button>

			<table id="table-depense-deplacement">
				<tr>
					<th></th>
					<th>Date</th>
					<th>Distance(Km)</th>
					<th>Cout($/Km)</th>
					<th>Nombre Repas</th>
					<th>Couts de repas ($/repas)</th>
					<th>Couts de logement</th>
					<th>Divers</th>
					<th>Sous-total</th>
				</tr>
				<c:forEach var="blocDeDepense" items="${formulaire.obtNbBlocDeDepense()}">
					<tr>
						<td><input type="checkbox"/></td>
						<td><input class="date row-input" type="text" value="${blocDeDepense.date}"/></td>
						<td><input class="distance row-input" type="text" value="${blocDeDepense.distance}"/></td>
						<td><input class="cout-km row-input" type="text" value="${blocDeDepense.coutKm}"/></td>
						<td><input class="nb-repas row-input" type="text" value="${blocDeDepense.nbRepas}"/></td>
						<td><input class="cout-repas row-input" type="text" value="${blocDeDepense.coutRepas}"/></td>
						<td><input class="coucher row-input" type="text" value="${blocDeDepense.coucher}"/></td>
						<td><input class="divers row-input" type="text" value="${blocDeDepense.divers}"/></td>
						<td><input class="sous-total" type="text" readonly="true" /></td>
					</tr>
				</c:forEach>
			</table>

			<input id="total" type="text" readonly="true" />

			<button id="sauvegarder-feuille">sauvegarder</button>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/jquery-ui.js"></script>
	<script src="/resources/js/lib/bootstrap.min.js"></script>
	<script src="/resources/js/deplacementForm/deplacementForm.js"></script>

</body>
</html>




