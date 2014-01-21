package com.stogiapps.miranda

class PirateBayPage extends AbstractPage {

    String pageUrl

    PirateBayPage(XmlSlurper slurper, String pageUrl) {
        super(slurper)
        this.pageUrl = pageUrl
    }

    String getMagnetLink() {
        getAllElements(pageUrl)
            .find { isMagnetLink(it) }
            .@href.toString()
    }

    private boolean isMagnetLink(element) {
        element.name() == 'a' && element.parent().@class == 'download' && element.@href.toString().startsWith('magnet')
    }

}
