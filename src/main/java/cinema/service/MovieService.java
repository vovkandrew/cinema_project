package cinema.service;

import cinema.model.Movie;
import java.util.List;

public interface MovieService {
    public Movie add(Movie movie);

    public List<Movie> getAll();

    public Movie getById(Long id);
}
