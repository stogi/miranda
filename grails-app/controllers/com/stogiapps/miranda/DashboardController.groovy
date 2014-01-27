package com.stogiapps.miranda

class DashboardController {

    def torrentService

    def index() {
        [movies: Torrent.list()]
    }

    def download(Long id) {
        torrentService.download(Torrent.get(id))
        redirect(action: 'index')
    }

}
