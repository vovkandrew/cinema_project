package cinema.controllers;

import cinema.model.dto.MovieSessionRequestDto;
import cinema.model.dto.MovieSessionResponseDto;
import cinema.model.mapper.MovieSessionMapper;
import cinema.service.MovieSessionService;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-sessions")
public class MovieSessionController {
    @Autowired
    private MovieSessionMapper movieSessionMapper;

    @Autowired
    private MovieSessionService movieSessionService;

    @PostMapping
    public void addMovieSession(
            @RequestBody MovieSessionRequestDto movieSessionRequestDto) {
        movieSessionService.add(
                movieSessionMapper.getMovieSessionFromMovieSessionRequestDto(
                        movieSessionRequestDto));
    }

    @GetMapping("/available")
    public List<MovieSessionResponseDto> getAllAvailableMovieSessions(
            @RequestParam Long movieId, @RequestParam String date) {
        return movieSessionService
                .findAvailableSessions(movieId, LocalDate.parse(date))
                .stream()
                .map(session -> movieSessionMapper
                        .getMovieSessionResponseDtoFromMovieSession(session))
                .collect(Collectors.toList());
    }
}
