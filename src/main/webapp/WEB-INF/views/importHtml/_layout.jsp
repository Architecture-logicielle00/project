    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="">
            <img src ="/resources/img/IconeResultat.jpg">
            </a>
        </div>

        <ul class="nav navbar-right top-nav">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${utilisateur.ObtenirNomUtilisateur()} <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-fw fa-gear"></i> Paramètres</a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="/deconnection"><i class="fa fa-fw fa-power-off"></i> Deconnexion</a>
                    </li>
                </ul>
            </li>
        </ul>

        <div class="collapse navbar-collapse navbar-ex1-collapse">

                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="/feuilleDeTemps"><i class="fa fa-fw fa fa-clock-o"></i> Feuille de Temps</a>
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
 				<c:if test="${utilisateur.EstGestionnaire()}">  
	                 <li>
	                     <a href="/gestionEmployee"><i class="fa fa-fw fa fa-users"></i> Gestion des Employés</a>
	                 </li>
				</c:if>  
                </ul>
        </div>
        <!-- /.navbar-collapse -->
    </nav>

    <div class="complete-bottom-div"></div>
