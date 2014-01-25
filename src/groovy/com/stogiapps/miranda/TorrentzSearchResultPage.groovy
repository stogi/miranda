package com.stogiapps.miranda

import groovyx.net.http.URIBuilder
import org.jsoup.nodes.Node

class TorrentzSearchResultPage extends TorrentzPage {

    String pageUrl

    TorrentzSearchResultPage(String pageUrl) {
        this.pageUrl = pageUrl
    }

    PirateBayPage getPirateBayPage() {
        def link = document.select('.download dt a')
            .find { isPirateBayLink(it) }
            .attr('href')
        new PirateBayPage(link)
    }

    @Override
    protected String getUrl() {
        new URIBuilder(super.url)
            .setPath(pageUrl)
            .toString()
    }

    private boolean isPirateBayLink(Node node) {
        node.attr('href').contains('baymirror.com')
    }

}
