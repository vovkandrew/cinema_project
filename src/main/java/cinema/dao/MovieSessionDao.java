package cinema.dao;

import cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionDao {
    public MovieSession add(MovieSession movieSession);

    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}
