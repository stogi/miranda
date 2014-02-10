<section class="table-responsive">
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${torrents}" var="torrent">
            <tr>
                <td>${torrent.name}</td>
                <td>
                    <a href="${torrent.magnetLink}" class="btn btn-default btn-xs">
                        <i class="glyphicon glyphicon-magnet"></i>
                    </a>
                    <a href="${g.createLink(action: 'download', id: torrent.id)}" class="btn btn-primary btn-xs ${torrent.downloaded ? 'disabled' : ''}">
                        <i class="glyphicon glyphicon-download"></i>
                    </a>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>
</section>