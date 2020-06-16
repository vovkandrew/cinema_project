package cinema.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CinemaHallRequestDto {
    @Min(value = 30, message = "Cinema hall capacity can't be less than 30 seats")
    private int capacity;
    @NotNull(message = "Every cinema hall should have their own hall description")
    @Size(max = 10, message = "Cinema hall description can't be less than 10 symbols long")
    private String description;

    public CinemaHallRequestDto() {
    }

    public CinemaHallRequestDto(int capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
