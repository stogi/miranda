package com.stogiapps.miranda

import spock.lang.Specification

class FindLatestContentJobUnitSpec extends Specification {

    FindLatestContentJob job

    MovieService movieService
    TvShowService tvShowService

    void setup() {
        job = new FindLatestContentJob()
        job.movieService = movieService = Mock()
        job.tvShowService = tvShowService = Mock()
    }

    void 'uses services to find new content'() {
        when:
        job.execute()

        then:
        1 * movieService.findLatest()
        1 * tvShowService.findLatest()

        then:
        1 * tvShowService.downloadTracked()

        then:
        0 * _._
    }

}
