package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Torrent)
class TorrentUnitSpec extends Specification {

    void setup() {
        mockForConstraintsTests(Torrent)
    }

    void 'magnetLink can not be null'() {
        given:
        def torrent = new Torrent()

        expect:
        !torrent.validate(['magnetLink'])
        torrent.errors.magnetLink == 'nullable'
    }

    @Unroll
    void 'magnetLink can not be blank'() {
        given:
        def torrent = new Torrent(magnetLink)

        expect:
        !torrent.validate(['magnetLink'])
        torrent.errors.magnetLink == 'blank'

        where:
        magnetLink << ['', ' ']
    }

    void 'magnetLink is unique'() {
        given:
        new Torrent('magnet:url').save(flush: true)

        and:
        def torrent = new Torrent('magnet:url')

        expect:
        !torrent.validate(['magnetLink'])
        torrent.errors.magnetLink == 'unique'
    }

}
