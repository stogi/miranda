package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Ignore
import spock.lang.Specification

@Ignore
@TestFor(TorrentService)
class TorrentServiceUnitSpec extends Specification {

    void setup() {
        config.uTorrent.url = 'http://127.0.0.1:44822'
        config.uTorrent.username = 'admin'
        config.uTorrent.password = 'P@$$w0rd'
    }

    void 'sends request to uTorrent web API to add new torrent for download'() {
        given:
        def torrent = new Torrent('magnet:?xt=urn:btih:036fdd0632bb432d0c2e2f979c95010a083c7bab&dn=Diana.2013.1080p.BluRay.DTS.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')

        when:
        service.download(torrent)

        then:
        noExceptionThrown()
    }

}
