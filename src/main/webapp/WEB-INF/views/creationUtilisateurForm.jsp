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

			<!-- 		<form method="POST" action="/CreeUtilisateur">
			<table>
				<tr>
					<td>
						Nom du nouvel utilisateur :
					</td>
					<td>
						<input type="text" name="nomUtilisateurNouveauCompte">
					</td>
				</tr>
				<tr>
					<td>
						Mot de passe du nouvel utilisateur :
					</td>
					<td>
						<input type="password" name="mdp">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" name="connecter">
					</td>
				</tr>
			</table>
		</form> -->

		<script src="/resources/js/lib/jquery.js"></script>

			<script>
			
				function sauvegarderEmployer() {
					
					alert("Début de la sauvegarde");
					
					   var utilisateur = {
					    	"nom" : document.getElementById("name").innerHTML,
							"prenom" : document.getElementById("prenom").innerHTML,
							"email" : document.getElementById("email").innerHTML,
							"nomUsager" : document.getElementById("username").innerHTML,
							"pays" : document.getElementById("pays").innerHTML,
							"province" : document.getElementById("province").innerHTML,
							"ville" : document.getElementById("ville").innerHTML,
							"codePostal" : document.getElementById("codepos").innerHTML,
							"mdp" : document.getElementById("password").innerHTML,
						
							"mois" : document.getElementById("BirthMonth").innerHTML,
							"jour" : document.getElementById("BirthDay").innerHTML,
							"annee" : document.getElementById("BirthYear").innerHTML,
						
							"sexe" : document.getElementById("gender").innerHTML,
							"telephone" : document.getElementById("phone").innerHTML
					   }
					   
					   $.ajax({
					      type: "POST",
					      contentType : 'application/json; charset=utf-8',
					      dataType : 'json',
					      url: "/ajax/CreeUtilisateur",
					      data: JSON.stringify(utilisateur), // Note it is important
					      success :function(result) {
					    	  alert("Employer sauvegardé");
					     }
					  });
				
			</script>

			<form id="posttoolbar" class="comment">
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

				<p class="contact">Date de naissance:</p>
				<fieldset class="ModalContent" style="width: 722px; height: 59px;">
					<br>Mois<label class="month"> <select
						class="select-style" id="BirthMonth" name="BirthMonth">
							<option value=""></option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option></label> </select> <label>jour <input
						class="birthday" maxlength="2" id="BirthDay" name="BirthDay" placeholder="Day"
						required=""></label> Année<label> <input class="birthyear"
						maxlength="4" id="BirthYear" name="BirthYear" placeholder="Year" required=""
						style="width: 154px"></label> <br> <br>

				</fieldset>
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
					value="Valider" type="submit" style="width: 119px; height: 50px"
					onclick="sauvegarderEmployer()">					
			</form>

		</div>
	</div>
	<!-- /#wrapper -->
</body>
</html>
