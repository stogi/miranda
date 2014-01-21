package com.stogiapps.miranda

class TorrentzPage extends AbstractPage {

    String url = 'http://torrentz-proxy.com'

    TorrentzPage(XmlSlurper slurper) {
        super(slurper)
    }

    protected boolean isTorrentzLink(element) {
        element.name() == 'a' && element.parent().name() == 'dt'
    }

}
