package com.stogiapps.miranda

class MovieService {

    List<Torrent> findLatest() {
        latestTorrents.findAll { Torrent torrent ->
            torrent.save()
        }
    }

    private getLatestTorrents() {
        new TorrentzSearchPage(query: ['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'size < 20g', 'added:1d'])
            .search()
            .collect { TorrentzSearchResultPage searchResultPage ->
                new Torrent(searchResultPage.pirateBayPage.magnetLink)
            }
    }

}
