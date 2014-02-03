<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Miranda</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li ${controllerName == 'dashboard' ? 'class=active' : ''}><a href="${createLink(controller: 'dashboard')}">Dashboard</a></li>
                <li ${controllerName == 'tvShow' ? 'class=active' : ''}><a href="${createLink(controller: 'tvShow')}">TV Shows</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>