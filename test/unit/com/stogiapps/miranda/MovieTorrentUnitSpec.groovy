package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(MovieTorrent)
class MovieTorrentUnitSpec extends Specification {

    void setup() {
        mockForConstraintsTests(MovieTorrent)
    }

    void 'magnetLink can not be null'() {
        given:
        def torrent = new MovieTorrent()

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'nullable'
        torrent.errors.name == 'nullable'
    }

    @Unroll
    void 'magnetLink can not be blank'() {
        given:
        def torrent = new MovieTorrent(magnetLink)

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'blank'
        torrent.errors.name == 'nullable'

        where:
        magnetLink << ['', ' ']
    }

    void 'magnetLink contains dn (display name) field'() {
        given:
        def torrent = new MovieTorrent('magnet:url')

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'matches'
        torrent.errors.name == 'nullable'
    }

    void 'magnetLink is unique'() {
        given:
        def magnetLink = 'magnet:?xt=exactTopic&dn=displayName&xl=1'

        and:
        new MovieTorrent(magnetLink).save(flush: true)

        and:
        def torrent = new MovieTorrent(magnetLink)

        expect:
        !torrent.validate()
        torrent.errors.magnetLink == 'unique'
        !torrent.errors.name
    }

    @Unroll
    void 'sets name based on magnetLink dn (display name) field'() {
        given:
        def torrent = new MovieTorrent(magnetLink)

        expect:
        torrent.name == expectedName

        where:
        expectedName  | magnetLink
        'Avengers'    | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=Avengers.2012.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        'Escape Plan' | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=Escape.Plan.2013.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        '2012'        | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=2012.2009.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        '9'           | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=9.2010.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
    }

}
