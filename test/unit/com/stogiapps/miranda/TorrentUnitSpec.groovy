package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Torrent)
class TorrentUnitSpec extends Specification {

    void setup() {
        mockForConstraintsTests(Torrent)
    }

    @Unroll
    void 'magnetLink is required'() {
        given:
        def torrent = new Torrent(magnetLink: magnetLink)

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'nullable'

        where:
        magnetLink << [null, '', ' ']
    }

    void 'magnetLink is unique'() {
        given:
        new Torrent(magnetLink: 'magnet:url').save(flush: true)

        and:
        def torrent = new Torrent(magnetLink: 'magnet:url')

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'unique'
    }
}
