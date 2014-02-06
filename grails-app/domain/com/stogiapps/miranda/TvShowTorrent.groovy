package com.stogiapps.miranda

class TvShowTorrent extends Torrent {

    TvShowTorrent(String magnetLink) {
        super(magnetLink)
    }

    @Override
    protected transient String getQuality() {
        '720p'
    }

}
