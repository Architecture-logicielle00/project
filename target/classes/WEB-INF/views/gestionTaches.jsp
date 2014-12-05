<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap.css.map" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap-theme.min.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/bootstrap-theme.css.map" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/lib/font-awesome.min.css" />
<link type="text/css" rel="stylesheet" href="/resources/css/layout.css" />
<link type="text/css" rel="stylesheet"
	href="/resources/css/gestionTaches.css" />
<title>Accueil</title>
</head>
<body>
	<div id="menu-wrapper">
		<jsp:include page="./importHtml/_layout.jsp" />

		<div id="page-wrapper" align="center">
			<div id="assign-task-wrapper">
				<div id="employees-list"></div>
				<div id="projects-list"></div>
			</div>
			<button id="save-button" class="btn btn-primary">Save</button>
		</div>
	</div>
	<!-- /#wrapper -->

	<script id="employees-list-tpl" type="text/html">
    <ul>
        {{#employees}}
        <li>
            <button class="btn btn-default employee-button">{{name}}</button>
        </li>
        {{/employees}}
    </ul>
	</script>
	<script id="projects-tasks-tpl" type="text/html">
    <form>
        <ul>
            {{#projects}}
            <li class="project">
                <input class="project-checkbox" type="checkbox"/>
                <span>{{name}}</span>
                <div class="task-list">
                    <form>
                        <ul>
                            {{#tasks}}
                            <li class="task">
                                <input class="task-checkbox" type="checkbox"/>
                                <span>{{name}}</span>
                            </li>
                            {{/tasks}}
                        </ul>
                    </form>
                </div>
            </li>
            {{/projects}}
        </ul>
    </form>
	</script>
	
	<script src="/resources/js/lib/jquery.js"></script>
	<script src="/resources/js/lib/mustache.js"></script>
	<script src="/resources/js/utils/jsonRest.js"></script>
	<script src="/resources/js/gestionTaches/gestionTaches.js"></script>
</body>
</html>
