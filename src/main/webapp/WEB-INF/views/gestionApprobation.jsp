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
    
    <link rel="stylesheet" href="/resources/css/lib/jquery-ui.min.css"/>
    <link rel="stylesheet" href="/resources/css/lib/theme.css"/>
    <link rel="stylesheet" href="/resources/css/approbation.css"/>
    
    <script src="/resources/js/lib/jquery.js"></script>
    <script src="/resources/js/lib/jquery-ui.js"></script>
    <script src="/resources/js/lib/mustache.js"></script>

    <title>Accueil</title>
</head>
<body>
<div id="menu-wrapper">


	<jsp:include page="./importHtml/_layout.jsp"/>
	
	
    <div id="page-wrapper">
    	<div id="approvals-wrapper">
    		<div id="approvals-list" class="accordion">
    		</div>
		</div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<script id="approval-tpl" type="text/html">
    <h3>{{name}} - {{type}}</h3>

    <div>
        <div class="demand-details">

        </div>
        <div class="buttons-wrapper">
            <button class="btn btn-primary">Accepter</button>
            <button class="btn btn-danger">Refuser</button>
        </div>
    </div>
</script>

<script id="feuille-de-temps-table-tpl" type="text/html">
    <table class="table table-striped">
        <tr>
            <th class="fixcol2">Taches</th>
            {{#joursPeriode}}
            <th id="{{jourPeriode}}">{{jourPeriode}}</th>
            {{/joursPeriode}}
        </tr>
        {{#taches}}
        <tr>
            <td class="fixcol2">{{tache}}</td>
            {{#heures}}
            <td>{{heure}}</td>
            {{/heures}}
        </tr>
        {{/taches}}
        <tr class=commentaires-wrapper>
            <td class="fixcol2">Commentaires</td>
            {{#commentaires}}
            <td><i class="commentaire-btn fa fa-comments-o fa-2x"></i>
                <textarea id="commentaire_{{date}}" class="comment-area" rows="5" cols="20" style="display:none"
                          value="{{commentaire}}">{{commentaire}}</textarea>
            </td>
            {{/commentaires}}
        <tr>
    </table>
</script>
<script id="depenses-deplacements-table-tpl" type="text/html">
    <table class="table table-striped">
        <tr>
            <th>Date</th>
            <th>Distance(Km)</th>
            <th>Cout($/Km)</th>
            <th>Description</th>
        </tr>
        <tr>
            <td class="date">{{date}}</td>
            <td class="distance">{{distance}}</td>
            <td class="cout-km">{{coutKm}}</td>
            <td class="commentaires">{{description}}</td>
        </tr>
    </table>
</script>
<script id="depenses-diverses-table-tpl" type="text/html">
    <table class="table table-striped">
        <tr>
            <th>Date</th>
            <th>Nombre de Repas</th>
            <th>Cout par repas($)</th>
            <th>Coût divers($)</th>
            <th>Coucher($)</th>
            <th>Description</th>
            <th></th>
        </tr>
        <tr>
            <td class="date">{{date}}</td>
            <td class="nbRepas">{{nbRepas}}</td>
            <td class="coutRepas">{{coutRepas}}</td>
            <td class="divers">{{divers}}</td>
            <td class="coucher">{{coucher}}</td>
            <td class="description">{{description}}</td>
        </tr>
    </table>
</script>

<script src="/resources/js/approbation/data.js"></script>
<script src="/resources/js/approbation/drawTable.js"></script>
<script src="/resources/js/approbation/approbation.js"></script>
</body>
</html>  
  
  


