package cinema.model.mapper;

import cinema.model.Ticket;
import cinema.model.dto.TicketResponseDto;
import cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    @Autowired
    private TicketService ticketService;

    public TicketResponseDto getTicketResponseDtoFromTicket(Ticket ticket) {
        return new TicketResponseDto(ticket.getSession().getMovie().getTitle(),
                ticket.getSession().getCinemaHall().getId(),
                ticket.getSession().getTime().toString());
    }
}
