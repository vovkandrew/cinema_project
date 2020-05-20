package cinema;

import cinema.library.Injector;
import cinema.model.Movie;
import cinema.service.MovieService;

public class Main {
    private static Injector injector = Injector.getInstance("cinema");

    public static void main(String[] args) {
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Lord of the rings");
        movie.setDescription("This is awesome adventure movie!");
        movie = movieService.add(movie);
        movieService.getAll().forEach(Movie::toString);

    }
}
