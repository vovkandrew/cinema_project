package cinema.model.dto;

import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class TicketRequestDto {
    @NotNull(message = "Ticket id shouldn't be null")
    private Long id;

    public TicketRequestDto() {
    }

    public TicketRequestDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
