package com.stogiapps.miranda

import groovyx.net.http.URIBuilder
import org.ccil.cowan.tagsoup.Parser


class MovieService {

    List<Torrent> findNewTorrents() {
        def torrents = []

        def slurper = new XmlSlurper(new Parser())

        String url = new URIBuilder('http://torrentz-proxy.com')
            .setPath('/search')
            .setQuery(f: ['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'added:1d'].join(' '))
            .toString();

        def main = slurper.parse(url)

        main.'**'
            .findAll { it.name() == 'a' && it.parent().name() == 'dt' }
            .each {
                def movie = slurper.parse("http://torrentz-proxy.com${it.@href}")
                movie.'**'
                    .findAll { it.name() == 'a' && it.parent().name() == 'dt'}
                    .findAll { it.@href.toString().contains('baymirror.com') }
                    .each {
                        def torrent = slurper.parse(it.@href.toString())
                        torrent.'**'
                            .find { it.name() == 'a' && it.parent().@class == 'download' && it.@href.toString().startsWith('magnet') }
                            .each { torrents << new Torrent(magnetLink: it.@href)  }
            }
        }

        torrents
    }
}
