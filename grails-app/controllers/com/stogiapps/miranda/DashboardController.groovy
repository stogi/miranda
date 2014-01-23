package com.stogiapps.miranda

class DashboardController {

    def index() {
        [movies: Torrent.list()]
    }

}
