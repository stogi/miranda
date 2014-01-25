package com.stogiapps.miranda

import org.jsoup.Jsoup

abstract class AbstractPage {

    protected getDocument() {
        Jsoup.connect(url).get()
    }

    abstract protected String getUrl()

}
