testDataConfig {
    sampleData {
        'com.stogiapps.miranda.MovieTorrent' {
            int index = 1
            magnetLink = { "magnet:?dn=Name.${index++}" }
        }
    }
}
