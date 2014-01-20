package com.stogiapps.miranda

class MovieService {

    XmlSlurper slurper

    List<Torrent> findNewTorrents() {
        def torrents = []

        new TorrentzPage(slurper).findLatestMovies().each { TorrentzPage page ->
            torrents << new Torrent(magnetLink: page.pirateBayPage.magnetLink)
        }

        torrents
    }

}
