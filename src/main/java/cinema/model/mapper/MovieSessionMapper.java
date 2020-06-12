package cinema.model.mapper;

import cinema.model.CinemaHall;
import cinema.model.Movie;
import cinema.model.MovieSession;
import cinema.model.dto.MovieSessionRequestDto;
import cinema.model.dto.MovieSessionResponseDto;
import cinema.service.CinemaHallService;
import cinema.service.MovieService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    @Autowired
    private MovieService movieService;

    @Autowired
    private CinemaHallService cinemaHallService;

    public MovieSession getMovieSessionFromMovieSessionRequestDto(
            MovieSessionRequestDto movieSessionRequestDto) {
        Movie movie = movieService.getById(movieSessionRequestDto.getMovieId());
        CinemaHall cinemaHall = cinemaHallService.getById(
                movieSessionRequestDto.getCinemaHallId());
        LocalDateTime showtime = LocalDateTime.parse(movieSessionRequestDto.getTime());
        return new MovieSession(movie,cinemaHall,showtime);
    }

    public MovieSessionResponseDto getMovieSessionResponseDtoFromMovieSession(
            MovieSession movieSession) {
        String movieTitle = movieSession.getMovie().getTitle();
        Long hallId = movieSession.getCinemaHall().getId();
        String showtime = movieSession.getTime().toString();
        return new MovieSessionResponseDto(movieTitle, hallId, showtime);
    }
}
