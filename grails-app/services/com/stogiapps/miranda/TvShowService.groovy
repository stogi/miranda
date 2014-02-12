package com.stogiapps.miranda

class TvShowService {

    TorrentService torrentService

    List<TvShowTorrent> findLatest() {
        latestTorrents.findAll { TvShowTorrent torrent ->
            torrent.save()
        }
    }

    void downloadTracked() {
        def tvShows = TvShow.list()
        def torrents = TvShowTorrent.findAllByDownloaded(false)

        torrents.each { Torrent torrent ->
            tvShows.each { TvShow tvShow ->
                if (torrent.name.startsWith(tvShow.name)) {
                    torrentService.download(torrent)
                }
            }
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
