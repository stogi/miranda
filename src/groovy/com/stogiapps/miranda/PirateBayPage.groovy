package com.stogiapps.miranda

class PirateBayPage extends AbstractPage {

    String pageUrl

    PirateBayPage(String pageUrl) {
        this.pageUrl = pageUrl
    }

    String getMagnetLink() {
        document.select('.download a')
            .first().attr('href')
    }

    @Override
    protected String getUrl() {
        pageUrl
    }

}
