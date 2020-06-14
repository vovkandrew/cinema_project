package cinema.model.dto;

import org.springframework.stereotype.Component;

@Component
public class TicketRequestDto {
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
