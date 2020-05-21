package cinema.service.impl;

import cinema.dao.MovieDao;
import cinema.library.Inject;
import cinema.library.Service;
import cinema.model.Movie;
import cinema.service.MovieService;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
