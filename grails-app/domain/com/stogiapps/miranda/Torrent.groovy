package com.stogiapps.miranda

abstract class Torrent {

    static DISPLAY_NAME_REGEXP = /.*dn=([^&]+).*/

    String magnetLink
    String name

    Torrent(String magnetLink) {
        this.magnetLink = magnetLink
        name = extractNameFromMagnetLink()
    }

    static constraints = {
        magnetLink(blank: false, matches: DISPLAY_NAME_REGEXP, unique: true)
    }

    protected abstract String extractNameFromMagnetLink()

    protected String extractDisplayNameFromMagnetLink() {
        String displayName = null

        def matcher = magnetLink =~ DISPLAY_NAME_REGEXP
        if (matcher.matches()) {
            displayName = matcher[0][1]
        }

        displayName
    }

}
