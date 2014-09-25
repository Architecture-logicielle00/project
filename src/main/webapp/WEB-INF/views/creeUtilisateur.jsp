<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
   	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/layout.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/timeSheet.css"/>
    <title>Accueil</title>
</head>
<body>
<div id="menu-wrapper">
	<jsp:include page="./importHtml/_layout.jsp"/>
	
    <div id="page-wrapper">
		<h1>Création d'un utilisateur</h1>
	
		<form method="POST" action="/CreeUtilisateur">
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
	</div>
</div>
<!-- /#wrapper -->
</body>
</html>  