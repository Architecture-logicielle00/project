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
	href="/resources/css/timeSheet.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">

		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper">
			<div id="header-time-sheet">
				<h1>Timesheet</h1>

				<div class="date-periode-grp">
					<div id="debut-periode" class="date-periode">
						<label for="debut-periode-input">Debut de la période</label> <input
							id="debut-periode-input" type="date" name="debut-periode"
							value="${feuilleDeTemps.obtStringDebutPeriode()}" readonly="true">
					</div>
					<div id="fin-periode" class="date-periode">
						<label for="fin-periode-input">Fin de la période</label> <input
							id="fin-periode-input" type="date" name="fin-periode"
							value="${feuilleDeTemps.obtStringFinPeriode()}" readonly="true">
					</div>
				</div>

				<div class="btn-group">
					<button type="button" class="btn btn-default">
						<i class="fa fa-chevron-left"></i>
					</button>
					<button type="button" class="btn btn-default">
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
			</div>

			<div id="table-wrapper">
				<table class="table time-sheet-table">
					<tr>
						<th class="fixcol1">Projets</th>
						<th class="fixcol2">Taches</th>
						<c:forEach var="jourPeriode"
							items="${feuilleDeTemps.obtListeJoursPeriode()}">
							<td id="${jourPeriode}">${jourPeriode}</td>
						</c:forEach>
					</tr>

					<c:forEach var="blocDeTemps" items="${feuilleDeTemps.obtBlocsDeTemps()}">
						<tr>
							<td class="fixcol1"><span></span></td>
							<td class="fixcol2"><span></span></td>
							<c:forEach var="jourPeriode"
								items="${feuilleDeTemps.obtListeJoursPeriode()}">
								<td
									id="${jourPeriode}">
									<input type="text" />
								</td>
							</c:forEach>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->


	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/jquery-ui.js"></script>
	<script src="/resources/js/lib/bootstrap.min.js"></script>
	<script src="/resources/js/feuilleDeTemps/feuilleDeTempsAnimation.js"></script>
	<script
		src="/resources/js/feuilleDeTemps/feuilleDeTempsCommunicationServeur.js"></script>
</body>
</html>




