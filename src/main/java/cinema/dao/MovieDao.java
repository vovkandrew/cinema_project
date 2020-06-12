package cinema.dao;

import cinema.model.Movie;
import java.util.List;

public interface MovieDao {
    public Movie add(Movie movie);

    public List<Movie> getAll();

    public Movie getById(Long id);
}
