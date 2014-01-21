package com.stogiapps.miranda

class Torrent {

    String magnetLink

    static constraints = {
        magnetLink(unique: true)
    }
}
