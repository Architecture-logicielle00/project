<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href=""> <img
			src="/resources/img/IconeResultat.jpg">
		</a>
	</div>

	<ul class="nav navbar-right top-nav">
		<li class="dropdown"><a id="utilisateur-dropdown" href="#" class="dropdown-toggle"
			data-toggle="dropdown"><i class="fa fa-user"></i>${utilisateur.obtNomUtilisateur()}<b class="caret"></b>
			</a>
			<ul class="dropdown-menu">
				<li><a href="/deconnection"><i
						class="fa fa-fw fa-power-off"></i> Deconnexion</a></li>
			</ul></li>
	</ul>

	<div class="collapse navbar-collapse navbar-ex1-collapse">

		<ul class="nav navbar-nav side-nav">
			<li><a href="/feuilleDeTemps"><i
					class="fa fa-fw fa fa-clock-o"></i>Mes Feuilles de Temps</a>
			</li>
			<li>
				<a href="/deplacementForm"><i class="fa fa-fw fa-money"></i>Mes Depenses relatives aux deplacements</a>
			</li>
			<li>
				<a href="/diverseForm"><i class="fa fa-fw fa-money"></i>Mes Depenses diverses</a>
			</li>
			<c:if test="${utilisateur.estGestionnaire()}">
				<li><a href="/gestionEmployee"><i
						class="fa fa-fw fa fa-users"></i> Gestion des employes</a></li>
			</c:if>
			<c:if test="${utilisateur.estGestionnaire()}">
				<li><a href="/gestionTaches"><i
						class="fa fa-fw fa fa-tasks"></i> Gestion des tâches</a></li>
			</c:if>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</nav>

<div class="complete-bottom-div"></div>
