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
				<form id="posttoolbar" class="comment">
					<table>
						<tr>
							<td>
								<label for="username">Nom d'utilisateur:</label>
							</td>
							<td>
								<input id="username" name="username" required="" tabindex="2" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="gestionnaire">Est gestionnaire?</label>
							</td>
							<td>
								<input type="checkbox" id="gestionnaire" name="gestionnaire" value="gestionnaire">
							</td>
						</tr>
						<tr>
							<td>
								<label for="name">Nom:</label>
							</td>
							<td>
								<input id="name" name="name" required="" tabindex="1" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="prenom">Prénom:</label>
							</td>
							<td>
								<input id="prenom" name="prenom" required="" tabindex="1" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="email">Adresse courriel:</label>
							</td>
							<td>
								<input id="email" name="email" required="" type="email" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="pays">Pays:</label>
							</td>
							<td>
								<input id="pays" name="pays" required=""tabindex="2" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="province">Province:</label>
							</td>
							<td>
								<input id="province" name="province" required="" tabindex="2" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="ville">Ville:</label>
							</td>
							<td>
								<input id="ville" name="ville" required="" tabindex="2" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="codepos">Code Postal:</label>
							</td>
							<td>
								<input id="codepos" name="codepos" required="" tabindex="2" type="text" style="width: 300px">
							</td>
						</tr>
						<tr>
							<td>
								<label for="gender">Genre:</label>
							</td>
							<td>
								<select class="select-style gender" id="gender" name="gender">
									<option value="select"></option>
									<option value="m">Male</option>
									<option value="f">Female</option>
									<option value="others">Other</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="phone">Téléphone (domicile):</label>
							</td>
							<td>
								<input id="phone" name="phone" required="" type="text" style="width: 300px">
							</td>
						</tr>	
					</table>						
				</form>
				<button name="Entrer" id="envoyer" tabindex="10" style="width: 119px; height: 50px">envoyer</button>
		</div>
	</div>
	<!-- /#wrapper -->
	
		<script src="/resources/js/lib/jquery.js"></script>
		<script src="/resources/js/creationEmployee/creationEmployee.js"></script>
</body>
</html>
