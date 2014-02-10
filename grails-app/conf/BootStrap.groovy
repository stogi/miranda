import com.stogiapps.miranda.MovieService
import com.stogiapps.miranda.TvShowService

class BootStrap {

    MovieService movieService
    TvShowService tvShowService

    def init = { servletContext ->
        movieService.findLatest()
        tvShowService.findLatest()
    }

    def destroy = {
    }

}
