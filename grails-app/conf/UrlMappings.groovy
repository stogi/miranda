class UrlMappings {

	static mappings = {
        '/'(controller: 'dashboard')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {}
        }

        "500"(view: '/error')
	}
}
