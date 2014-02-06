testDataConfig {
    sampleData {
        'com.stogiapps.miranda.MovieTorrent' {
            int index = 1
            magnetLink = { "magnet:?dn=Movie.${index++}" }
        }

        'com.stogiapps.miranda.TvShowTorrent' {
            int index = 1
            magnetLink = { "magnet:?dn=TvShow.${index++}" }
        }
    }
}
