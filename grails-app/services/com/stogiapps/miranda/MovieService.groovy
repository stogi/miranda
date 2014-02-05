package com.stogiapps.miranda

class MovieService {

    List<MovieTorrent> findLatest() {
        latestTorrents.findAll { MovieTorrent torrent ->
            torrent.save()
        }
    }

    private getLatestTorrents() {
        new TorrentzSearchPage(query: ['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'size < 20g', 'added:1d'])
            .search()
            .collect { TorrentzSearchResultPage searchResultPage ->
                new MovieTorrent(searchResultPage.pirateBayPage.magnetLink)
            }
    }

}
