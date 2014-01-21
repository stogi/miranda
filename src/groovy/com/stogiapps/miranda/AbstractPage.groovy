package com.stogiapps.miranda

class AbstractPage {

    XmlSlurper slurper

    AbstractPage(XmlSlurper slurper) {
        this.slurper = slurper
    }

    protected getAllElements(url) {
        slurper.parse(url).'**'
    }

}
