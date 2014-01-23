package com.stogiapps.miranda

class Torrent {

    String magnetLink

    Torrent(String magnetLink) {
        this.magnetLink = magnetLink
    }

    static constraints = {
        magnetLink(blank: false, unique: true)
    }

}
