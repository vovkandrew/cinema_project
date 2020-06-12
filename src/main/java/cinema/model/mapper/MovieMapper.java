package cinema.model.mapper;

import cinema.model.Movie;
import cinema.model.dto.MovieRequestDto;
import cinema.model.dto.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public Movie getMovieFromMovieRequestDto(MovieRequestDto movieRequestDto) {
        return new Movie(movieRequestDto.getTitle(), movieRequestDto.getDescription());
    }

    public MovieResponseDto getMovieResponseDtoFromMovie(Movie movie) {
        return new MovieResponseDto(movie.getTitle(), movie.getDescription());
    }
}
