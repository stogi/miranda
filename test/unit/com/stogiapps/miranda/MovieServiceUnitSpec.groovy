package com.stogiapps.miranda

import co.freeside.betamax.Betamax
import co.freeside.betamax.Recorder
import co.freeside.betamax.TapeMode
import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import org.junit.Rule
import spock.lang.Specification

@TestFor(MovieService)
@Build(MovieTorrent)
class MovieServiceUnitSpec extends Specification {

    @Rule
    Recorder recorder = new Recorder()

    @Betamax(tape = '6 movies added 1 day ago', mode = TapeMode.READ_ONLY)
    void 'finds new available movies'() {
        when:
        List<MovieTorrent> torrents = service.findLatest()

        then:
        torrents.size() == 6

        and:
        MovieTorrent.count() == 6
    }

    @Betamax(tape = '6 movies added 1 day ago', mode = TapeMode.READ_ONLY)
    void 'already added movies are not saved'() {
        given:
        MovieTorrent.build(magnetLink: 'magnet:?xt=urn:btih:52bc9065779936100fd9bf935a56a224feb5fb0e&dn=Dallas.Buyers.Club.2013.1080p.BluRay.DTS-HD.MA.5.1.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')
        MovieTorrent.build(magnetLink: 'magnet:?xt=urn:btih:036fdd0632bb432d0c2e2f979c95010a083c7bab&dn=Diana.2013.1080p.BluRay.DTS.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')
        MovieTorrent.build(magnetLink: 'magnet:?xt=urn:btih:f3b147c17b311a24366acc1d6868cfe8db36df76&dn=Gloria.2013.1080p.BluRay.DTS.x264-PublicHD&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337')

        expect:
        MovieTorrent.count() == 3

        when:
        List<MovieTorrent> torrents = service.findLatest()

        then:
        torrents.size() == 3

        and:
        MovieTorrent.count() == 6
    }

}
