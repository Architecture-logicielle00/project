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
    <title></title>
</head>
<body>
<header>
    <img src="" alt=""/>
</header>

<div id="main">
    <div id="form-wrapper" class="jumbotron">
        <form class="form-signin" role="form" method="post" action="/">
            <h2 class="form-signin-heading">Sign In to your Account</h2>
            <input type="username" name="nomUtilisateur" class="form-control" placeholder="User name" required autofocus>
            <input type="password" name="mdp" class="form-control" placeholder="Password" required>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
    </div>
</div>
<footer></footer>
</body>
</html>