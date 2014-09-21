<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css" media="all" />
	<title>Création</title>
</head>
<body>
	<h1>Création d'un utilisateur</h1>
	
	<form method="post" action="/CreeUtilisateur">
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
	</form>
	
</body>
</html>