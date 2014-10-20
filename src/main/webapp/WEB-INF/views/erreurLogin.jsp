<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	window.setTimeout(function(){
	    window.location.href = "/";
	}, 5000);
</script>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="/resources/css/main.css" media="all" />
	<title>Erreur</title>
</head>
<body>
	<div id="page-wrapper" align="center">
		<h1>Votre nom d'utilisateur (${nomUtilisateur}) ou votre mot de passe est invalide.</h1>
		<p>Si vous avez oublié votre mot de passe ou qu'il s'agit de votre première connexion merci de contacter votre superviseur.</p>
		
		<p>Vous serez redirigé vers la page de connexion sous peu.</p>
		<p>Si tel n'est pas le cas cliquer <a href='/'>Ici</a>.</p>
	</div>
</body>
</html>