grails {
    mongo {
        environments {
            development {
                databaseName = 'miranda-dev'
            }

            test {
                databaseName = 'miranda-test'
            }

            production {
                databaseName = 'miranda'
            }
        }
    }
}


