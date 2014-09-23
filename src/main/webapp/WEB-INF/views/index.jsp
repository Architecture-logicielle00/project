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
    <link type="text/css" rel="stylesheet" href="/resources/css/welcome-div.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css"/>
    <title>Accueil</title>
</head>
<body>
<div id="menu-wrapper">


    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">RÉSULTATS</a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nomUtilisateur} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-gear"></i> Paramètres</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-power-off"></i> Deconnexion</a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="collapse navbar-collapse navbar-ex1-collapse">

                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="/FeuilleDeTemps"><i class="fa fa-fw fa fa-clock-o"></i> Feuille de Temps</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-money"></i> Dépenses</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-car"></i> Déplacements</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-tasks"></i> Projets/Tâches</a>
                    </li>
                    <li>
                        <a href="/CreeUtilisateur""><i class="fa fa-fw fa fa-users"></i> Gestion des Employés</a>
                    </li>
                </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div class="complete-bottom-div"></div>

    <div id="page-wrapper">
        <div id="welcome-div" class="jumbotron">
             <h1>Hello, ${nomUtilisateur}!</h1>
             <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda consequatur dolor error, esse laudantium modi quidem repellat. Assumenda corporis cupiditate eos et facere nesciunt placeat totam unde vero! Numquam, sint?</p>
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


<script src="/resources/js/lib/jquery.js"></script>
<script src="/resources/js/lib/jquery-ui.js"></script>
<script src="/resources/js/lib/bootstrap.min.js"></script>
</body>
</html>