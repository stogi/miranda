testDataConfig {
    sampleData {
        'com.stogiapps.miranda.Torrent' {
            int index = 1
            magnetLink = { "magnet:?dn=Name.${index++}" }
        }
    }
}
