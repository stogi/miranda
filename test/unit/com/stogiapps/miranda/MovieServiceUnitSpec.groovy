package com.stogiapps.miranda

import co.freeside.betamax.Betamax
import co.freeside.betamax.Recorder
import grails.test.mixin.TestFor
import org.ccil.cowan.tagsoup.Parser
import org.junit.Rule
import spock.lang.Specification

@TestFor(MovieService)
class MovieServiceUnitSpec extends Specification {

    @Rule
    Recorder recorder = new Recorder()

    @Betamax(tape = 'sample')
    void 'finds new available movies'() {
        when:
        List<Torrent> torrents = service.findNewTorrents()

        then:
        torrents.size() == 12
    }
}
