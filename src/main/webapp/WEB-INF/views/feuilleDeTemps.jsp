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

			</div>

			<div id="table-wrapper">
				<table class="table table-striped time-sheet-table">
				</table>
			</div>
			<button class="btn btn-primary" id="save-button">Enregistrer</button>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/jquery-ui.js"></script>
	<script src="/resources/js/lib/bootstrap.min.js"></script>
	<script src="/resources/js/lib/mustache.js"></script>
	<script src="/resources/js/utils/date.js"></script>	
	<script src="/resources/js/utils/jsonRest.js"></script>
	<script src="/resources/js/utils/callback.js"></script>
	<script src="/resources/js/feuilleDeTemps/feuilleDeTemps.js"></script>
</body>
</html>




