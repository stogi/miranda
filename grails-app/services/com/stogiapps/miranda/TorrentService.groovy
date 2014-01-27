package com.stogiapps.miranda

import groovyx.net.http.HTTPBuilder

class TorrentService {

    def grailsApplication

    void download(Torrent torrent) {
        def config = grailsApplication.config.uTorrent

        def api = new HTTPBuilder(config.url)
        api.auth.basic(config.username, config.password)

        def token = api.get(path: '/gui/token.html')
        api.get(path: '/gui/', query: [action: 'add-url', token: token, s: torrent.magnetLink])
    }

}
