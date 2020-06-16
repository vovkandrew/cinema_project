package cinema.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieRequestDto {
    @NotNull(message = "Every movie should have their own title")
    @Size(min = 5, message = "Movie title can't be less than 5 symbols long")
    private String title;
    @NotNull(message = "Every movie should have their own description")
    @Size(min = 20, message = "Movie description can't be less than 10 symbols long")
    private String description;

    public MovieRequestDto() {
    }

    public MovieRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
