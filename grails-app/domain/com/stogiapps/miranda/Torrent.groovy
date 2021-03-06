package com.stogiapps.miranda

import org.joda.time.DateTime

abstract class Torrent {

    static DISPLAY_NAME_REGEXP = /.*dn=([^&]+).*/

    String magnetLink
    String name
    boolean downloaded = false

    DateTime dateCreated
    DateTime lastUpdated

    Torrent(String magnetLink) {
        this.magnetLink = magnetLink
        name = extractNameFromMagnetLink()
    }

    static constraints = {
        magnetLink(blank: false, matches: DISPLAY_NAME_REGEXP, maxSize: 1000, unique: true)
    }

    protected abstract transient String getQuality()

    protected String extractNameFromMagnetLink() {
        String displayName = extractDisplayNameFromMagnetLink()
        String name = null

        if (displayName) {
            def parts = displayName.split('\\.')

            int index = 1
            while (index < parts.size()) {
                if (parts[index] == quality) {
                    break
                }
                index++
            }

            name = parts[0..index - 1].join(' ')
        }

        name
    }

    protected String extractDisplayNameFromMagnetLink() {
        String displayName = null

        def matcher = magnetLink =~ DISPLAY_NAME_REGEXP
        if (matcher.matches()) {
            displayName = matcher[0][1]
        }

        displayName
    }

}
