package com.stogiapps.miranda

class Torrent {

    String magnetLink
//    String name

    Torrent(String magnetLink) {
        this.magnetLink = magnetLink
    }

    static constraints = {
        magnetLink(blank: false, matches: /.*dn=[^&]+.*/, unique: true)
    }

//    def beforeInsert() {
//        name = extractNameFromMagnetLink()
//    }

    private String extractNameFromMagnetLink() {
        String displayName = extractDisplayNameFromMagnetLink()
        def parts = displayName.split('\\.')

        int index = 1
        while (index < parts.size()) {
            if (isReleaseYear(parts[index])) {
                break
            }
            index++
        }

        parts[0..index - 1].join(' ')
    }

    private String extractDisplayNameFromMagnetLink() {
        (magnetLink =~ /dn=([^&]*)&/)[0][1]
    }

    private boolean isReleaseYear(String part) {
        part.matches(/[\d]{4}/)
    }

}
