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
		<div id="employee-card">

    	</div>
    	<div id="employee-list">
        	<ul>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
            	<li class="list-group-item">Lorem, Ipsum</li>
        	</ul>
        	<button id="add-new-employee-btn" class="btn btn-primary">Add New Employee</button>
    	</div>
    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->


<script src="/resources/js/lib/jquery.js"></script>
<script src="/resources/js/lib/jquery-ui.js"></script>
<script src="/resources/js/lib/bootstrap.min.js"></script>
<script src="/resources/js/employeeManagement/employeeManagement.js"></script>	
</body>
</html>  
  
  


