package com.stogiapps.miranda

class Torrent {

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

    private String extractNameFromMagnetLink() {
        String displayName = extractDisplayNameFromMagnetLink()
        String name = null

        if (displayName) {
            def parts = displayName.split('\\.')

            int index = 1
            while (index < parts.size()) {
                if (isReleaseYear(parts[index])) {
                    break
                }
                index++
            }

            name = parts[0..index - 1].join(' ')
        }

        name
    }

    private String extractDisplayNameFromMagnetLink() {
        String displayName = null

        def matcher = magnetLink =~ DISPLAY_NAME_REGEXP
        if (matcher.matches()) {
            displayName = matcher[0][1]
        }

        displayName
    }

    private boolean isReleaseYear(String part) {
        part.matches(/[\d]{4}/)
    }

}
