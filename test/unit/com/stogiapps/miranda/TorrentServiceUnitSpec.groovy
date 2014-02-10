package com.stogiapps.miranda

import co.freeside.betamax.Betamax
import co.freeside.betamax.Recorder
import grails.test.mixin.TestFor
import org.junit.Rule
import spock.lang.Ignore
import spock.lang.Specification

// To be sorted out. Problems with Betamax proxy for localhost and different than 80 port.
@Ignore
@TestFor(TorrentService)
class TorrentServiceUnitSpec extends Specification {

    @Rule
    Recorder recorder = new Recorder()

    void setup() {
        config.uTorrent.url = 'http://localhost:44822'
        config.uTorrent.username = 'admin'
        config.uTorrent.password = 'P@$$w0rd'
    }

    @Betamax(tape = '1 torrent added')
    void 'sends request to uTorrent web API to add new torrent for download'() {
        given:
        def torrent = new MovieTorrent('magnet:?xt=urn:btih:036fdd0632bb432d0c2e2f979c95010a083c7bab&dn=Diana.2013.1080p.BluRay.DTS.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')

        when:
        service.download(torrent)

        then:
        noExceptionThrown()

        and:
        torrent.downloaded
    }

}
