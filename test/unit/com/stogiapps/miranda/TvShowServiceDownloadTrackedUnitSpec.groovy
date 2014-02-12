package com.stogiapps.miranda

import grails.buildtestdata.mixin.Build
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TvShowService)
@Build([TvShow, TvShowTorrent])
class TvShowServiceDownloadTrackedUnitSpec extends Specification {

    TorrentService torrentService

    void setup() {
        service.torrentService = torrentService = Mock()
    }

    void 'downloads tv show torrents that are tracked'() {
        given:
        TvShow.build(name: 'Breaking Bad')
        TvShow.build(name: 'Game of Thrones')
        TvShow.build(name: 'True Detective')

        and:
        def torrents = [
            new TvShowTorrent('magnet:?dn=Game.of.Thrones.S04E01.720p.HDTV.x264-KILLERS+%5BPub').save(flush: true),
            new TvShowTorrent('magnet:?dn=True.Detective.S01E03.720p.HDTV.x264-KILLERS+%5BPublicHD%5D').save(flush: true),
            new TvShowTorrent('magnet:?dn=The.Big.Bang.Theory.S07E14.720p.HDTV.X264-DIMENSION+%5BPublicHD%5D').save(flush: true)
        ]

        when:
        service.downloadTracked()

        then:
        1 * torrentService.download(torrents[0])
        1 * torrentService.download(torrents[1])

        then:
        0 * _._
    }

}
