package com.stogiapps.miranda

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(TvShow)
@Unroll
class TvShowUnitSpec extends Specification {

    void setup() {
        mockForConstraintsTests(TvShow)
    }

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
        new TvShow(name: name).save(flush: true)

        and:
        def tvShow = new TvShow(name: 'True Detective')

        expect:
        !tvShow.validate()
        tvShow.errors.name == 'unique'

        where:
        name << ['True Detective', 'true detective', 'TRUE DETECTIVE']
    }

    void 'updates without error'() {
        given:
        def tvShow = new TvShow(name: 'True Detective').save(flush: true)

        expect:
        tvShow.validate()
    }

}
