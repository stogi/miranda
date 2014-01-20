package com.stogiapps.miranda

import groovyx.net.http.URIBuilder

class TorrentzSearchResultPage {

    static String URL = 'http://torrentz-proxy.com'

    XmlSlurper slurper
    String pageUrl

    TorrentzSearchResultPage(XmlSlurper slurper, String pageUrl = '/search') {
        this.slurper = slurper
        this.pageUrl = pageUrl
    }

    PirateBayPage getPirateBayPage() {
        def path = slurper.parse(buildTorrentUrl())
        def link = path.'**'
            .findAll(isTorrentzLink)
            .find(isPirateBayLink)
            .@href.toString()
        new PirateBayPage(slurper, link)
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
