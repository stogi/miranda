package com.stogiapps.miranda

class MovieTorrent extends Torrent {

    MovieTorrent(String magnetLink) {
        super(magnetLink)
    }

    @Override
    protected transient String getQuality() {
        '1080p'
    }

}
