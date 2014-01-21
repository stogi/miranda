package com.stogiapps.miranda

import groovyx.net.http.URIBuilder

class TorrentzSearchResultPage extends TorrentzPage {

    String pageUrl

    TorrentzSearchResultPage(XmlSlurper slurper, String pageUrl) {
        super(slurper)
        this.pageUrl = pageUrl
    }

    PirateBayPage getPirateBayPage() {
        def link = getAllElements(buildTorrentUrl())
            .findAll { isTorrentzLink(it) }
            .find { isPirateBayLink(it) }
            .@href.toString()
        new PirateBayPage(slurper, link)
    }

    private String buildTorrentUrl() {
        new URIBuilder(url)
            .setPath(pageUrl)
            .toString()
    }

    private boolean isPirateBayLink(node) {
        node.@href.toString().contains('baymirror.com')
    }

}
