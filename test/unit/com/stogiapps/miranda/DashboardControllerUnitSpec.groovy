package com.stogiapps.miranda

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(DashboardController)
@Build(Torrent)
class DashboardControllerUnitSpec extends Specification {

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

}
