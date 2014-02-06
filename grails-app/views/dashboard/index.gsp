<html>
<head>
    <meta name="layout" content="main">
</head>
<body>
    <h2>Latest Movies</h2>

    <section class="table-responsive">
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${movies}" var="movie">
                <tr>
                    <td>${movie.name}</td>
                    <td>
                        <a href="${movie.magnetLink}" class="btn btn-default btn-xs">
                            <i class="glyphicon glyphicon-magnet"></i>
                        </a>
                        <a href="${g.createLink(action: 'download', id: movie.id)}" class="btn btn-primary btn-xs">
                            <i class="glyphicon glyphicon-download"></i>
                        </a>
                    </td>
                </tr>
                </g:each>
            </tbody>
        </table>
    </section>

    <h2>Latest TV Shows</h2>

    <section class="table-responsive">
        <table class="table table-condensed">
            <thead>
            <tr>
                <th>Name</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${tvShows}" var="tvShow">
                <tr>
                    <td>${tvShow.name}</td>
                    <td>
                        <a href="${tvShow.magnetLink}" class="btn btn-default btn-xs">
                            <i class="glyphicon glyphicon-magnet"></i>
                        </a>
                        <a href="${g.createLink(action: 'download', id: tvShow.id)}" class="btn btn-primary btn-xs">
                            <i class="glyphicon glyphicon-download"></i>
                        </a>
                    </td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </section>
</body>
</html>
