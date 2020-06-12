package cinema.service;

import cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    public MovieSession add(MovieSession movieSession);

    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    public MovieSession getById(Long id);
}
