package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(TvShowTorrent)
class TvShowTorrentUnitSpec extends Specification {

    @Unroll
    void 'sets name based on magnetLink dn (display name) field'() {
        given:
        def torrent = new TvShowTorrent(magnetLink)

        expect:
        torrent.name == expectedName

        where:
        expectedName                           | magnetLink
        'Marvels Agents of S H I E L D S01E13' | 'magnet:?xt=urn:btih:967cfafa0479aca09ef7773d01237df9988d8ecb&dn=Marvels.Agents.of.S.H.I.E.L.D.S01E13.720p.HDTV.x264-KILLERS+%5BPub&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        'Arrow S02E13'                         | 'magnet:?xt=urn:btih:5505168ed75fc0288861668d84b4db5f0ee078e1&dn=Arrow.S02E13.720p.HDTV.X264-DIMENSION+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        'The Big Bang Theory S07E14'           | 'magnet:?xt=urn:btih:511677da9d47abddf34de5973e3cf5ca3d29d619&dn=The.Big.Bang.Theory.S07E14.720p.HDTV.X264-DIMENSION+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
        'True Detective S01E03'                | 'magnet:?xt=urn:btih:feba109342e53e439740d6498b8c832f6f493bdb&dn=True.Detective.S01E03.720p.HDTV.x264-KILLERS+%5BPublicHD%5D&tr=udp%3A%2F%2Ftracker.openbittorrent.com%3A80&tr=udp%3A%2F%2Ftracker.publicbt.com%3A80&tr=udp%3A%2F%2Ftracker.istole.it%3A6969&tr=udp%3A%2F%2Ftracker.ccc.de%3A80&tr=udp%3A%2F%2Fopen.demonii.com%3A1337'
    }

}
