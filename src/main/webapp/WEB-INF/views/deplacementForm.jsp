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
					<th>Description</th>
			</tr>
				<tr>
						<td style="height: 26px"></td>
						<td style="height: 26px"><input id="date" name="date"/></td>
						<td style="height: 26px"><input id="distance" name="distance"/></td>
						<td style="height: 26px"><input id="cout-km" name="cout-km"/></td>
						<td style="height: 26px"><input id="nb-repas" name="distance"/></td>
						<td style="height: 26px"><input id="cout-repas" name="distance"/></td>
						<td style="height: 26px"><input id="coucher" name="distance"/></td>
						<td style="height: 26px"><input id="divers" name="distance"/></td>
						<td style="height: 26px"><input id="sous-total" name="distance"/></td>
						<td style="height: 26px"><input id="description" name="distance"/></td>
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




