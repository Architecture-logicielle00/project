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
	href="/resources/css/timeSheet.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">
		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper">
			<h1>Création d'un utilisateur</h1>

			<form id="posttoolbar" class="comment" action="/creationEmployee" method="post">
				<p class="contact">
					<label for="name">Nom:</label>
				</p>
				<input id="name" name="name" placeholder="First and last name"
					required="" tabindex="1" type="text" style="width: 300px">

				<p class="contact">
					<label for="name">Prénom:</label>
				</p>
				<input id="prenom" name="prenom" placeholder="First and last name"
					required="" tabindex="1" type="text" style="width: 300px">

				<p class="contact">
					<label for="name">Adresse courriel:(S'il y a lieu)</label>
				</p>
				<input id="email" name="email" placeholder="example@domain.com"
					required="" type="email" style="width: 300px">

				<p class="contact">Nom de l'usager:</p>
				<input id="username" name="username" placeholder="username"
					required="" tabindex="2" type="text" style="width: 300px">

				<p class="contact">Pays:</p>
				<input id="pays" name="pays" placeholder="username" required=""
					tabindex="2" type="text" style="width: 300px">

				<p class="contact">Région/Province:</p>
				<input id="province" name="province" placeholder="username"
					required="" tabindex="2" type="text" style="width: 300px">

				<p class="contact">Ville:</p>
				<input id="ville" name="ville" placeholder="username" required=""
					tabindex="2" type="text" style="width: 300px">

				<p class="contact">Code postal:</p>
				<input id="codepos" name="codepos" placeholder="username"
					required="" tabindex="2" type="text" style="width: 300px">

				<p class="contact">Mot de passe (temporaire):</p>
				<input type="password" id="password" name="password" required=""
					style="width: 300px">

				<p class="contact">Confirmer votre mot de passe:</p>
				<input type="password" id="repassword" name="repassword" required=""
					style="width: 300px">

				<br>Sexe <select class="select-style gender" id="gender" name="gender">
					<option value="select"></option>
					<option value="m">Male</option>
					<option value="f">Female</option>
					<option value="others">Other</option>
				</select><br>
				<p class="contact">
					<label for="phone">Téléphone (domicile)</label>
				</p>
				<input id="phone" name="phone" placeholder="phone number"
					required="" type="text" style="width: 300px"> <br> <br>
					
				<input class="buttom" name="Entrer" id="submit" tabindex="10"
					value="Valider" type="submit" style="width: 119px; height: 50px">					
			</form>

		</div>
	</div>
	<!-- /#wrapper -->
	
		<script src="/resources/js/lib/jquery.js"></script>
		<script src="/resources/js/creationEmployee/creationEmployee.js"></script>
</body>
</html>
