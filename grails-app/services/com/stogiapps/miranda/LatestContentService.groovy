package com.stogiapps.miranda

class LatestContentService {

    MovieService movieService

    void saveLatestMovies() {
        movieService.findNewTorrents().each { Torrent torrent ->
            torrent.save()
        }
    }

}
