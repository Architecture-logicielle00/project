<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>

    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/bootstrap-theme.css.map"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/lib/font-awesome.min.css"/>
    <link type="text/css" rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>

<div id=wrapper>

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

<script src="./js/lib/jquery.js"></script>
<script src="./js/lib/jquery-ui.js"></script>
<script src="./js/lib/bootstrap.min.js"></script>
<script src="js/script.js"></script>
</body>

</html>