package com.stogiapps.miranda

class PirateBayPage {

    XmlSlurper slurper
    String pageUrl

    PirateBayPage(XmlSlurper slurper, String pageUrl) {
        this.slurper = slurper
        this.pageUrl = pageUrl
    }

    String getMagnetLink() {
        def path = slurper.parse(pageUrl)
        path.'**'
            .find { it.name() == 'a' && it.parent().@class == 'download' && it.@href.toString().startsWith('magnet') }
            .@href.toString()
    }

}
