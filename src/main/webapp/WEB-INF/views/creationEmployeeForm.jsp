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

		<div id="page-wrapper" align="center">
			<h1>Création d'un utilisateur</h1>
				<form id="posttoolbar" class="comment">
					<table>
						<tr>
							<td>
								<label for="username">Nom d'utilisateur: </label>
							</td>
							<td>
								<input id="username" name="username" required type="text" style="width: 300px" tabindex="1">
							</td>
						</tr>
						<tr>
							<td>
								<label for="gestionnaire">Est gestionnaire? </label>
							</td>
							<td>
								<input type="checkbox" id="gestionnaire" name="gestionnaire" value="gestionnaire" tabindex="2">
							</td>
						</tr>
						<tr>
							<td>
								<label for="name">Nom: </label>
							</td>
							<td>
								<input id="name" name="name" required type="text" style="width: 300px" tabindex="3">
							</td>
						</tr>
						<tr>
							<td>
								<label for="prenom">Prénom: </label>
							</td>
							<td>
								<input id="prenom" name="prenom" required type="text" style="width: 300px" tabindex="4">
							</td>
						</tr>
						<tr>
							<td>
								<label for="email">Adresse courriel: </label>
							</td>
							<td>
								<input id="email" name="email" required type="email" style="width: 300px" tabindex="5">
							</td>
						</tr>
						<tr>
							<td>
								<label for="pays">Pays: </label>
							</td>
							<td>
								<input id="pays" name="pays" required type="text" style="width: 300px" tabindex="6">
							</td>
						</tr>
						<tr>
							<td>
								<label for="province">Province: </label>
							</td>
							<td>
								<input id="province" name="province" required type="text" style="width: 300px" tabindex="7">
							</td>
						</tr>
						<tr>
							<td>
								<label for="ville">Ville: </label>
							</td>
							<td>
								<input id="ville" name="ville" required type="text" style="width: 300px" tabindex="8">
							</td>
						</tr>
						<tr>
							<td>
								<label for="codepos">Code Postal: </label>
							</td>
							<td>
								<input id="codepos" name="codepos" required type="text" style="width: 300px" tabindex="9">
							</td>
						</tr>
						<tr>
							<td>
								<label for="gender">Genre: </label>
							</td>
							<td>
								<select class="select-style gender" id="gender" name="gender" tabindex="10">
									<option value="select"></option>
									<option value="m">Homme</option>
									<option value="f">Femme</option>
									<option value="others">Autre</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="phone">Téléphone (domicile): </label>
							</td>
							<td>
								<input id="phone" name="phone" required type="text" style="width: 300px" tabindex="11">
							</td>
						</tr>	
						<tr>
							<td>
								<label for="motDePasse">Mot de passe par default : </label>
							</td>
							<td>
								<input id="motDePasse" name="motDePasse" type="text" style="width: 300px" tabindex="11" value="12345" readonly>
							</td>
						</tr>	
					</table>
					<button name="Entrer" id="envoyer" style="width: 70px; height: 30px" tabindex="12" >Envoyer</button>	
					<input id="btn" type="submit" value="Search">				
				</form>
				
		</div>
	</div>
	<!-- /#wrapper -->
	
		<script src="/resources/js/lib/jquery.js"></script>
		<script src="/resources/js/utils/jsonRest.js"></script>
		<script src="/resources/js/creationEmployee/creationEmployee.js"></script>
</body>
</html>
