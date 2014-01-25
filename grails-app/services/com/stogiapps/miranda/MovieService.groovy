package com.stogiapps.miranda

class MovieService {

    static transactional = false

    List<Torrent> findNewTorrents() {
        def torrents = []

        new TorrentzSearchPage(query: ['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'added:7d'])
            .search()
            .each { TorrentzSearchResultPage searchResultPage ->
                torrents << new Torrent(searchResultPage.pirateBayPage.magnetLink)
            }

        torrents
    }

}
