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
	href="/resources/css/lib/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/css/layout.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">

		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper">


			<div id="depenses-wrapper">
				<table id="table-depense-deplacement" class="table table-striped">
				</table>

				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#nouveau-deplacement-formulaire">
					Ajouter</button>
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="nouveau-deplacement-formulaire">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Nouveau Déplacement</h4>
				</div>
				<div class="modal-body">
					<form id="deplacement-form">
						<label for="distance-input">Distance :</label> <input
							id="distance-input" type="number" /> <label for="cout-km-input">Cout
							(Km) :</label> <input id="cout-km-input" type="number" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
					<button id="bouton-sauvegarde-deplacement" type="button"
						class="btn btn-primary" data-dismiss="modal">Sauvegarder</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->



	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/bootstrap.min.js"></script>
	<script src="/resources/js/lib/mustache.js"></script>	
	<script src="/resources/js/utils/callback.js"></script>
	<script src="/resources/js/utils/date.js"></script>
	<script src="/resources/js/utils/jsonRest.js"></script>
	<script src="/resources/js/deplacementForm/deplacementForm.js"></script>

</body>
</html>




