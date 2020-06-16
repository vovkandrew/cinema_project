package cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MovieSessionRequestDto {
    @NotNull(message = "Movie id shouldn't be null")
    private Long movieId;
    @NotNull(message = "Cinema hall id shouldn't be null")
    private Long cinemaHallId;
    @Pattern(regexp = "^\\\\d{4}-\\\\d{2}-\\\\d{2}$",
            message = "Movie session time should match the following patter YYYY-MM-DD")
    private String time;

    public MovieSessionRequestDto() {
    }

    public MovieSessionRequestDto(Long movieId, Long cinemaHallId, String time) {
        this.movieId = movieId;
        this.cinemaHallId = cinemaHallId;
        this.time = time;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
