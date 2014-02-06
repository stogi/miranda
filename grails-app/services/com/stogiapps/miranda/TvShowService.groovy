package com.stogiapps.miranda

class TvShowService {

    List<TvShowTorrent> findLatest() {
        latestTorrents.findAll { TvShowTorrent torrent ->
            torrent.save()
        }
    }

    private getLatestTorrents() {
        new TorrentzSearchPage(query: ['720p', 'tv', 'shows', 'publichd', '-complete', '-season', 'size > 1g', 'added:1d'])
                .search()
                .collect { TorrentzSearchResultPage searchResultPage ->
            new TvShowTorrent(searchResultPage.pirateBayPage.magnetLink)
        }
    }
}
