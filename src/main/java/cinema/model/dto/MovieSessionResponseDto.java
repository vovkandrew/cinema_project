package cinema.model.dto;

import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseDto {
    private String movieTitle;
    private Long hallId;
    private String showtime;

    public MovieSessionResponseDto() {
    }

    public MovieSessionResponseDto(String movieTitle, Long hallId, String showtime) {
        this.movieTitle = movieTitle;
        this.hallId = hallId;
        this.showtime = showtime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
        this.showtime = showtime;
    }
}
