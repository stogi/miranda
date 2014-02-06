package com.stogiapps.miranda

class MovieTorrent extends Torrent {

    MovieTorrent(String magnetLink) {
        super(magnetLink)
    }

    @Override
    protected String extractNameFromMagnetLink() {
        String displayName = extractDisplayNameFromMagnetLink()
        String name = null

        if (displayName) {
            def parts = displayName.split('\\.')

            int index = 1
            while (index < parts.size()) {
                if (parts[index] == '1080p') {
                    break
                }
                index++
            }

            name = parts[0..index - 1].join(' ')
        }

        name
    }

}
