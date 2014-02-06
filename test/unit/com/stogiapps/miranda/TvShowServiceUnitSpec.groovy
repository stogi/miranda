package com.stogiapps.miranda

import co.freeside.betamax.Betamax
import co.freeside.betamax.Recorder
import co.freeside.betamax.TapeMode
import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import org.junit.Rule
import spock.lang.Specification

@TestFor(TvShowService)
@Build(TvShowTorrent)
class TvShowServiceUnitSpec extends Specification {

    @Rule
    Recorder recorder = new Recorder()

    @Betamax(tape = '7 tv shows added 1 day ago', mode = TapeMode.READ_ONLY)
    void 'finds new available tv shows torrents'() {
        when:
        List<TvShowTorrent> torrents = service.findLatest()

        then:
        torrents.size() == 7

        and:
        TvShowTorrent.count() == 7
    }

    @Betamax(tape = '7 tv shows added 1 day ago', mode = TapeMode.READ_ONLY)
    void 'already added tv shows torrents are not saved'() {
        given:
        TvShowTorrent.build(magnetLink: 'magnet:?xt=urn:btih:ab54000f6445708713daec49725858cf246d7720&dn=CSI.S14E14.720p.HDTV.X264-DIMENSION+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')
        TvShowTorrent.build(magnetLink: 'magnet:?xt=urn:btih:ee3c88c029efb1d3bcceeb03d67c54be62aa5c33&dn=Republic.of.Doyle.S05E15.720p.HDTV.x264-2HD+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')
        TvShowTorrent.build(magnetLink: 'magnet:?xt=urn:btih:230a9060f7db00112e26d7510f25d57b333c8d2c&dn=Opposite.Worlds.S01E05.Time.720p.HDTV.x264-DHD+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')

        expect:
        TvShowTorrent.count() == 3

        when:
        List<TvShowTorrent> torrents = service.findLatest()

        then:
        torrents.size() == 4

        and:
        TvShowTorrent.count() == 7
    }

}
