package cinema.model.dto;

public class TicketResponseDto {
    private String movieTitle;
    private Long hallId;
    private String showTime;

    public TicketResponseDto() {
    }

    public TicketResponseDto(String movieTitle, Long hallId, String showTime) {
        this.movieTitle = movieTitle;
        this.hallId = hallId;
        this.showTime = showTime;
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

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
