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
                    <th>Magnet</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${movies}" var="movie">
                <tr>
                    <td>${movie.title}</td>
                    <td><a href="${movie.magnetLink}"><i class="glyphicon glyphicon-magnet"></i></a></td>
                </tr>
                </g:each>
            </tbody>
        </table>
    </section>
</body>
</html>
