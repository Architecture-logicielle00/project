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
<script src="/resources/js/feuilleDeTemps/timeSheetAnimation.js"></script>	
<script src="/resources/js/feuilleDeTemps/timeSheetServerCommunication.js"></script>	
</body>
</html>  
  
  


