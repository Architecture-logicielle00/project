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
				<table id="table-depense-diverse" class="table table-striped">
				</table>

				<button type="button" class="btn btn-primary btn-lg"
					data-toggle="modal" data-target="#nouveau-diverse-formulaire">
					Ajouter</button>
			</div>

		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="nouveau-diverse-formulaire">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Nouvelle dépense</h4>
				</div>
				<div class="modal-body">
					<form id="diverse-form">
						<label for="nbRepas-input"> 
						Nombre de Repas :</label> <input id="nbRepas-input" type="number" /> 
						<label for="coutRepas-input"> 
						Cout par Repas :</label> <input id="coutRepas-input" type="number" />
						<label for="divers-input"> 
						Cout Divers :</label> <input id="divers-input" type="number" /> 
						<label for="coucher-input">
						Nuité :</label> <input id="coucher-input" type="number" />
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
					<button id="bouton-sauvegarde-diverse" type="button"
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
	<script src="/resources/js/diverseForm/diverseForm.js"></script>

</body>
</html>




