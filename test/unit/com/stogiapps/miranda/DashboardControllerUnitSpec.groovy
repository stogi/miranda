package com.stogiapps.miranda

import grails.buildtestdata.mixin.Build
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DashboardController)
@Build(MovieTorrent)
class DashboardControllerUnitSpec extends Specification {

    TorrentService torrentService

    void setup() {
        torrentService = Mock(TorrentService)
        controller.torrentService = torrentService
    }

    void 'puts latest torrents in model'() {
        given:
        def movies = [
            MovieTorrent.build(),
            MovieTorrent.build(),
            MovieTorrent.build()
        ]

        when:
        def model = controller.index()

        then:
        model.movies == movies
    }

    void 'downloads torrent by id'() {
        given:
        def torrent = MovieTorrent.build()

        when:
        params.id = torrent.id

        and:
        controller.download()

        then:
        1 * torrentService.download({ it.id == torrent.id && it instanceof Torrent })

        and:
        response.redirectedUrl == '/'
    }

}
