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
        Torrent torrent = new Torrent(magnetLink: magnetLink)

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'nullable'

        where:
        magnetLink << [null, '', ' ']
    }
}
