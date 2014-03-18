package com.stogiapps.miranda

class TvShow {

    String name

    static constraints = {
        name(validator: { value, object ->
            def error
            def existing = TvShow.findByNameIlike(value)
            if (existing && existing.id != object.id) {
                error = ['unique']
            }
            error
        })
    }

}
