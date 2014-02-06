dataSource {
    pooled = true
    dialect = org.hibernate.dialect.PostgreSQLDialect
    driverClassName = 'org.postgresql.Driver'
    username = 'stogi'
    password = ''
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = 'update' // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:postgresql://localhost/miranda-dev'
        }
    }
    test {
        dataSource {
            dbCreate = 'update' // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:postgresql://localhost/miranda-test'
        }
    }
    production {
        dataSource {
            dbCreate = 'update' // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:postgresql://localhost/miranda'
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis = 1800000
               timeBetweenEvictionRunsMillis = 1800000
               numTestsPerEvictionRun = 3
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               validationQuery = "SELECT 1"
               jdbcInterceptors = "ConnectionState"
            }
        }
    }
}
