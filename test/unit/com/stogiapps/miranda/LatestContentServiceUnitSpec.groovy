package com.stogiapps.miranda

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(LatestContentService)
@Mock(Torrent)
class LatestContentServiceUnitSpec extends Specification {

    MovieService movieService

    void setup() {
        movieService = Mock(MovieService)
        service.movieService = movieService

        movieService.findNewTorrents() >> [
            new Torrent('magnet:?dn=1'),
            new Torrent('magnet:?dn=2'),
            new Torrent('magnet:?dn=3')
        ]
    }

    void 'saves latest movies'() {
        when:
        service.saveLatestMovies()

        then:
        Torrent.count() == 3
    }

    void 'saves only new torrents'() {
        given:
        new Torrent('magnet:?dn=1').save()

        expect:
        Torrent.count() == 1

        when:
        service.saveLatestMovies()

        then:
        Torrent.count() == 3
    }

}
