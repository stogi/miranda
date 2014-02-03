package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(TvShow)
class TvShowUnitSpec extends Specification {

    void setup() {
        mockForConstraintsTests(TvShow)
    }

    @Unroll
    void 'name can not be null'() {
        given:
        def tvShow = new TvShow()

        expect:
        !tvShow.validate()
        tvShow.errors.name == 'nullable'

        where:
        name << [null, '', ' ']
    }

    void 'name is unique'() {
        given:
        def name = 'True Detective'

        and:
        new TvShow(name: name).save(flush: true)

        and:
        def tvShow = new TvShow(name: name)

        expect:
        !tvShow.validate()
        tvShow.errors.name == 'unique'
    }

}
