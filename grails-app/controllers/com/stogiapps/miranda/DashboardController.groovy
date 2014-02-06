package com.stogiapps.miranda

class DashboardController {

    def torrentService

    def index() {
        [movies: MovieTorrent.list(), tvShows: TvShowTorrent.list()]
    }

    def download(Long id) {
        torrentService.download(Torrent.findById(id))
        redirect(action: 'index')
    }

}
