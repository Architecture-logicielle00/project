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


    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">RÉSULTATS</a>
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
                        <a href=""><i class="fa fa-fw fa-money"></i> Dépenses</a>
                    </li>
                    <li>
                        <a href=""><i class="fa fa-fw fa-car"></i> Déplacements</a>
                    </li>
                    <li>
                        <a href=""><i class="fa fa-fw fa-tasks"></i> Projets/Tâches</a>
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
    <div id="header-time-sheet">
        <h1>Timesheet</h1>
        <div class="btn-group">
            <button type="button" class="btn btn-default"><i class="fa fa-chevron-left"></i></button>
            <button type="button" class="btn btn-default"><i class="fa fa-chevron-right"></i></button>
        </div>
    </div>

    <div id="table-wrapper">
        <table class="table time-sheet-table">
            <tr>
                <th class="fixcol1">Project</th>
                <th class="fixcol2"> Task</th>
                <th>Mon</th>
                <th>Tue</th>
                <th>Wed</th>
                <th>Thu</th>
                <th>Fri</th>
                <th>Sat</th>
                <th>Sun</th>
            </tr>
            <tr>
                <td class="fixcol1"><span>#145</span> Projet xyz</td>
                <td class="fixcol2"><span>#145-12</span> Lorem ipsum dolor sit amet
                </td>
                <td><input type="text" pattern="\d*"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td class="fixcol1"><span>#145</span> Projet xyz</td>
                <td class="fixcol2"><span>#145-12</span> Lorem ipsum dolor sit amet
                </td>
                <td><input type="text" pattern="\d*"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td class="fixcol1"><span>#145</span> Projet xyz</td>
                <td class="fixcol2"><span>#145-12</span> Lorem ipsum dolor sit amet
                </td>
                <td><input type="text" pattern="\d*"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td class="fixcol1"><span>#145</span> Projet xyz</td>
                <td class="fixcol2"><span>#145-12</span> Lorem ipsum dolor sit amet
                </td>
                <td><input type="text" pattern="\d*"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
                <td><input type="text"/></td>
            </tr>
            <tr id="total-time-row">
                <td class="fixcol1"></td>
                <td class="fixcol2"></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
                <td><input type="text" readonly="true"/></td>
            </tr>
        </table>
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
  
  


