<html>
<head>
    <meta name="layout" content="main">
</head>
<body>
    <h2>Latest Movies</h2>
    <tmpl:list torrents="${movies}"/>

    <h2>Latest TV Shows</h2>
    <tmpl:list torrents="${tvShows}"/>
</body>
</html>
