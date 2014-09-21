<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css" media="all" />
	<title>Accueil</title>
</head>
<body>
	<h1>Bienvenue sur notre super site web monsieur ${nomUtilisateur}</h1>
	
	<c:if test="${nouveauCompte != null}">
		<h2>Le compte utilisateur ${nouveauCompte} à bien été crée</h2>
	</c:if>
	
	<p>
		<a href="/CreeUtilisateur">Crée un utilisateur</a>
	</p>
	<p>
		<a href="/FeuilleDeTemps">Acceder à la feuille de temps</a>
	</p>
</body>
</html>