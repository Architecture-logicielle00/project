<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="cache-control" content="no-cache">
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
	href="/resources/css/callBack.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/timeSheet.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">

		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper">
			<div id="callBackModal" class="modal fade bs-example-modal-lg"
				tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<i class="fa fa-spinner fa-spin fa-3x"></i>
					</div>
				</div>
			</div>

			<div id="header-time-sheet">
				<h1>Feuille de temps</h1>

				<div class="date-periode-grp">
					<div id="debut-periode" class="date-periode">
						<label for="debut-periode-input">Debut de la période</label> <input
							id="debut-periode-input" type="date" name="debut-periode"
							value="${feuilleDeTemps.obtDebutPeriode()}" readonly="true">
					</div>
					<div id="fin-periode" class="date-periode">
						<label for="fin-periode-input">Fin de la période</label> <input
							id="fin-periode-input" type="date" name="fin-periode"
							value="${feuilleDeTemps.obtFinPeriode()}" readonly="true">
					</div>
				</div>
			</div>

			<div id="table-wrapper">
				<table class="table time-sheet-table">
					<tr>
						<th class="fixcol2">Taches</th>
						<c:forEach var="jourPeriode"
							items="${feuilleDeTemps.obtListeJoursPeriode()}">
							<th id="${jourPeriode}">${jourPeriode}</th>
						</c:forEach>
					</tr>

					<c:forEach var="tache" items="${feuilleDeTemps.obtTaches()}">
						<tr>
							<td class="fixcol2">${tache.obtTache()}</td>

							<c:forEach var="heure" items="${tache.obtNbHeuresParJours()}">
								<td><input class="time-input" type="text" value="${heure}" /></td>
							</c:forEach>
					</c:forEach>
				</table>
			</div>
			<button id="save-button">Enregistrer</button>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/jquery-ui.js"></script>
	<script src="/resources/js/lib/bootstrap.min.js"></script>
	<script src="/resources/js/utils/jsonRest.js"></script>
	<script src="/resources/js/utils/callback.js"></script>
	<script src="/resources/js/feuilleDeTemps/feuilleDeTemps.js"></script>
</body>
</html>




