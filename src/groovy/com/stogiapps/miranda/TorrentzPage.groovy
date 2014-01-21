package com.stogiapps.miranda

class TorrentzPage {

    String url = 'http://torrentz-proxy.com'

    XmlSlurper slurper

    TorrentzPage(XmlSlurper slurper) {
        this.slurper = slurper
    }

    protected boolean isTorrentzLink(node) {
        node.name() == 'a' && node.parent().name() == 'dt'
    }

    protected getAllElements(url) {
        slurper.parse(url).'**'
    }

}
