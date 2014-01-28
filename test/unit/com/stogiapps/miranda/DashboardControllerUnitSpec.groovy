package com.stogiapps.miranda

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DashboardController)
@Build(Torrent)
class DashboardControllerUnitSpec extends Specification {

    TorrentService torrentService

    void setup() {
        torrentService = Mock(TorrentService)
        controller.torrentService = torrentService
    }

    void 'puts latest torrents in model'() {
        given:
        def movies = [
            Torrent.build(),
            Torrent.build(),
            Torrent.build()
        ]

        when:
        def model = controller.index()

        then:
        model.movies == movies
    }

    void 'downloads torrent by id'() {
        given:
        def torrent = Torrent.build()

        when:
        params.id = torrent.id

        and:
        controller.download()

        then:
        1 * torrentService.download(torrent)

        and:
        response.redirectedUrl == '/'
    }

}
