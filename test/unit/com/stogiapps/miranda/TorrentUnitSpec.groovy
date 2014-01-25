package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Ignore
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

    void 'magnetLink contains dn (display name) field'() {
        given:
        def torrent = new Torrent('magnet:url')

        expect:
        !torrent.validate(['magnetLink'])
        torrent.errors.magnetLink == 'matches'
    }

    void 'magnetLink is unique'() {
        given:
        def magnetLink = 'magnet:?xt=exactTopic&dn=displayName&xl=1'

        and:
        new Torrent(magnetLink).save(flush: true)

        and:
        def torrent = new Torrent(magnetLink)

        expect:
        !torrent.validate(['magnetLink'])
        torrent.errors.magnetLink == 'unique'
    }

    @Ignore
    @Unroll
    void 'sets name based on magnetLink dn (display name) field'() {
        given:
        def torrent = new Torrent(magnetLink).save()

        expect:
        torrent.name == name

        where:
        name          | magnetLink
        'Avengers'    | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=Avengers.2012.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        'Escape Plan' | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=Escape.Plan.2013.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        '2012'        | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=2012.2009.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        '9'           | 'magnet:?xt=urn:btih:e382bea15e896a2ffd999d041a3e9171e9cbfd6e&dn=9.2010.1080p.BluRay.DTS-HD.MA.7.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
    }

}
