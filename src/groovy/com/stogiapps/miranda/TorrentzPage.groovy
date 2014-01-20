package com.stogiapps.miranda

import groovyx.net.http.URIBuilder

class TorrentzPage {

    static String URL = 'http://torrentz-proxy.com'

    XmlSlurper slurper
    String pageUrl

    TorrentzPage(XmlSlurper slurper, String pageUrl = '/search') {
        this.slurper = slurper
        this.pageUrl = pageUrl
    }

    List<TorrentzPage> findLatestMovies() {
        findBy(['1080p', 'bluray', 'dts', 'publichd', 'size > 6g', 'added:1d'])
    }

    private List<TorrentzPage> findBy(query) {
        def path = slurper.parse(buildSearchUrl(query))
        path.'**'
            .findAll(isTorrentzLink)
            .collect { new TorrentzPage(slurper, it.@href.toString()) }
    }

    PirateBayPage getPirateBayPage() {
        def path = slurper.parse(buildTorrentUrl())
        def link = path.'**'
            .findAll(isTorrentzLink)
            .find(isPirateBayLink)
            .@href.toString()
        new PirateBayPage(slurper, link)
    }

    private String buildSearchUrl(List<String> query) {
        new URIBuilder(URL)
            .setPath(pageUrl)
            .setQuery(f: query.join(' '))
            .toString()
    }

    private String buildTorrentUrl() {
        new URIBuilder(URL)
            .setPath(pageUrl)
            .toString()
    }

    private isTorrentzLink = { node ->
        node.name() == 'a' && node.parent().name() == 'dt'
    }

    private isPirateBayLink = { node ->
        isTorrentzLink(node) &&  node.@href.toString().contains('baymirror.com')
    }

}
