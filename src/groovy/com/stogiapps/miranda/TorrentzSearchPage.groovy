package com.stogiapps.miranda

import groovyx.net.http.URIBuilder

class TorrentzSearchPage extends TorrentzPage {

    List<String> query

    List<TorrentzSearchResultPage> search() {
        document.select('.results dt a')
            .collect { new TorrentzSearchResultPage(it.attr('href')) }
    }

    @Override
    protected String getUrl() {
        new URIBuilder(super.url)
            .setPath('/search')
            .setQuery(f: query.join(' '))
            .toString()
    }

}
