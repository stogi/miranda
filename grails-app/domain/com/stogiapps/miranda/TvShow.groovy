package com.stogiapps.miranda

class TvShow {

    String name

    static constraints = {
        name(unique: true)
    }

}
