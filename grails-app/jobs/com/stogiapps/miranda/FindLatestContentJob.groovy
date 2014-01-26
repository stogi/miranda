package com.stogiapps.miranda

class FindLatestContentJob {

    MovieService movieService

    static triggers = {
        cron name: 'findLatestContentTrigger', cronExpression: '0 0 * * * ?'
    }

    def execute() {
        movieService.findLatest()
    }
}
