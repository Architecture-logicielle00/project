<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/index.css"/>
    <title>Connection</title>
</head>
<body>
<header>
    <img src="" alt=""/>
</header>

<div id="main">
    <div id="form-wrapper" class="jumbotron">
        <form class="form-signin" role="form" method="post" action="/">
            <h2 class="form-signin-heading">Connectez-vous à votre compte</h2>
            <input type="text" name="nomUtilisateur" class="form-control" placeholder="Nom utilisateur" required autofocus>
            <input type="password" name="mdp" class="form-control" placeholder="Mot de passe" required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
        </form>
    </div>
</div>
<footer></footer>
</body>
</html>