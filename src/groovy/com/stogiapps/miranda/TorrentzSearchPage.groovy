package com.stogiapps.miranda

import groovyx.net.http.URIBuilder

class TorrentzSearchPage extends TorrentzPage {

    TorrentzSearchPage(XmlSlurper slurper) {
        super(slurper)
    }

    List<TorrentzSearchResultPage> findBy(query) {
        getAllElements(buildSearchUrl(query))
            .findAll { isTorrentzLink(it) }
            .collect { new TorrentzSearchResultPage(slurper, it.@href.toString()) }
    }

    private String buildSearchUrl(List<String> query) {
        new URIBuilder(url)
            .setPath('/search')
            .setQuery(f: query.join(' '))
            .toString()
    }

}
