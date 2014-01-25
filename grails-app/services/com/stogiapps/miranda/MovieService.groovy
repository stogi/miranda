package com.stogiapps.miranda

class MovieService {

    static transactional = false

    XmlSlurper slurper

    List<Torrent> findNewTorrents() {
        def torrents = []

        new TorrentzSearchPage(slurper)
            .findBy(['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'added:1d'])
            .each { TorrentzSearchResultPage searchResultPage ->
                torrents << new Torrent(searchResultPage.pirateBayPage.magnetLink)
            }

        torrents
    }

}
