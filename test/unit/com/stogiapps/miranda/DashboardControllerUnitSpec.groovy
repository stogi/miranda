package com.stogiapps.miranda

import grails.buildtestdata.mixin.Build
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DashboardController)
@Build([MovieTorrent, TvShowTorrent])
class DashboardControllerUnitSpec extends Specification {

    TorrentService torrentService

    void setup() {
        controller.torrentService = torrentService = Mock()
    }

    void 'puts latest torrents in model'() {
        given:
        def movies = [
            MovieTorrent.build(),
            MovieTorrent.build(),
            MovieTorrent.build()
        ]

        def tvShows = [
            TvShowTorrent.build(),
            TvShowTorrent.build(),
            TvShowTorrent.build()
        ]

        when:
        def model = controller.index()

        then:
        model.movies == movies
        model.tvShows == tvShows
    }

    void 'downloads torrent by id'() {
        given:
        def torrent = MovieTorrent.build()

        when:
        params.id = torrent.id

        and:
        controller.download()

        then:
        response.redirectedUrl == '/'

        and:
        1 * torrentService.download({ it.id == torrent.id && it instanceof Torrent })

        then:
        0 * _._
    }

}
