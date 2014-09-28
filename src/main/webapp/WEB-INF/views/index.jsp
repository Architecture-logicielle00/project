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


	<jsp:include page="./importHtml/_layout.jsp"/>

    <div class="complete-bottom-div"></div>

    <div id="page-wrapper">
        <div id="welcome-div" class="jumbotron">
             <h1>Hello, ${utilisateur.obtNomUtilisateur()}!</h1>
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